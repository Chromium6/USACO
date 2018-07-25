package chromium.proj1;

import processing.core.*;

public class Boid {
    PApplet p;
    /* physics */
    private static int radius = 5;
    private final float maxForce = 0.5f, maxSpeed = 10.0f;
    private boolean flowBoundaries; // should objects "teleport" when they reach the boundaries
    PVector loc, vel, acc;

    public Boid(PApplet processing, int ix, int iy, boolean flow) {
        p = processing;
        loc = new PVector(ix, iy);
        flowBoundaries = flow;
        vel = new PVector(0, 0);
        acc = new PVector(0, 0);
    }

    public void seek(PVector target) {
        PVector error = PVector.sub(target, loc);
        error.normalize();
        error.mult(maxSpeed);
        PVector seek = PVector.sub(error, vel);
        seek.limit(maxForce);
        applyForce(seek);
    }

    public void applyForce(PVector f) {
        acc.add(f);
    }

    public void update() {
        vel.add(acc);
        vel.limit(maxSpeed);
        loc.add(vel);
        acc.mult(0);

        // boundary conditions
        if (flowBoundaries) {
            vel.x %= p.width;
            vel.y %= p.height;
        }
    }

    public void display() {
        float theta = vel.heading() + p.PI/2;
        p.stroke(0);
        p.pushMatrix();
        p.translate(loc.x,loc.y);
        p.rotate(theta);
        p.beginShape();
        p.vertex(0, -radius*2);
        p.vertex(-radius, radius*2);
        p.vertex(radius, radius*2);
        p.endShape(p.CLOSE);
        p.popMatrix();
    }
}
