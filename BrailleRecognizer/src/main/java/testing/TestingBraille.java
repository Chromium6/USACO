package testing;

import org.neuroph.core.NeuralNetwork;

public class TestingBraille {
    public static void main(String[] args) {
        NeuralNetwork nnet = NeuralNetwork.load("C:\\Users\\Michael Zhang\\Documents\\NetBeansProjects\\BrailleCustomRecognize\\Neural Networks\\DigtalProcessor.nnet");
        nnet.setInput(new double[] {
                1.0, 0.0, 0.0, 0.0, 0.0, 0.0
        });
        nnet.calculate();
        double[] out = nnet.getOutput();
        for (int i = 0; i < out.length; i ++) {
            if (out[i] == 1.0) {
                System.out.println((int)(97+i));
                break;
            }
        }
    }

}
