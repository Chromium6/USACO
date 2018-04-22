package turing.GA;
/**
 The basic information storage for an individual.
Essentially a chromosome.
*/

public class DNA {

    int data[]; // genetic information

    /* Constructors */
    public DNA(int n) { // clean slate
        data = new int[n];
        for (int i = 0; i < size(); i ++) {
            data[i] = (int)(Math.round((Math.random()))); // if you change this formula, remember to reflect it in the mutating function!
        }
    }

    /* Methods */
    public int getGene(int index) { // get/set gene
        return data[index];
    }

    public void setGene(int index, int val) {
        data[index] = val;
    }

    public int size() { // get DNA length
        return data.length;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.size(); i ++) {
            k += "[" + (this.getGene(i) >= 0 ? " " : "") + this.getGene(i) + "]";
        }
        return k;
    }
}
