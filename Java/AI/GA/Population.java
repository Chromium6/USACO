/**
 The gene pool being tested. Simulates a limited population with variety, natural selection, and mating.
*/

public class Population {

    private Person[] genePool; // collection of all chromosomes
    int[] chromSizes; // chromosome lengths for each person
    private boolean unique; // whether Persons have unique or uniform chromosomes

    /* Mating parameters */
    private static final double uniformRate = 0.5; // chances of picking mother or father gene
    private static final double mutationRate = 0.013; // chance for mutation
    private static final int tournamentSize = 5; // batch size per mating
    private static final boolean elitism = true; // keep the best or throw their hat into the ring

    /* Constructors */
    public Population(int n, int cNum, int gLength) { // clean slate, constant gene lengths
        genePool = new Person[n];
        chromSizes = new int[1];
        chromSizes[0] = gLength;
        unique = false;
        for (int i = 0; i < n; i ++) {
           genePool[i] = new Person(cNum, gLength);
        }
    }

    public Population(int popSize, int[] gLengths) { // chromosome lengths must be constant to allow mating
        genePool = new Person[popSize];
        chromSizes = gLengths;
        unique = true;
        for (int i = 0; i < popSize; i ++) {
            genePool[i] = new Person(gLengths);
        }
    }

    /* Evolution */
    public Population evolve() { // take a step in evolution
        Population newPop = new Population(popSize(), chromSizes); // temporary storage for babies
        // do we keep the best 2?
        if (elitism) {
            newPop.set(0, this.getFittest());
        }

        // carry out mating cycle
        for (int i = (elitism ? 2 : 0); i < this.popSize(); i ++) {
            Person mom = pickIndiv(this);
            Person dad = pickIndiv(this);
            Person child = mate(mom, dad);
            newPop.set(i, child);
        }

        // mutation built in to crossing function

        return newPop;
    }

    public Person getFittest() {
        Person best = get(0);
        for (Person next : genePool) {
            if (next.getFitness() > best.getFitness())
                best = next;
        }
        return best;
    }

    public Person mate(Person mom, Person dad) {
        Person child;
        if (!unique) child = new Person(mom.size(), chromSizes[0]);
        else child = new Person(chromSizes);
        for (int chrom = 0; chrom < child.size(); chrom ++) {
            for (int gene = 0; gene < dad.gLength(chrom); gene ++) {
                double coin = Math.random();
                if (coin < uniformRate) child.setGene(chrom, gene, mom.get(chrom).get(gene));
                else child.setGene(chrom, gene, dad.get(chrom).get(gene));
            }
        }

        child = Population.mutate(child);
        return child;
    }

    public static Person mutate(Person a) {
        for (int chrom = 0; chrom < a.size(); chrom ++) {
            for (int gene = 0; gene < a.gLength(chrom); gene ++) {
                if (Math.random() < mutationRate)
                    a.setGene(chrom, gene, (int)(Math.round((Math.random()*10))-5));
            }
        }
        return a;
    }

    public static Person pickIndiv(Population k) {
        Population temp = new Population(tournamentSize, k.chromSizes);
        for (int i = 0; i < tournamentSize; i ++) {
            int lottery = (int)(Math.random()*k.popSize());
            temp.set(i, k.get(lottery));
        }
        return temp.getFittest();
    }

    /* Methods */
    public Person get(int index) {
        return genePool[index];
    }

    public void set(int index, Person newbie) {
        genePool[index] = newbie;
    }

    public int popSize() { // size of the population
        return genePool.length;
    }

    public Person[] info() {
        return genePool;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.popSize(); i ++) {
            k += i + ":\n" + this.get(i).toString();// + "Fitness: " + this.get(i).getFitness() + " \n\n";
        }
        return k;
    }

	public static void main(String args[]) {
        int[] lengths = {15};
        Population k = new Population(50, lengths);
        System.out.println(k.getFittest().getFitness());
        k = k.evolve();
        System.out.println(k.getFittest().getFitness());
    }
}
