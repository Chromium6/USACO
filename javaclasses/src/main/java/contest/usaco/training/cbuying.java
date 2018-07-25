package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: cbuying
*/

import java.io.*;
import java.util.*;

public class cbuying {

    /* var dec */
    static String programName = "test";
    static int n; // number of chocolates
    static long b; // budget
    static long count; // number of satisfied cows
    static chocolate[] s;

    /* func dec */
    static int get(StringTokenizer k, int l) {
        return Integer.parseInt(k.nextToken());
    }

    static long get(StringTokenizer k, int l, int j) {
        return Long.parseLong(k.nextToken());
    }

    static String get(StringTokenizer k) {
        return k.nextToken();
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));//new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        b = get(read, 0, 0);
        count = 0;
        s = new chocolate[n];
        for (int i = 0; i < n; i++) {
            s[i] = new chocolate();
            read = new StringTokenizer(stdin.readLine());
            s[i].cost = get(read, 0, 0);
            s[i].cows = get(read, 0, 0);
        }
        /* run */
        Arrays.sort(s);
        // stderr.println(s[0].cost + " " + s[0].cows);
        for(chocolate t : s) {
            long number = Math.min(b/t.cost, t.cows);
            b -= t.cost*number;
            count += number;
            // stderr.println(number + " bought, $" + b + " remaining");
        }
        /* exit */
        stderr.println(count);
        stdin.close();
        stdout.close();
        stderr.close();
    }
    
}

class chocolate implements Comparable {
    long cost, cows;

	public int compareTo(Object arg0) {
		return (int)(this.cost - ((chocolate)arg0).cost);
	}
}