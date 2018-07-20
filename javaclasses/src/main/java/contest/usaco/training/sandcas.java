package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: test
*/

import java.io.*;
import java.util.*;

public class sandcas {

    /* var dec */
    static String programName = "test";
    static int n; // number of merlons
    static int priceUp, priceDown; // change costs
    static int costs;
    static int[] a; // initial heights
    static int[] b; // resulting heights

    /* func dec */

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        priceUp =get(read, 0);
        priceDown = get(read, 0);
        costs = 0;
        a = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            a[i] = get(read, 0);
            b[i] = get(read, 0);
        }
        /* run */
        Arrays.sort(a);
        Arrays.sort(b);
        for(int comp = 0; comp < n; comp ++) {
            costs += Math.abs(a[comp]-b[comp])*(a[comp] > b[comp] ? priceDown : priceUp);
        }
        /* exit */
        stderr.println(costs);
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
