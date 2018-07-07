package ai.neural;

public class NeuronLayer {
	Neuron[] data; // all neurons in the layer
	
	public NeuronLayer(int neurons, int inputs, boolean random) {
		data = new Neuron[neurons];
		for (int i = 0; i < neurons; i ++) {
			
		}
	}
	
	public NeuronLayer(float[][] weights) {
		data = new Neuron[weights.length];
		for (int i = 0; i < getSize(); i ++)
			data[i] = new Neuron(weights[i]);
	}
	
	public int getSize() {
		return data.length;
	}
	
	public float[] evalInput(float[] in) {
		float[] out = new float[getSize()];
		for (int i = 0; i < getSize(); i ++)
			out[i] = data[i].feedFoward(in);
		return out;
	}
}
