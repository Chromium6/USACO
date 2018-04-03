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

    public Population(int popSize, int[] gLengths) { // chromosome lengths must be constant to allow mating
        genePool = new Person[popSize];
        for (int i = 0; i < popSize; i ++) {
            genePool[i] = new Person(gLengths);
        }
    }

    /* Getters */
    public Person get(int index) {
        return genePool[index];
    }

    public int popSize() { // size of the population
        return genePool.length;
    }

    public int cLength() { // number of chromosomes each person has (always constant)
        return genePool[0].cLength();
    }

    public int gLength() { // number of genes in a chromosome (constant)
        return genePool[0].gLength();
    }

    public int gLength(int index) { // number of genes in a chromosome (unique)
        return genePool[index].gLength();
    }

    public Person[] pop() {
        return genePool;
    }

    /* Setters */
    public void set(int index, Person newbie) {
        genePool[index] = newbie;
    }

    /* Evolution */
    public void mate() {
        
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.popSize(); i ++) {
            k += i + ":\n" + this.get(i).toString();
        }
        return k;
    }

	public static void main(String args[]) {
        int[] lengths = {5, 2, 3, 7};
        Population k = new Population(5, lengths);
        System.out.println(k.toString());
    }
}
