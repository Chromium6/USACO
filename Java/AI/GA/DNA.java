/**
 The basic information storage for an individual.
Essentially a chromosome.
*/

public class DNA {

    private int data[]; // genetic information

    /* Constructors */
    public DNA(int n) { // clean slate
        data = new int[n];
        for (int i = 0; i < n; i ++) {
            data[i] = (int)(Math.round((Math.random()*10))-5); // if you change this formula, remember to reflect it in the mutating function!
        }
    }

    /* Methods */
    public int get(int index) { // get/set gene
        return data[index];
    }

    public void set(int index, int val) {
        data[index] = val;
    }

    public int size() { // get DNA length
        return data.length;
    }

    public int[] info() {
        return data;
    }

    public String toString() {
        String k = "";
        for (int i = 0; i < this.size(); i ++) {
            k += "[" + (this.get(i) >= 0 ? " " : "") + this.get(i) + "]";
        }
        return k;
    }

	public static void main(String args[]) {
        DNA k = new DNA(9);
        System.out.println(k.toString());
	}
}
