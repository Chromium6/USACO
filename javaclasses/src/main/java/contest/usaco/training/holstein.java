package contest.usaco.training;

/**
NAME: agentmz1
LANG: JAVA
PROG: holstein
*/

import java.io.*;
import java.util.*;

public class holstein {
	private static final String programName = "test";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int v = get(read, 0); // number of vitamins
        Feed min = new Feed(new int[]{}); // vitamin requirements
        read = new StringTokenizer(stdin.readLine());
        int[] temp = new int[v];
        for (int i = 0; i < v; i ++) {
        	temp[i] = get(read, 0);
        	//System.out.println(temp[i]);
        	min = new Feed(temp);
        }
        Feed.setTarget(min);
        
        read = new StringTokenizer(stdin.readLine());
        int n = get(read, 0); // number of feed combinations
        Feed[] data = new Feed[n]; // available feed combinations
        int[] b = new int[v];
        for (int i = 0; i < n; i ++) {
        	b = new int[v];
        	read = new StringTokenizer(stdin.readLine());
        	for (int j = 0; j < v; j ++) {
        		 b[j] = get(read, 0);
        	}
        	data[i] = new Feed(b);
        	data[i].getDifference();
        }
        
        List<Integer> toUse = new ArrayList<Integer>();
        Arrays.sort(data);
        /* run */
        
        for (Feed a : data)
        	System.out.println(a);
        /* exit */
        stdin.close();
        stdout.close();
	}
	
    static int get(StringTokenizer k, int l) {
        return Integer.parseInt(k.nextToken());
    }

    static String get(StringTokenizer k) {
        return k.nextToken();
    }

    static long get(StringTokenizer k, int l, int j) {
        return Long.parseLong(k.nextToken());
    }
}

class Feed implements Comparable<Feed> {
	static Feed target;
	int difference; // variation from target
	int[] data;
	
	public Feed(int...amount) {
		data = amount;
		difference = 0;
	}
	
	static void setTarget(Feed master) {
		target = master;
	}
	
	public int getSize() { return data.length; }
	
	public void getDifference() {
		for (int i = 0; i < getSize(); i ++)
			difference += target.data[i] - this.data[i];
	}
	
	@Override
	public String toString() {
		String out = "{";
		for (int i : this.data) out += i + ", ";
		out = out.substring(0, out.length()-2);
		out += "}";
		return out;
	}

	public boolean equals(Feed arg) {
		return this.data == arg.data;
	}
	
	public int compareTo(Feed arg0) {
		if (arg0.difference == this.difference) return 0;
		return (arg0.difference > this.difference ? 1 : -1);
	}
}
