package contest.usaco.training;

//package contest.usaco.training;
/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: cowdance
 * NOTES:
 * 1) No need to comput exact time, just check if the time is over the limit
 * 2) Using that logic, we can binary search the best value for k!
 * 3) 
 */

import java.io.*;
import java.util.*;

public class cowdance {
    private static final String programName = "cowdance";
    
    public static boolean evalKVal(int k, int limit, int[] data) {
        int endTime = 0;
        PriorityQueue<Integer> dancing = new PriorityQueue<Integer>();
        for (int cow : data) {
            if (dancing.size() == data.length) endTime = dancing.poll();
            if (endTime + cow > limit) return true;
            dancing.add(cow + endTime);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0);
        int tMax = get(read, 0);
        int[] data = new int[n];
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            data[i] = get(read, 0);
        }
        /* run */
        int min = 1, max = n, mid = 0;
        boolean ok;
        while (min != max) {
            //System.out.println(String.format("Searching from [%d, %d]", min, max));
            mid = (min+max)/2;
            ok = evalKVal(mid, tMax, data);
            if (ok) max = mid;
            else min = mid+1;
        }
        stdout.println(min);
        /* exit */
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
