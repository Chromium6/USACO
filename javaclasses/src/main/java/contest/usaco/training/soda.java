package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: test
*/

import java.io.*;
import java.util.*;

public class soda {

    /* var dec */
    static String programName = "test";
    static int n; // cows
    static int count, bestPos; // max effect
    static data[] s; // ranges

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
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        s = new data[2*n]; // store beginnings and ends
        count = bestPos = 0;
        for (int i = 0; i < 2*n;) {
            s[i] = new data();
            read = new StringTokenizer(stdin.readLine());
            s[i].position = get(read, 0);
            s[i].type = -1; // start
            i++;
            s[i] = new data();
            s[i].position = get(read, 0);
            s[i].type = 1; // end
            i++;
        }
        Arrays.sort(s);
        /* run */
        int localCount = 0;
        boolean endDelay = false; // to make endpoints inclusive
        int prevVal = -1;
        for (data k : s) {
            if (endDelay && k.position != prevVal) {
                localCount --;
                endDelay = false;
            }
            if (k.type == -1) localCount -= k.type;
            else endDelay = true;
            //stderr.println(k.position + ": " + localCount);
            if (localCount > count) {
                count = localCount;
                bestPos = k.position;
            }
            prevVal = k.position;
        }
        /* exit */
        stdout.println(count);
        stdin.close();
        stdout.close();
        stderr.close();
	}
}

class data implements Comparable<data> {
    int position;
    int type; // -1 for start, 1 for end
    
    public int compareTo(data o) {
        return this.position - o.position;
    }
}