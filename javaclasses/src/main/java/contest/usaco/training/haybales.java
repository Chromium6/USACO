package contest.usaco.training;
/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: ride
 * NOTES:
 * for a range [a, b], answer is (# <= b) - (# <= a-1)
 */

import java.io.*;
import java.util.*;

public class haybales {
	private static final String programName = "test";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0); // number of haybales
        int q = get(read, 0); // number of queries
        int[] data  = new int[n]; // haybale locations
        
		/* init */
        read = new StringTokenizer(stdin.readLine());
        for (int i = 0; i < n; i ++)
        	data[i] = get(read, 0);
        Arrays.sort(data);
        
        /* run */
        // parse queries
        int start, end;
        long val;
        for (int i = 0; i < q; i ++) {
        	read = new StringTokenizer(stdin.readLine());
        	start = get(read, 0);
            end = get(read, 0);
            System.out.println();
        }
        /* exit */
        stdin.close();
        stdout.close();
	}
	
    // Binary search the largest haybale location <= low
    public int search(int val, int[] data) {
        int min = 0, max = data.length;
        int mid = -1;
        while (min != max) {
            mid = (min+max)/2;
            if (data[mid] < val) {
                
            }
            else if (data[mid] > val) {

            }
            else {

            }
        }
        return mid;
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
