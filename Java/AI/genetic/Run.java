/**
The debugging test script for the genetic algorithms project 
*/
import java.io.*;
import java.util.*;

public class Run {

    /* var dec */
    static String programName = "test";

    /* settings */
    static final int popSize = 100;
    static final int chromAmount = 100;
    static final int chromLength = 10;

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(System.out, true);// new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        /* run */
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
