// package training;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: BLANK
 * NOTES:
 */

import java.io.*;
import java.util.*;

public class cardgame {
	private static final String programName = "test";

    //-- var dec

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        //-- init
        //-- run
        //-- exit
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
