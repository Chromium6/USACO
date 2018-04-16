public class Run {
	/* world settings */
	private static final int popSize = 100;
	private static final int geneLength = 30;

	public static void main(String[] args) {
		// make the population
		Population city = new Population(popSize, geneLength, true);
		// track the number of generations that passed
		int gen = 0;
		// search for the correct answer
		do {
			gen ++;
			System.out.println("Best Rating: " + city.getBest().getRating());
			city.evolve();
			System.out.println(city.getBest().seeData());
		} while (city.getBest().getRating() < geneLength);
		System.out.println("Perfect Genome Found");
		System.out.println("Generations: " + gen);
		System.out.println("Gene: " + city.getBest().seeData());
	}

}
