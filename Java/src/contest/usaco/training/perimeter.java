package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: test
NOTES: 
*/

import java.io.*;
import java.util.*;

public class perimeter {

    /* var dec */
    static String programName = "test";
    static int n; // number of points
    static ArrayList< ArrayList<Integer>> s; // store points (vector of vectors)

    /* func dec */

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(System.out, true);// new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        s = new ArrayList< ArrayList<Integer>>();
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            int x = get(read, 0), y = get(read, 0);
        }
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
