package genetic.beta;

// this contains the DNA and phenotype expression
public class Person {
	// genotype
	DNA dna;
	// temporarily store the rating (aka fitness)
	int fitness = 0;
	
	/* constructors */
	Person(int g_size, boolean random) {
		dna = new DNA();
		dna.setSize(g_size);
		if (random) dna.init();
	}
	
	/* getter/setters */
	int getSize() {
		return dna.getSize();
	}
	byte getGene(int index) {
		if (index > getSize()) return -1;
		return dna.getGene(index);
	}
	void setSize(int n) {
		dna.setSize(n);
	}
	void setGene(int index, byte val) {
		dna.setGene(index, val);
	}
	/* functional methods */
	String seeData() {
		return dna.seeData();
	}
	// calculate the rating (sometimes called the fitness)
	int getRating(String answer) {
		if (fitness == 0) {
			fitness = 0;
			for (int i = 0; i < getSize(); i ++) {
				byte opGene = (byte) (answer.charAt(i) - '0');
				if (opGene == getGene(i)) fitness ++;
			}
		}
		return fitness;
	}
	// individual reproduction mechanism. uses coin toss model
	Person mate(Person mom) {
		Person child = new Person(getSize(), false);
		for (int i = 0; i < getSize(); i ++) {
			long coin = Math.round(Math.random());
			if (coin > 0.5) child.setGene(i, mom.getGene(i));
			else child.setGene(i, getGene(i));
		}
		return child;
	}
}
