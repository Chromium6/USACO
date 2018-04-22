package turing.neural;

public class NeuralNet {
	NeuronLayer[] layers; // hidden and output layer
	float[] result; // store the output from a run
	
	public NeuralNet(float[][][] weights) {
		layers = new NeuronLayer[weights.length];
		for (int i = 0; i < getSize(); i ++)
			layers[i] = new NeuronLayer(weights[i]);
	}
	
	public int getSize() {
		return layers.length;
	}
	
	public void fireForward(float[] inputs) {
		float[] passData = inputs;
		for (int i = 0; i < getSize(); i ++) {
			passData = layers[i].evalInput(passData);
		}
		result = passData;
	}
	
	public float[] getResult() {
		return result;
	}
}
