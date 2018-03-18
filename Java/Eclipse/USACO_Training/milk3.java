/**
NAME: agentmz1
LANG: JAVA
PROG: milk3
*/

import java.io.*;
import java.util.*;

public class milk3 {

    static class triple {
        int[] s = new int[3]; // bucket values

        triple(int m, int n, int o) {
            s[0] = m;
            s[1] = n;
            s[2] = o;
        }
    }

    /* var dec */
    static String programName = "test";
    static int[] cap; // bucket capacities

    /* func dec */
    static int find(triple state, HashSet<triple> visited) {
        int count = 0;

        return count;
    }

    static triple pour(int from, int to, triple set) {
        // first bucket empty (enough space in "to" bucket)
        if (cap[to]-set.s[to] >= set.s[from]) {
            set.s[to] += set.s[from];
            set.s[from] = 0;
        }
        // second bucket full (more "from" than space left in "to")
        else if (set.s[to] + set.s[from] > cap[to]){
            set.s[from] -= (cap[to]-set.s[to]);
            set.s[to] = cap[to];
        }
        return set;
    }


	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        cap = new int[3];
        cap[0] = Integer.parseInt(read.nextToken());
        cap[1] = Integer.parseInt(read.nextToken());
        cap[2] = Integer.parseInt(read.nextToken());
        triple init = new triple(0, 0, cap[2]); // initially only bucket C full
        /* run */
        stderr.println(init.s[0] + " " + init.s[1] + " " + init.s[2]);
        init = pour(2, 0, init);
        stderr.println(init.s[0] + " " + init.s[1] + " " + init.s[2]);
        /* exit */
        stdin.close();
        stdout.close();
        stderr.close();
	}
}
