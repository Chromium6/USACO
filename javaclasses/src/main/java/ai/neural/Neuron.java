package ai.neural;

public class Neuron {
	private float[] weights; // weights for inputs
	private float bias; // non-zero guarantee
	private float c; // learning rate
	
	/* init */
	public Neuron(int n, boolean random) {
		java.util.Random key = new java.util.Random();
		weights = new float[n];
		if (random) {
			for (int i = 0; i < n; i ++) {
				setWeight(i, (float)(key.nextFloat()*2-0.5));
			}
			bias = (float)(key.nextFloat()*2-0.5);
		}
	}
	
	public Neuron(float[] weights) {
		this.weights = weights;
	}
	
	/* methods */
	public float feedFoward(float[] inputs) {
		float rawSum = 0;
		for (int i = 0; i < inputs.length; i ++) {
			rawSum += inputs[i]*weights[i];
		}
		rawSum += bias;
		return rawSum; // for steering benefits, don't sign
	}
	
	private int sign(float raw) {
		// generic sign function
		return (raw > 0 ? 1 : -1);
	}
	
	/* for supervised learning
	public void train(int[] inputs, int correct) {
		int guess = feedFoward(inputs);
		for (int i = 0; i < weights.length; i ++) {
			weights[i] += (correct-guess)*inputs[i]*c;
		}
	}*/
	
	public int size() { // number of inputs
		return weights.length;
	}
	
	public void setWeight(int index, float val) {
		weights[index] = val;
	}
	
	public void setBias(float val) {
		bias = val;
	}
	
	public void setLearningRate(float val) {
		c = val;
	}
}
