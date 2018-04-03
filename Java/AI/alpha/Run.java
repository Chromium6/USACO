package genetic.alpha;
import java.io.*;

public class Run {

	public static void main(String args[]) throws IOException {
		/*
		 * Run-environment settings
		 * (Modify natural selection settings in genetic_alg.Nature)
		 */
		int population_size = 100;
		int gene_size = 128;
		String answer = "10100101010011010101101010101000001010100111101011010100101010101010010101011110110110101010100000101010011110101101011010101010";
		
		// set up world
		FitnessCalc.setSolution(answer);
		Population alpha = new Population(population_size, gene_size, true);
		
		// track the generations
		int gen = 0;
		// keep going until perfect solution is found
		while (alpha.getFittest().getFitness() < FitnessCalc.maxFitness()) {
			gen ++;
			System.out.println("Generation " + gen + ". Fittest: " + alpha.getFittest().getFitness());
			alpha = Nature.evolvePopulation(alpha);
		}
		System.out.println("Perfection Achieved");
		System.out.println("Generation: " + gen + "\nGene Sequence: " + alpha.getFittest().seeData());
		
	}

}
