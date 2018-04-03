package genetic.alpha;

public class Person {
	// how long genetic data is (default 5)
	int size = 5;
	// binary genetic data 
	byte data[] = new byte[size];
	// updated fitness
	int fitness = -1;
	
	// creating a random person
	public void init() {
		data = new byte[size];
		// randomize the bit for each gene
		for (int i = 0; i < data.length; i ++) {
			data[i] = (byte) Math.round(Math.random());
		}
	}
	
	// data modification
	public int getSize() {
		return size;
	}
	
	public byte getGene(int index) {
		return data[index];
	}
	
	public int getFitness() {
		if (fitness == -1) {
			fitness = FitnessCalc.findFitness(this);
		}
		return fitness;
	}
	
	public void setSize(int value) {
		size = value;
		data = new byte[size];
	}
	
	public void setGene(int index, byte value) {
		data[index] = value;
	}
	
	// functional methods
	public String seeData() {
		String format = "";
		for (byte n : data) {
			format += n;
		}
		return format;
	}
	
	
}
