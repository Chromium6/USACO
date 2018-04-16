public class Population {
	// store the population
	Person data[];
	// population mating constants
	private static final double mutationRate = 0.013;
	private static final int batchSize = 20;
	/* constructors */
	Population(int size, int length, boolean random) {
		data = new Person[size];
		for (int i = 0; i < getSize(); i ++) {
			data[i] = new Person(length, random);
		}
	}
	
	/* getter/setters */
	int getSize() {
		return data.length;
	}
	Person getPerson(int index) {
		return data[index];
	}
	void setPerson(int index, Person bro) {
		data[index] = bro;
	}
	
	/* functional methods */
	Person getBest() {
		Person best = data[0];
		for (Person dude : data) {
			if (dude.getRating() > best.getRating()) best = dude;
		}
		return best;
	}
	
	Person batchPick() {
		// store the selection batch, randomly chosen
		Population batch = new Population(batchSize, getPerson(0).getSize(), false);
		for (int i = 0; i < batchSize; i ++) {
			int randIndex = (int) (Math.random()*getSize());
			batch.setPerson(i, getPerson(randIndex));
		}
		// return the best person
		return batch.getBest();
	}
	
	void mutate(Person kiddo) {
		for (int i = 0; i < kiddo.getSize(); i ++) {
			double chance = Math.random();
			if (chance < mutationRate) {
				byte newGene = (byte) Math.round(Math.random());
				kiddo.setGene(i, newGene);
			}
		}
	}
	// population evolution
	public void evolve() {
		// store the new population
		Population newPop = new Population(getSize(), getPerson(0).getSize(), false);
		// fill up the new population with new babies
		for (int i = 0; i < newPop.getSize(); i++) {
			Person mom = batchPick();
			Person dad = batchPick();
			Person child = dad.mate(mom);
			newPop.setPerson(i, child);
		}
		// add mutation chance factor
		for (Person newKid : newPop.data) {
			mutate(newKid);
		}
		// update population
		data = newPop.data;
	}

	public static void main(String[] args) {
		Population k = new Population(10, 10, true);
		for (int i = 0; i < k.getSize(); i ++) {
			System.out.println(k.getPerson(i).seeData());
		}
	}
}