package ai.ga;
/**
The debugging test script for the genetic algorithms project 
*/

public class Run {

    /* settings */
    static final int popSize = 100;
    static final int[] geneLengths = {5, 3, 10};
    static int generations;

	public static void main(String args[]) throws InterruptedException {
        /* init */ 
        Population k = new Population(popSize, geneLengths);
        generations = 0;
        /* run */
        //System.out.println(k.toString());
        //Thread.sleep(10000);
        for (int i = 0; i < 100; i ++) {
            k = k.evolve();
            System.out.println("Generation " + generations + " has best fitness of " + k.getFittest().getFitness());
            generations ++;
        }
        System.out.println(k.getFittest().toString());
    }
    
}
