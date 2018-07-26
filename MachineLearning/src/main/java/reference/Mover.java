package reference;

import processing.core.*;
import org.neuroph.nnet.MultiLayerPerceptron;

public class Mover {
    public static PVector target = new PVector(450, 450);
    public Main stage;
    MultiLayerPerceptron mind;
    public PVector loc;
    PApplet p;

    public Mover(PApplet parent, Main stageParent, int ix, int iy) {
        mind = new MultiLayerPerceptron(9, 5, 8);
        loc = new PVector(ix, iy);
        p = parent;
        stage = stageParent;
    }

    public void step() {
        mind.randomizeWeights();
        double[] collectedData = new double[9]; // eight for boundaries, one for heurustic
        int counter = 0;
        // 1 2  3
        // 4 [] 5
        // 6 7  8
        for (int i = -1; i < 2; i ++) {
            for (int j = -1; j < 2; j ++) {
                if (loc.x + i < 0 || loc.x + i > p.width ||
                        loc.y + j < 0 || loc.y + j > p.height) collectedData[counter] = -1;
                else collectedData[counter] = stage.cellStates[(int)(loc.x+i)][(int)(loc.y+j)];
                counter ++;
            }
        }
        collectedData[8] = Math.sqrt((loc.x-target.x)*(loc.x-target.x)+(loc.y-target.y)*(loc.y-target.y));
        System.out.print("[");
        for (double i : collectedData)
            System.out.print(String.format("%.3f ", i));
        System.out.print("] -> [");
        mind.setInput(collectedData);
        mind.calculate();
        double[] output = mind.getOutput();
        for (double i : output)
            System.out.print(String.format("%.3f ", i));
        int maxIndex = 0;
        double maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < output.length; i ++) {
            if (output[i] > maxVal) {
                maxIndex = i;
                maxVal = output[i];
            }
        }
        int dx = 0, dy = 0;
        switch (maxIndex) {
            case 0:
                dx = -1;
                dy = -1;
                break;
            case 1:
                dy = -1;
                break;
            case 2:
                dx = 1;
                dy = -1;
                break;
            case 3:
                dx = -1;
                break;
            case 4:
                dx = 1;
                break;
            case 5:
                dx = -1;
                dy = 1;
                break;
            case 6:
                dy = 1;
                break;
            case 7:
                dx = 1;
                dy = 1;
                break;
        }
        System.out.print("], moving to option " + maxIndex + ", location updated from " + String.format("[%.1f, %.1f]", loc.x, loc.y));
        loc.x = p.constrain(loc.x+dx, 0, p.width);
        loc.y = p.constrain(loc.y+dy, 0, p.height);
        System.out.println(String.format(" to [%.1f, %.1f]", loc.x, loc.y));
    }
}