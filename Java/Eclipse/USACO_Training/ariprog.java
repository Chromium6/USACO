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
    static Set<Integer> b; // calc bisquares

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = Integer.parseInt(read.nextToken());
        m = Integer.parseInt(stdin.readLine());
        ArrayList<Integer> raw = new ArrayList<Integer>();
        /* run */
        for (int i = 1; i < m; i ++) {
            for (int j = i; j < m; j ++) {
                int k = (i*i + j*j);
                raw.add(k);
            }
        }
        Collections.sort(raw, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return (a > b ? 1 : 0);
            }
        });
        stderr.println(raw);
        /* exit */
        stdin.close();
        stdout.close();
        stderr.close();
	}
}
