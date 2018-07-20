package contest.usaco.training;

import java.io.*;
import java.util.*;

public class homework {
	private static final String programName = "homework";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n;
        long[] data; // homework scores
        double maxAverage; // maximum average score and corresponding homeworks eaten
        List<Long> maxN = new ArrayList<Long>();
        /* init */
        n = get(read, 0);
        data = new long[n];
        read = new StringTokenizer(stdin.readLine());
        for (int i = 0; i < n; i ++)
        	data[i]= get(read, 0);
        maxAverage = 0;
        maxN = new ArrayList<Long>();
        /* run */
        long sum = 0; // cycling variables
        long min = data[n-1];
        // transverse from end to head
        for (int i = n-1; i >= 0; i --) {
        	// update the sum
        	sum += data[i];
        	// get the minimum
        	min = Math.min(min, data[i]);
        	// calculate average
        	double average = (sum-min)/((n-i-1)==0 ? 1 : (n-i-1));
        	// update best average and corresponding values
        	// if a better average
        	if (average > maxAverage) {
        		maxAverage = average;
        		maxN = new ArrayList<Long>(); // wipe numbers
        		maxN.add((long)i);
        	}
        	// if same average
        	else if (average == maxAverage) {
        		maxN.add((long)i);
        	}
        	//System.out.println("Sum: " + sum + "\nAverage: " + average + "\nMinimum: " + min + "\nCount: " + (n-i-1) + "\n--");
        }
        /* exit */
        for (Long k : maxN)
        	stdout.println(k);
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
