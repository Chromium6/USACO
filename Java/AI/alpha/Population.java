package genetic.alpha;

public class Population {
	// data of citizens
	Person data[];
	
	Population(int size, int len, boolean init) {
		data = new Person[size];
		// creating a population
		for (int i = 0; i < size; i ++) {
			Person temp = new Person();
			temp.setSize(len);
			// if we want a random person
			if (init) {
				temp.init();
			}
			setPerson(i, temp);
		}
	}
	
	// data manipulation
	public Person getPerson(int index) {
		return data[index];
	}
	
	public void setPerson(int index, Person replacement) {
		data[index] = replacement;
	}
	
	public int getSize() {
		return data.length;
	}
	
	// functional methods
	public Person getFittest() {
		Person best = data[0];
		for (Person n : data) {
			if (best.getFitness() < n.getFitness()) {
				best = n;
			}
		}
		return best;
	}
}
/*
public class Population {
	// how large the population will be (default 5)
	private int size = 5;
	// how long each persons gene will be (default 20)
	private int pSize = 20;
	// the population data
	Person data[] = new Person[size];
	
	// initialize the population
	public void init() {
		data = new Person[size];
		for (int i = 0; i < getSize(); i ++) {
			Person n = new Person();
			n.setSize(pSize);
			n.init();
			update(i, n);
		}
	}
	/* setter/getter
	public void setSize(int n) {
		size = n;
	}
	
	public void setpSize(int p) {
		pSize = p;
	}
	
	public int getSize() {
		return size;
	}

	public Person getPerson(int index) {
		return data[index];
	}
	
	public Person getBest() {
		Person best = data[0];
		for (int i = 0; i < getSize(); i ++) {
			int a = getPerson(i).getFit();
			int b = best.getFit();
			if (b <= a) {
				best = getPerson(i);
			}
		}
		return best;
	}

	/* public methods
	public void update(int index, Person n) {
		data[index] = n;
	}

}
*/