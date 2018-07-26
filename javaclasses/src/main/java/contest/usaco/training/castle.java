package contest.usaco.training;

import java.io.*;
import java.util.*;


/* KEY:
1 = W
2 = N
3 = N, W
4 = E
5 = E, W
6 = N, E
7 = N, E, W
8 = S
9 = S, W
10 = N, S
11 = N, W, S
12 = S, E
13 = S, E, W
14 = N, E, S
15 = N, S, E, W
*/

public class castle {
	private static final String programName = "test";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        /* run */
        /* exit */
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
