package genetic.beta;

// contains the genotype (change the data type of genes if necessary)
public class DNA {
	// binary genetic info (default length 5)
	byte data[] = new byte[5];
	
	/* init */
	public void init() {
		// randomizes the genes
		for (int i = 0; i < getSize(); i ++) {
			data[i] = (byte) Math.round(Math.random());
		}
	}
	
	/* data manipulation */
	public int getSize() {
		return data.length;
	}
	public byte getGene(int index) {
		return data[index];
	}
	public void setSize(int size_) {
		data = new byte[size_];
	}
	public void setGene(int index, byte val) {
		data[index] = val;
	}
	
	/* functional methods */
	public String seeData() {
		String out = "";
		for (int i = 0; i < getSize(); i ++) {
			out += data[i];
		}
		return out;
	}
}
