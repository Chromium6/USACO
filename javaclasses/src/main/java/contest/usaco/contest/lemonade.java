package contest.usaco.contest;
/**
NAME: agentmz1
LANG: JAVA
PROG: test
*/

import java.io.*;
import java.util.*;

// passed
public class lemonade {

    /* var dec */
    static String programName = "lemonade";
    static int n; // number of cows
    static long[] s; // acceptable wait ranges

    /* func dec */

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        s = new long[n];
        read = new StringTokenizer(stdin.readLine());
        for (int i = 0; i < n; i ++)
            s[i] = get(read, 0, 0);
        Arrays.sort(s);
        /* run */
        int sum = 0;
        for (int i = 0; i < n; i ++) {
            if (s[n-i-1] >= i) sum ++;
            else break;
        }
        stderr.println(sum);
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
