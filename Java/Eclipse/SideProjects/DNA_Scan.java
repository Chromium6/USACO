/**
NAME: agentmz1
LANG: JAVA
PROG: test
*/

import java.io.*;
import java.util.*;

public class DNA_Scan {

    /* var dec */
    static String programName = "dna";
    String fragment; // DNA sequence to be scanned

    /* func dec */
    static int[] findSequence(int sequence) { // returns start and end index, inclusive
        int[] range = new int[2];
        
        return range;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(System.err, true); //new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        /* run */
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
