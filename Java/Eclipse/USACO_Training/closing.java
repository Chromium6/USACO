/**
NAME: agentmz1
LANG: JAVA
PROG: closing
*/

import java.io.*;
import java.util.*;

public class closing {

    /* var dec */
    static String programName = "test";
    static int n, m; // nodes and edges
    static int[][] adj; // adjacency matrix

    /* func dec */
    boolean connected() { // check if all connected
        return true;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        m = get(read, 0);
        adj = new int[n][n];
        for (int i = 0; i < m; i ++) {
            
        }
        /* run */
        /* exit */
        stdin.close();
        stdout.close();
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
