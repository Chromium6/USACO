import javax.sound.midi.SysexMessage;

/**
 This is an individual of a population. Each one is a "test case" of evolution
*/

public class Person {

    private DNA[] genotype; // collection of all chromosomes
    boolean unique; // if the chromosome lengths are non-constant
    int fitness = 0; // natural selection fitness

    /* Constructors */
    public Person(int chrom, int geneL) { // start from a clean slate
        genotype = new DNA[chrom];
        for (int i = 0; i < chrom; i ++) {
            genotype[i] = new DNA(geneL);
        }
        unique = false;
    }

    public Person(int[] lengths) { // for assemytric chromosome lengths
        genotype = new DNA[lengths.length];
        for (int i = 0; i < cLength(); i ++) {
            genotype[i] = new DNA(lengths[i]);
        }
        unique = true;
    }

    /* Getters */
    public int get(int chromN, int geneN) { // for multi-chromosomes
        return genotype[chromN].get(geneN);
    }

    public int get(int geneN) { // for single chromosome
        return genotype[0].get(geneN);
    }

    public DNA getChrom(int chromN) { // get a chromosome strand
        return genotype[chromN];
    }

    public int cLength() { // how many chromosomes this person has
        return genotype.length;
    }

    public int gLength() { // how many genes in a chromosome (all same length)
        return genotype[0].length();
    }

    public int gLength(int index) { // how many genes in a particular chromosome (unique lengths)
        return genotype[index].length();
    }

    public DNA[] genome() { // get complete genome
        return genotype;
    }

    /* Setters */
    public void set(int chromN, int geneN, int val) { // for multi-chromosomes
        genotype[chromN].set(geneN, val);
    }

    public void set(int geneN, int val) { // for single chromosomes
        genotype[0].set(geneN, val);
    }

    public void set(int chromN, DNA newChrom) { // completely reinstall DNA
        genotype[chromN] = newChrom;
    }

    /* Functions */
    public Person cross(Person b, float rate) { // have a baby!
        Person child;
        if (b.unique) {
            int[] lengths = new int[b.cLength()];
            for (int i = 0; i < lengths.length; i ++) {
                lengths[i] = b.gLength(i);
            }
            child = new Person(lengths);
        }
        else {
            child = new Person(cLength(), gLength());
        }
        for (int c = 0; c < child.cLength(); c ++) {
            for (int g = 0; g < child.gLength(c); g ++) {
                int wheel = (int)(Math.random()*10);
                if (wheel >= 4.5)
                    child.set(c, g, this.get(c, g));
                else
                    child.set(c, g, b.get(c, g));
            }
        }
        child.mutate(rate);
        return child;
    }

    public void mutate(float rate) { // cause random mutations
        for (int c = 0; c < cLength(); c ++) {
            for (int g = 0; g < gLength(c); g ++) {
                float wheel = (float)Math.random();
                if (wheel <= rate)
                    set(c, g, (int)(Math.round((Math.random()*10))-5));
            }
        }
    }

    public void fitnessFunction() { // magical function to calculate fitness
        // example: find closeness to [][][][][][]
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < cLength(); i ++) {
            k += getChrom(i) + "\n";
        }
        return k;
    }

	public static void main(String args[]) {
        int[] lengths = {10};
        Person k = new Person(lengths);
        Person l = new Person(lengths);
        Person m = k.cross(l, 0.1f);
        System.out.println(k.toString() + "\n" + l.toString());
        System.out.println(m.toString());
    }
}
