// this contains the DNA and phenotype expression
public class Person {
	// genotype
	byte[] dna;
	// temporarily store the rating (aka fitness)
	int fitness = 0;
	
	/* constructors */
	Person(int g_size, boolean random) {
		dna = new byte[g_size];
		if (random) {
			for (int i = 0; i < g_size; i ++) {
				dna[i] = (byte)(Math.round(Math.random()*10));
			}
		}
	}
	
	/* getter/setters */
	int getSize() {
		return dna.length;
	}
	byte getGene(int index) {
		if (index > getSize()) return -1;
		return dna[index];
	}
	void setGene(int index, byte val) {
		dna[index] = val;
	}
	/* functional methods */
	String seeData() {
		String k = "";
		for (int i = 0; i < getSize(); i ++) {
			k += "[" + getGene(i) + "]";
		}
		k += " Fitness: " + getRating();
		return k;
	}
	// calculate the rating (sometimes called the fitness)
	int getRating() {
		int[] optimal = {5, 10, 2, 6, 3, 6, 4, 6, 5, 2, 5, 10, 2, 6, 3, 6, 4, 6, 5, 2, 5, 10, 2, 6, 3, 6, 4, 6, 5, 2};
		if (fitness == 0) {
			fitness = 0;
			for (int i = 0; i < getSize(); i ++) {
				if (getGene(i) == optimal[i]) fitness ++;
			}
		}
		return fitness;
	}
	// individual reproduction mechanism. uses coin toss model
	Person mate(Person mom) {
		Person child = new Person(getSize(), false);
		for (int i = 0; i < getSize(); i ++) {
			double coin = Math.random();
			if (coin > 0.5) child.setGene(i, mom.getGene(i));
			else child.setGene(i, getGene(i));
		}
		return child;
	}

	public static void main(String args[]) {
		Person k = new Person(10, true);
		System.out.println(k.seeData() + " " + k.getRating());
	}
}
