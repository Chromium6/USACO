/**
NAME: agentmz1
LANG: JAVA
PROG: numtri
*/

import java.io.*;
import java.util.*;

public class numtri {

    /* var dec */
    static String programName = "numtri";
    static int n; // number of levels
    static int[][] s; // triangle
    static int[][] dp; // sum memorization

    /* func dec */
    static int f(int x, int y) {
        int sum = Math.max(dp[x+1][y], dp[x+1][y+1]);
        sum += s[x][y];
        return sum;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        s = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            for (int j = 0; j < i+1; j ++) {
                s[i][j] = get(read, 0);
                //stderr.print(s[i][j] + " ");
            }
            //stderr.println();
        }
        /* run */
        for (int i = 0; i < n; i ++) {
            dp[0][i] = 0;
        }
        for (int i = n-1; i >= 0; i --) {
            for (int j = 0; j < i+1; j ++) {
                dp[i][j] = f(i, j);
            }
        }
        /* exit */
        /*for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i+1; j ++) {
                stderr.print(dp[i][j] + " ");
            }
            stderr.println();
        }*/
        stderr.println(dp[0][0]);
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
