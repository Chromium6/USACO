package turing.misc;
import java.io.*;
import java.util.*;

public class BioProgs {
	/* var dec */

    /* func dec */

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader("/home/turing-zhang/Desktop/00/18/Docs/Code/GitHub/USACO/Java/Processing/main/src/turing/misc/test.in"));
        PrintWriter stderr = new PrintWriter(System.out, true);// new BufferedWriter(new FileWriter(programName + ".out")), true);
        /* init */
        HashMap<Integer, String> data = new HashMap<Integer, String>();
        for (int i = 0; i < 20; i ++) {
        	String k = stdin.readLine();
        	//System.out.println(i + ": " + k);
        	data.put(i+1, k);
        }
        /* run */
        int A = 0, B = 0, C = 0;
        for (int i = 1; i <= 20; i ++ ) {
        	System.out.print(i + " is used by ");
        	String k = data.get(i);
        	StringTokenizer m = new StringTokenizer(k);
        	int a = Integer.parseInt(m.nextToken());
        	int b = Integer.parseInt(m.nextToken());
        	int c = Integer.parseInt(m.nextToken());
        	if (a == 1)
        		System.out.print(" Buffalo ");
        	if (b == 1)
        		System.out.print(" Cattle ");
        	if (c == 1)
        		System.out.print(" Impala ");
        	System.out.println();
        	A += a;
        	B += b;
        	C += c;
        }
        System.out.println("Buffalo: " + A);
        System.out.println("Cattle: " + B);
        System.out.println("Impala: " + C);
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
