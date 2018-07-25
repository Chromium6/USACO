package ga;

import processing.core.PVector;

/**
 The basic information storage for an individual.
Essentially a chromosome.
*/

public class DNA {

    PVector data[]; // the angle relative to the rocket heading at which a thruster fires

    /* Constructors */
    public DNA(int n) { // clean slate
        data = new PVector[n];
        for (int i = 0; i < size(); i ++) {
            data[i] = PVector.random2D(); // if you change this formula, remember to reflect it in the mutating function!
        }
    }

    /* Methods */
    public PVector getGene(int index) { // get/set gene
        return data[index];
    }

    public void setGene(int index, PVector val) {
        data[index] = val;
    }

    public int size() { // get DNA length
        return data.length;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.size(); i ++) {
            k += "[" + this.getGene(i).mag() + "]";
        }
        return k;
    }
}
