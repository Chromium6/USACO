package contest.usaco.training;

/**
NAME: agentmz1
LANG: JAVA
PROG: sort3
*/

import java.io.*;
import java.util.*;

public class sort3 {
	private static final String programName = "test";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0);
        int[] data = new int[n];
        for (int i = 0; i < n; i ++) {
        	read = new StringTokenizer(stdin.readLine());
        	data[i] = get(read, 0);
        }
        /* run */
      System.	out.println(selectionSort(data));
        /* exit */
        stdin.close();
        stdout.close();
	}
	
	// returns number of swaps needed
	static int selectionSort(int[] data) {
		int swaps = 0;
		
		// selection sort
		int min, temp;
		for (int i = 0; i < data.length-1; i ++) {
			min = i;
			for (int j = i+1; j < data.length; j ++) {
				if (data[j] < data[i]) min = j;
			}
			if (min == i) continue;
			temp = data[i];
			data[i] = data[min];
			data[min] = temp;
			swaps ++;
		}
		return swaps;
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
