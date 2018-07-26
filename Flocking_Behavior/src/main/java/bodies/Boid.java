package bodies;

import main.Grid;
import processing.core.*;

public class Boid {
    public static PApplet p;
    // dp
    public static Grid arena;
    int lastUX, lastUY; // unit x, y in previous frame
    // physics
    public PVector loc, vel, acc;
    private final float maxForce = 0.05f, maxSpeed = 1;

    public Boid(int ix, int iy) {
        loc = new PVector(ix, iy);
        vel = new PVector(0, 0);
        acc = new PVector(0, 0);
        lastUX = p.round(loc.x/arena.unit);
        lastUY = p.round(loc.y/arena.unit);
        arena.map.get(arena.flatten(lastUX, lastUY)).add(this);
    }

    public void target(PVector targ) {
        PVector intended = PVector.sub(targ, loc);
        intended.setMag(maxSpeed);
        PVector steer = PVector.sub(intended, vel);
        steer.limit(maxForce);
        applyForce(steer);
    }

    public void update() {
        vel.add(acc);
        vel.limit(maxSpeed);
        loc.add(vel);
        acc.mult(0);
        wrapBorder(-5);
        int uX = p.round(loc.x/arena.unit);
        int uY = p.round(loc.y/arena.unit);
        if (uX != lastUX || uY != lastUY) {
            arena.map.get(arena.flatten(lastUX, lastUY)).remove(this);
            lastUX = uX;
            lastUY = uY;
            arena.map.get(arena.flatten(lastUX, lastUY)).add(this);
        }
    }

    private void applyForce(PVector f) {
        acc.add(f);
    }

    public void wrapBorder(int leeway) {
        if (loc.x < leeway) loc.x = arena.getSideLength()-leeway;
        if (loc.y < leeway) loc.y = arena.getSideLength()-leeway;
        if (loc.x > arena.getSideLength()-leeway) loc.x = leeway;
        if (loc.y > arena.getSideLength()-leeway) loc.y = leeway;
    }

    public void appear(int r) {
        // Draw a triangle rotated in the direction of velocity
        float theta = vel.heading() + p.radians(90);
        p.pushMatrix();
        p.translate(loc.x, loc.y);
        p.rotate(theta);
        p.beginShape(p.TRIANGLES);
        p.vertex(0, -r*2);
        p.vertex(-r, r*2);
        p.vertex(r, r*2);
        p.endShape();
        p.popMatrix();
    }
}
