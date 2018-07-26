package chromium.proj1;

import processing.core.*;

public class CardiacVisual extends PApplet {
    Cardiac machine;

    @Override
    public void settings() {
        machine = new Cardiac();
        size(500, 500);

    }

    @Override
    public void draw() {

    }

    public static void main(String[] args) {
        PApplet.main("chromium.proj1.CardiacVisual");
    }
}
