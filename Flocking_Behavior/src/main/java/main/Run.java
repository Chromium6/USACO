package main;

import bodies.Boid;
import processing.core.*;
import java.util.*;

public class Run extends PApplet {
    Grid arena;
    Boid test;

    public void settings() {
        size(500, 500);
        arena = new Grid(width*1, 10);
        Boid.p = this;
        Boid.arena = arena;
        test = new Boid(200, 200);
    }

    public void draw() {
        background(0);
        test.target(new PVector(mouseX, mouseY));
        test.update();
        for (int i = 0; i < arena.n; i ++) {
            for (int j = 0; j < arena.n; j ++) {
                if (!arena.map.get(arena.flatten(j, i)).isEmpty()) {
                    fill(255, 0, 0);
                    rect((j-0.5f)*arena.unit, (i-0.5f)*arena.unit, arena.unit, arena.unit);
                }
            }
        }
        fill(255);
        test.appear(5);
    }

    public static void main(String[] args) {
        PApplet.main("main.Run");
    }
}
