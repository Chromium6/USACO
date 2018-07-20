package ai.weka;
import java.io.*; // data reading
import weka.classifiers.*;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.*;
import weka.classifiers.rules.*;
import weka.classifiers.trees.*;
import weka.core.*;

/**
 * @source https://www.programcreek.com/2013/01/a-simple-machine-learning-example-in-java/
 * 
 * @param exampleData.txt properly formatted data
 * */

public class Example {
	
	/** Run through a dataset, with a specified test and train subsets
	 * 
	 * @param model the strategy used for ML processing
	 * @param training the part of dataset used for training model
	 * @param test the part of dataset used for testing trained model
	 * 
	 * @return trained and evaluated classifier
	 * */
	public static Evaluation classify(Classifier model, Instances training, Instances test) throws Exception {
		// create module for set evaluation and train it
		Evaluation eval = new Evaluation(training);
		
		// create the classifier that uses the specified technique
		model.buildClassifier(training);
		// apply the trained model to testing set
		eval.evaluateModel(model, test);
		
		return eval;
	}
	
	/** Calculate the accuracy of a trained classifier 
	 * 
	 * @param guess store the inputs in a FastVector (part of Weka)
	 * 
	 * @return the accuracy expressed as a percentage
	 * */
	public static double getAccuracy(FastVector guess) {
		double accurate = 0;
		
		for (int item = 0; item < guess.size(); item ++) {
			// parse the element
			NominalPrediction attempt = (NominalPrediction) guess.elementAt(item);
			if (attempt.predicted() == attempt.actual())
				accurate ++;
		}
		
		return 100*accurate/guess.size();
	}
	
	/** Partitions a dataset into k congruent subsets.
	 * In this case, this is used to create the training and test sets
	 * 
	 * @param data full dataset to be partitioned
	 * @param partitionSize maximum size of a single partition
	 * 
	 * @returns a training set (0) and a test set (1)
	 * */
	public static Instances[][] crossValidation(Instances data, int partitionSize) {
		Instances[][] partitions = new Instances[2][partitionSize];
		
		for (int i = 0; i < partitionSize; i ++) {
			partitions[0][i] = data.trainCV(partitionSize, i);
			partitions[1][i] = data.testCV(partitionSize, i);
		}
		
		return partitions;
	}
	
	/** Compact file-opening file
	 * 
	 * @param fileName absolute filepath to the file to be opened
	 * 
	 * @return BufferedReader to file
	 * 
	 * @throws IOException file doesn't exist
	 * */
	public static BufferedReader openFile(String fileName) {
		try {
			return new BufferedReader(new FileReader(fileName));
		}
		catch (IOException ioe) {
			System.err.println("Error 404: File Not Found [" + ioe.getLocalizedMessage() + "]");
			return null;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader stdin = openFile("/home/khryo/Desktop/00/18/Docs/USACO/Java/src/ai/weka/exampleData.txt");
		
		// format data
		Instances data = new Instances(stdin);
		data.setClassIndex(data.numAttributes()-1);
		
		// partition the dataset in two 10 pieces
		Instances[][] partitions = crossValidation(data, 10);
		Instances[] trainSet = partitions[0];
		Instances[] testSet = partitions[1];
		
		// Use a set of classifiers
		Classifier[] models = { 
				new J48(), // a decision tree
				new PART(), 
				new DecisionTable(),//decision table majority classifier
				new DecisionStump(), //one-level decision tree
				new ZeroR() // Simplest of classifiers
		};
		
		// Run for each model
		for (int j = 0; j < models.length; j++) {	 
			// Collect every group of predictions for current model in a FastVector
			FastVector predictions = new FastVector();
 
			// For each training-testing split pair, train and test the classifier
			for (int i = 0; i < trainSet.length; i++) {
				Evaluation validation = classify(models[j], trainSet[i], testSet[i]);
 
				predictions.appendElements(validation.predictions());
 
				// Uncomment to see the summary for each training-testing pair.
			//System.out.println(models[j].toString());
			}
 
			// Calculate overall accuracy of current classifier on all splits
			double accuracy = getAccuracy(predictions);
 
			// Print current classifier's name and accuracy in a complicated,
			// but nice-looking way.
			System.out.println("Accuracy of " + models[j].getClass().getSimpleName() + ": "
					+ String.format("%.5f%%", accuracy) // 5 decimal place accuracy
					+ "\n---------------------------------");
		}
	}
 
}
