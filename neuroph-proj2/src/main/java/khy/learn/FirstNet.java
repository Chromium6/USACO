package khy.learn;
import org.neuroph.core.*;
import org.neuroph.core.data.*;
import org.neuroph.nnet.*;

public class FirstNet {
	
	public static void main(String[] args) {
		/* Neural Net Creation
		// create new perceptron network
		NeuralNetwork neuralNetwork = new Perceptron(2, 1);
		// create training set
		DataSet trainingSet =
		 new DataSet(2, 1);
		// add training data to training set (logical OR function)
		trainingSet. addRow (new DataSetRow (new double[]{0, 0},
		 new double[]{0}));
		trainingSet. addRow (new DataSetRow (new double[]{0, 1},
		 new double[]{1}));
		trainingSet. addRow (new DataSetRow (new double[]{1, 0},
		 new double[]{1}));
		trainingSet. addRow (new DataSetRow (new double[]{1, 1},
		 new double[]{1}));
		// learn the training set
		neuralNetwork.learn(trainingSet);
		// save the trained network into file
		neuralNetwork.save("or_perceptron.nnet"); */
		
		// load the saved network
		NeuralNetwork neuralNetwork = NeuralNetwork.createFromFile("or_perceptron.nnet");
		// set network input
		neuralNetwork.setInput(1, 0);
		// calculate network
		neuralNetwork.calculate();
		// get network output
		System.out.println(neuralNetwork.getOutput()[0]);
	}

}