package turing.GA;
/**
 This is an individual of a population. Each one is a "test case" of evolution
*/

public class Person {

    DNA[] genotype; // collection of all chromosomes
    int fitness = 0; // natural selection fitness

    /* Constructors */
    public Person(int[] geneL) { // designed for non-uniform chromosome lengths
    	genotype = new DNA[geneL.length];
        for (int i = 0; i < geneL.length; i ++)
        	genotype[i] = new DNA(geneL[i]);
    }

    /* Methods */
    public DNA getDNA(int strand) { // get a chromosome strand
        return genotype[strand];
    }

    public void setDNA(int strand, DNA newChrom) { // replace a chromosome
        genotype[strand] = newChrom;
    }
    
    public void setGene(int strand, int gene, int val) {
    	genotype[strand].setGene(gene, val);
    }

    public int size() { // get total number of chromosomes
        return genotype.length;
    }

    public int[] gLengths() { // get the various gene lengths
        int[] lengths = new int[size()];
        for (int i = 0; i < size(); i ++) {
        	lengths[i] = getDNA(i).size();
        }
        return lengths;
    }

    public int getFitness() {
        if (fitness == 0)
            calcFitness();
        return fitness;
    }

    public void calcFitness() { // magical function to calculate fitness
        int[][] perfect = {
        		{0, 1, 1, 0, 0},
        		{0, 1, 0},
        		{0, 1, 1, 1, 0, 0, 1, 0, 1, 1}
        		};
        for (int c = 0; c < gLengths().length; c ++) {
        	for (int gene = 0; gene < gLengths()[c]; gene ++) {
        		fitness += (getDNA(c).getGene(gene) == perfect[c][gene]) ? 1 : 0;
        	}
        }
    }

    public String toString() {
        return genotype.toString();
    }
}
