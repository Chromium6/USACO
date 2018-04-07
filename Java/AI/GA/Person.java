/**
 This is an individual of a population. Each one is a "test case" of evolution
*/

public class Person {

    private DNA[] genotype; // collection of all chromosomes
    int fitness = 0; // natural selection fitness

    /* Constructors */
    public Person(int chromNum, int geneL) { // for uniform chromosome lengths
        genotype = new DNA[chromNum];
        for (int i = 0; i < chromNum; i ++)
            genotype[i] = new DNA(geneL);
    }

    public Person(int[] lengths) { // for unique chromosome lengths
        genotype = new DNA[lengths.length];
        for (int i = 0; i < lengths.length; i ++) {
            genotype[i] = new DNA(lengths[i]);
        }
    }

    /* Methods */
    public DNA get(int chromN) { // get a chromosome strand
        return genotype[chromN];
    }

    public void set(int chromN, DNA newChrom) { // replace a chromosome
        genotype[chromN] = newChrom;
    }

    public void setGene(int chrom, int gene, int val) { // set a gene val
        genotype[chrom].set(gene, val);
    }

    public int size() { // get total number of chromosomes
        return genotype.length;
    }

    public int gLength(int index) { // how many genes in a particular chromosome
        return genotype[index].size();
    }

    public DNA[] genome() { // get complete genome (raw)
        return genotype;
    }

    public int getFitness() {
        if (fitness == 0)
            calcFitness();
        return fitness;
    }

    public void calcFitness() { // magical function to calculate fitness
        // example: find ones with consecutive genes
        for (int chrom = 0; chrom < size(); chrom ++) {
            for (int gene = 1; gene < gLength(chrom); gene ++) {
                if (get(chrom).get(gene) - get(chrom).get(gene-1) == 1)
                    fitness ++;
            }
        }
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.size(); i ++) {
            k += get(i).toString() + "\n";
        }
        return k;
    }

	public static void main(String args[]) {
        int[] lengths = {10, 5};
        Person k = new Person(lengths);
        Person l = new Person(lengths);
        System.out.println(k.toString() + "\n" + l.toString());
    }
}
