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
    static final int chromAmount = 1;
    static final int chromLength = 6;

	public static void main(String args[]) throws IOException {
        /* init */
        Population
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
