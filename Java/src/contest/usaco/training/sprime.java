package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: test
NOTES: 
*/

import java.io.*;
import java.util.*;

public class sprime {

    /* var dec */
    static String programName = "test";

    /* func dec */

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(System.err, true);// new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        /* run */
        /* exit */
        stdin.close();
        stderr.close();
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
