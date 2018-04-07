package genetic.beta;
import genetic.beta.*;

public class Run {
	/* world settings */
	private static final int popSize = 100;
	private static final int geneLength = 128;
	private static final String optimalCase = "10100101010011010101101010101000001010100111101011010100101010101010010101011110110110101010100000101010011110101101011010101010";

	public static void main(String[] args) {
		// making sure the optimal case is compatible
		if (optimalCase.length() == geneLength) {
			// make the population
			Population city = new Population(popSize, geneLength, true);
			// track the number of generations that passed
			int gen = 0;
			// remember to set the answer!
			city.setOptimum(optimalCase);
			// search for the correct anempswer
			do {
				gen ++;
				System.out.println("Best Rating: " + city.getBest().getRating(optimalCase));
				city.evolve();
			} while (city.getBest().getRating(optimalCase) < geneLength);
			System.out.println("Perfect Genome Found");
			System.out.println("Generations: " + gen);
			System.out.println("Gene: " + city.getBest().seeData());
		}
	}

}
