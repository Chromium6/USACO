package ai.neural.firstNeuroph;

import org.neuroph.core.*; // import upper-level classes
import org.neuroph.nnet.*; // import neural net types
import org.neuroph.core.data.*; // import dataset types

public class BasicUsage {

	public static void main(String[] args) {
		/* ESTABLISHMENT AND TRAINING */
		// create a NeuralNetwork of type Perceptrons with 2 inputs, 1 output
		NeuralNetwork firstNet = new Perceptron(2, 1);
		
		// construct the training set to match NeuralNet's inputs and outputs
		DataSet data = new DataSet(2, 1);
		data.addRow(new double[] {0, 0}, // format input and output rows
				new double[] {0});
		data.addRow(new double[] {0, 1},
				new double[] {0});
		data.addRow(new double[] {1, 0},
				new double[] {0});
		data.addRow(new double[] {1, 1},
				new double[] {1});
		
		// train the NeuralNet with the DataSet
		firstNet.learn(data);
		
		// save the NeuralNet to file (".nnet")
		firstNet.save("AND.nnet");
		
		/* APPLICATION */
		// load a saved NeuralNet from a file (".nnet")
		//NeuralNetwork savedNet = NeuralNetwork.load("AND.nnet");
		
		// feed foward
		//savedNet.setInput(1, 1);
		//savedNet.calculate();
		// double[] result = savedNet.getOutput();
	}

}
