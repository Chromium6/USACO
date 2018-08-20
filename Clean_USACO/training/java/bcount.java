// package training;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: bcount
 * NOTES:
 * No sorting (order matters)
 * N <= 100,000, Q <= 100,000
 * Queries 1-indexed
 * DP solution needed for linear pass
 */

import java.io.*;
import java.util.*;

// passed
public class bcount {
	private static final String programName = "bcount";

    //-- var dec
    static int n, m; // cows, queries
    static int[] data; // cow positions
    static int[] dp1; // dp for type 1 cows
    static int[] dp2; // dp for type 2 cows
    static int[] dp3; // dp for type 3 cows

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        //-- init
        n = get(read, 0);
        m = get(read, 0);
        data = new int[n];
        dp1 = new int[n];
        dp2 = new int[n];
        dp3 = new int[n];
        int count1 = 0, count2 = 0, count3 = 0;
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            data[i] = get(read, 0);
            switch (data[i]) {
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
                case 3:
                    count3++;
                    break;
            }
            dp1[i] = count1;
            dp2[i] = count2;
            dp3[i] = count3;
        }
        /*
        for (int i : dp1) System.out.print(i + " ");
        System.out.println();
        for (int i : dp2) System.out.print(i + " ");
        System.out.println();
        for (int i : dp3) System.out.print(i + " ");
        */
        //-- run
        int a, b, c;
        for (int query = 0; query < m; query ++) {
            read = new StringTokenizer(stdin.readLine());
            a = get(read, 0)-1;
            b = get(read, 0)-1;
            stdout.print(dp1[b]-(a==0 ? 0 : dp1[a-1])+" ");
            stdout.print(dp2[b]-(a==0 ? 0 : dp2[a-1])+" ");
            stdout.println(dp3[b]-(a==0 ? 0 : dp3[a-1]));
        }
        //-- exit
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
