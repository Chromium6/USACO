package chromium.proj1;

import processing.core.*;

public class RandomColors extends PApplet {
    int unit = 10, dx, dy;

    public void setup() {
        noStroke();
    }

    public void settings() {
        size(500, 500);
    }

    public void draw() {
        for (int i = 0; i < height/unit; i ++) {
            for (int j = 0; j < width/unit; j ++) {
                dx = abs(j*unit-mouseX);
                dy = abs(i*unit-mouseY);
                fill(255-dx, 255-dy, (dx+dy)/3);
                rect(j*unit, i * unit, unit, unit);
            }
        }
    }

    public static void main(String[] args) {
	    PApplet.main("chromium.proj1.Run");
    }
}
