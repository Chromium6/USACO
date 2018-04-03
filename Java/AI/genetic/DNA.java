
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

    public DNA(int[] info) { // create from data
        data = info;
    }

    /* Getters */
    public int get(int index) {
        return data[index];
    }

    public int length() {
        return data.length;
    }

    public int[] info() {
        return data;
    }
    /* Setters */
    public void set(int index, int val) {
        data[index] = val;
    }

    /* Functions */
    public String toString() {
        String k = "";
        for (int i = 0; i < this.length(); i ++) {
            k += "[" + (this.get(i) >= 0 ? " " : "") + this.get(i) + "]";
        }
        return k;
    }

	public static void main(String args[]) {
        DNA k = new DNA(9);
        System.out.println(k.toString());
	}
}
