package contest.usaco.training;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: helpcross
 * NOTES:
 * Use first-come first-served basis
 */

import java.io.*;
import java.util.*;

public class helpcross {
	private static final String programName = "helpcross";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int c = get(read, 0), n = get(read, 0); // # of chickens and cows, respectively
        int[] cT = new int[c]; // times and ranges
        PriorityQueue<Range> nT = new PriorityQueue<Range>();
        for (int i = 0; i < c; i ++) {
            read = new StringTokenizer(stdin.readLine());
            cT[i] = get(read, 0);
        }
        for (int j = 0; j < n; j ++) {
            read = new StringTokenizer(stdin.readLine());
            Range k = new Range(get(read, 0), get(read, 0));
            assert(k == null);
            nT.add(k);
        }
        int pairings = 0;
        /* run */
        Arrays.sort(cT);
        Range curr = nT.poll();
        for (int chicken = 0; chicken < c; chicken++) {
            //System.out.println("Checking chicken at " + cT[chicken]);
            if (curr == null) break;
            else if (curr.inRange(cT[chicken])) {
                //System.out.println("\t[V] Matched with cow at " + curr);
                pairings++;
                curr = nT.poll();
            }
            else if (curr.beyondRange(cT[chicken])) {
                //System.out.println("\t[V] Out of range from cow at " + curr);
                curr = nT.poll();
                chicken --;
            }
            else {
                //System.out.println("\t[X] Not matched with cow at " + curr);
            }
        }
        /* exit */
        stdout.println(pairings);
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

class Range {
    int start, end;

    public Range(int a, int b) {
        start = a;
        end = b;
    }

    public boolean inRange(int val) {
        return start <= val && val <= end;
    }

    public boolean beyondRange(int val) {
        return val > end;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", start, end);
    }
}