/**
 This is an individual of a population. Each one is a "test case" of evolution
*/

public class Person {

    private DNA[] genotype; // collection of all chromosomes

    /* Constructors */
    public Person(int chrom, int geneL) { // start from a clean slate
        genotype = new DNA[chrom];
        for (int i = 0; i < chrom; i ++) {
            genotype[i] = new DNA(geneL);
        }
    }

    public Person(DNA[] info) { // cloning
        genotype = info;
    }

    public Person(int[] lengths) { // for assemytric chromosome lengths
        genotype = new DNA[lengths.length];
        for (int i = 0; i < cLength(); i ++) {
            genotype[i] = new DNA(lengths[i]);
        }
    }

    /* Getters */
    public int get(int chromN, int geneN) { // for multi-chromosomes
        return genotype[chromN].get(geneN);
    }

    public int get(int geneN) { // for single chromosome
        return genotype[0].get(geneN);
    }

    public DNA getChrom(int chromN) {
        return genotype[chromN];
    }

    public int cLength() {
        return genotype.length;
    }

    public int gLength() {
        return genotype[0].length();
    }

    public DNA[] genome() {
        return genotype;
    }

    /* Setters */
    public void set(int chromN, int geneN, int val) { // for multi-chromosomes
        genotype[chromN].set(geneN, val);
    }

    public void set(int geneN, int val) { // for single chromosomes
        genotype[0].set(geneN, val);
    }

    public void set(int chromN, DNA newChrom) {
        genotype[chromN] = new DNA(newChrom.info());
    }

    /* Functions */
    public String toString() {
        String k = "";
        for (int i = 0; i < cLength(); i ++) {
            k += "{" + getChrom(i) + "}\n";
        }
        return k;
    }

	public static void main(String args[]) {
        int[] lengths = {10, 6, 3, 4};
        Person k = new Person(lengths);
        System.out.println(k.toString());
    }
}
