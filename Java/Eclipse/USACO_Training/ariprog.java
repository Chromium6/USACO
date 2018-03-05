/**
NAME: agentmz1
LANG: JAVA
PROG: ariprog
*/

import java.io.*;
import java.util.*;

public class ariprog {

    /* var dec */
    static String programName = "test";
    static int n, m;
    static TreeSet<Integer> b; // calc bisquares

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = Integer.parseInt(read.nextToken());
        m = Integer.parseInt(stdin.readLine());
        b = new TreeSet<Integer>();
        /* run */
        for (int i = 0; i < m; i ++) {
            for (int j = i; j < m; j ++) {
                int k = i*i + j*j;
                b.add(k);
            }
        }
        stderr.println(b);
        /* exit */
        stdin.close();
        stdout.close();
        stderr.close();
	}
}
