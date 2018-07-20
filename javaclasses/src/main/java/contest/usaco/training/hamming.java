package contest.usaco.training;

import java.io.*;
import java.util.*;

public class hamming {
	private static final String programName = "test";
	
	static String toBinary(int num) {
		String val = "";
		int start = (int)Math.pow(2, (int)(Math.log(num)/Math.log(2))+1);
		for (; start > 0; start >>= 1) {
			if ((start&num) == 1) val += 1;
			else val += 0;
		}
		return val;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        /* run */
        /* exit */
        System.out.println(toBinary(4));
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
