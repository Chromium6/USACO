package genetic.alpha;

// all methods static
// modify calculation method as needed
public class FitnessCalc {
	// the target solution (byte[]) (default length 5)
	static byte solution[] = new byte[5];
	
	// data modification
	// integer solution input
	
	public static void setSolution(byte answer[]) {
		solution = answer;
	}
	
	// String solution input
	public static void setSolution(String answer) {
		solution = new byte[answer.length()];
		for (int i = 0; i < answer.length(); i ++) {
			String gene = answer.substring(i, i + 1);
			try {
				solution[i] = Byte.parseByte(gene);
			}
			catch (Exception e) {
				solution[i] = 0;
			}
		}
	}
	
	public static String seeData() {
		String format = "";
		for (byte n : solution) {
			format += n;
		}
		return format; 
	}
	
	// functional methods
	public static int findFitness(Person n) {
		int fit = 0;
		for (int i = 0; i < n.getSize(); i ++) {
			if (n.getGene(i) == solution[i]) fit ++;
		}
		return fit;
	}
	
	public static int maxFitness() {
		return solution.length;
	}
	
}

/*
public class FitnessCalc {
	// save the correct solution as a genetic sequence with 1 chromosome
	static byte solution[];
	
	/* public methods
	// set the solution with numerical sequence
	public static void setSolution(byte ans[]) {
		solution = ans;
	}
	
	// set the solution with string input
	public static void setSolution(String ans) {
		solution = new byte[ans.length()];
		for (int i = 0; i < ans.length(); i ++) {
			String temp = ans.substring(i, i+1);
			if (temp.contains("0") || temp.contains("1")) {
				solution[i] = Byte.parseByte(temp);
			}
			else solution[i] = 0;
		}
	}
	
	// get the fitness for a Person (modify as needed)
	public static int getFitness(Person n) {
		int fitness = 0;
        // Loop through our individuals genes and compare them to our cadidates
        for (int i = 0; i < n.getSize() && i < solution.length; i++) {
            if (n.getGene(i) == solution[i]) {
                fitness++;
            }
        }
        return fitness;
	}
	
	// get maximum possible fitness
	public static int maxFitness() {
		return solution.length;
	}

}
*/