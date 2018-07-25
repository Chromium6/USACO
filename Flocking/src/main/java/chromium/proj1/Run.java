package chromium.proj1;

import processing.core.*;

import java.util.*;

public class Run extends PApplet {
    private int unit;
    // optimized local grid model
    List<List<Boid>> grid;
    Boid test;

    public void setup() {

    }

    public void settings() {
        size(500, 500);
        unit = 10;
        grid = new ArrayList<List<Boid>>(height/unit);
        test = new Boid(this, 100, 100, false);
    }

    public void draw() {
        background(0);
        test.seek(new PVector(mouseX, mouseY));
        fill(255);
        test.display();
    }

    public static void main(String[] args) {
        PApplet.main("chromium.proj1.Run");
    }
}
