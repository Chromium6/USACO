package turing.GA; 
/**
 The gene pool being tested. Simulates a limited population with variety, natural selection, and mating.
*/

public class Population {

    Person[] genePool; // collection of all chromosomes

    /* Mating parameters */
    private static final double uniformRate = 0.5; // chances of picking mother or father gene
    private static final double mutationRate = 0.13; // chance for mutation
    private static final int tournamentSize = 20; // batch size per mating
    private static final boolean elitism = true; // keep the best

    /* Constructors */
    public Population(int popSize, int[] gLengths) { // clean slate, unique gene lengths
        genePool = new Person[popSize];
        for (int i = 0; i < popSize(); i ++)
           genePool[i] = new Person(gLengths);
    }

    /* Evolution */
    public Population evolve() { // take a step in evolution
        Population newPop = new Population(this.popSize(), this.getPerson(0).gLengths()); // temporary storage for babies
        
        if (elitism) newPop.setPerson(0, newPop.getFittest());
        
        // carry out mating cycle
        for (int i = (elitism ? 1 : 0); i < newPop.popSize(); i ++) {
            Person mom = this.pickIndiv();
            Person dad = this.pickIndiv();
            Person child = mate(mom, dad);
            newPop.setPerson(i, child);
        }
        
        // mutation built in to crossing function

        return newPop;
    }

    public Person getFittest() {
        Person best = getPerson(0);
        for (Person next : genePool) {
            if (next.getFitness() > best.getFitness())
                best = next;
        }
        return best;
    }

    public Person mate(Person mom, Person dad) {
    	int[] lens = mom.gLengths();
        Person child = new Person(lens);
        for (int c = 0; c < lens.length; c ++) {
        	for (int gene = 0; gene < lens[c]; gene ++) {
                double coin = Math.random();
                if (coin > uniformRate) child.setGene(c, gene, mom.getDNA(c).getGene(gene));
                else child.setGene(c, gene, dad.getDNA(c).getGene(gene));
            }
        }

        child = mutate(child);
        return child;
    }

    public Person mutate(Person a) {
    	int[] lens = a.gLengths();
    	for (int c = 0; c < a.size(); c ++) {
    		for (int gene = 0; gene < lens[c]; gene ++) {
    			if (Math.random() < mutationRate)
    				a.setGene(c, gene, (int)(Math.round((Math.random()))));
    		}
    	}
        return a;
    }

    public Person pickIndiv() {
        Population temp = new Population(tournamentSize, getPerson(0).gLengths());
        for (int i = 0; i < tournamentSize; i ++) {
            int lottery = (int)(Math.random()*popSize());
            //System.out.println(lottery);
            temp.setPerson(i, genePool[lottery]);
        }
        return temp.getFittest();
    }

    /* Methods */
    public Person getPerson(int index) {
        return genePool[index];
    }

    public void setPerson(int index, Person newbie) {
        genePool[index] = newbie;
    }

    public int popSize() { // size of the population
        return genePool.length;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.popSize(); i ++) {
            k += i + ": " + this.getPerson(i).toString() + "\nFitness: " + this.getPerson(i).getFitness() + " \n";
        }
        return k;
    }
    
}
