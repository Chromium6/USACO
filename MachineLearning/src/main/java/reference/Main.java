package reference;

import processing.core.PApplet;

public class Main extends PApplet {
    int[][] cellStates;
    Mover joe;

    public void settings() {
        size(500, 500);
        cellStates = new int[500][500];
        for (int i = 0; i < 500; i ++) {
            for (int j = 0; j < 500; j ++) {
                cellStates[i][j] = (int)random(0, 3);
            }
        }
        joe = new Mover(this, this, 250, 250);
        System.out.print("Weights are [");
        Double[] w = joe.mind.getWeights();
        for (double l : w)
            System.out.print(String.format("%.3f ", l));
        System.out.println();
    }

    public void draw() {
        repaint();
        joe.step();
        cellStates[(int)joe.loc.x][(int)joe.loc.y] = 3;
        fill(255, 0, 0);
        ellipse(joe.loc.x, joe.loc.y, 5, 5);
        fill(0, 0, 255);
        rect(Mover.target.x-5, Mover.target.y-5, 10, 10);
        //delay(100);
    }

    public void repaint() {
        for (int i = 0; i < cellStates.length; i ++) {
            for (int j = 0; j < cellStates[0].length; j ++) {
                switch(cellStates[j][i]) {
                    case 0:
                        set(j, i, color(255));
                        break;
                    case 1:
                        set(j, i, color(0));
                        break;
                    case 2:
                        set(j, i, color(0, 255, 0));
                        break;
                    case 3:
                        set(j, i, color(255, 255, 0));
                        break;
                }
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("reference.Main");
    }

}