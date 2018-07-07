package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {

    ArrayList<Result> res = new ArrayList<Result>();

	class Result implements Comparable<Result> {
		int start;
		int diff;

		public Result(int s, int d) {
			start = s;
			diff = d;
		}

		public int compareTo(Result other) {
			if (diff == other.diff) return start - other.start;
			return diff - other.diff;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Result)) return false;
			Result other = (Result) obj;
			return (other.start == start && other.diff == diff);
		}

		public String toString() {
			return String.format("%d %d", start, diff);
		}
	}

	public String[] solve(int n, int m) {
		generate(m);

		for (int i = 0; i < bisquares.size() - 1; i++) {
			int start = bisquares.get(i);
			for (int j = i + 1; j < bisquares.size() - 1; j++) {
				int next = bisquares.get(j);
				int diff = next - start;
				
				if (start + (n - 1) * diff > max()) {
					break;
				}
				
				boolean found = true;
				for (int k = n - 1; k >= 1; k--) {
					if (!contains[start + k * diff]) {
						found = false;
						break;
					}
				}
				if (found) {
					Result r = new Result(start, diff);
					if (!res.contains(r)) {
						res.add(r);
					}
				} 
			}
		}

		if (res.size() == 0) return new String[] { "NONE" };
		return toArray(res);
	}

	private String[] toArray(ArrayList<Result> l) {
		Collections.sort(l);
		String[] strings = new String[l.size()];
		for (int i = 0; i < l.size(); i++) {
			strings[i] = l.get(i).toString();
		}
		return strings;
	}

	int max() {
		return bisquares.get(bisquares.size() - 1);
	}

	int min() {
		return bisquares.get(0);
	}

	ArrayList<Integer> bisquares = new ArrayList<Integer>();
	boolean[] contains; 

	void generate(int m) {
		for (int i = 0; i <= m; i++) {
			for (int j = i; j <= m; j++) {
				int bs = i * i + j * j;
				if (!bisquares.contains(bs)) {
					bisquares.add(bs);
				}
			}
		}
		Collections.sort(bisquares);
		
		contains = new boolean[max() + 1];
		for (int i : bisquares) {
			contains[i] = true;
		}
		return;
	}

	public static void main(String[] args) throws IOException {
		String problemName = "ariprog";
		BufferedReader f = new BufferedReader(new FileReader(problemName + ".in"));

		int n = Integer.parseInt(f.readLine());
		int m = Integer.parseInt(f.readLine());

		String[] res = (new ariprog()).solve(n, m);

		// output Span
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(problemName + ".out")));
		for (String s : res) {
			out.println(s);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

}
