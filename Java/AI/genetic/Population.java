/**
 The gene pool being tested. Simulates a limited population with variety, natural selection, and mating.
*/

public class Population {

    private Person[] genePool; // collection of all chromosomes

    /* Constructors */
    public Population(int n, int cLength, int gLength) { // clean slate, constant gene lengths
        genePool = new Person[n];
        for (int i = 0; i < n; i ++) {
            genePool[i] = new Person(cLength, gLength);
        }
    }

    public Population(Person[] info) { // cloning
        genePool = info;
    }

    public Population(int cLength, int[] gLengths) { // chromosome lengths must be constant to allow mating

    }
    /* Getters */
    /* Setters */
    /* Functions */

	public static void main(String args[]) {
		
    }
}
