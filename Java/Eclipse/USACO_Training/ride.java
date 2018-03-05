/**
NAME: agentmz1
LANG: JAVA
PROG: ride
*/

import java.io.*;
import java.util.*;

// passed
public class ride {

    /* var dec */
    static String programName = "ride";
    static final int OFFSET = 64; // 'A' = 65
    static final int CAP = 47; // answer % CAP
    static String a, b; // names
    static int aSum, bSum;

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        a = read.nextToken();
        b = stdin.readLine();
        aSum = bSum = 1;
        /* run */
        for (int i = 0; i < a.length(); i ++)
            aSum *= (a.charAt(i)-OFFSET);
        for (int j = 0; j < b.length(); j ++)
            bSum *= (b.charAt(j)-OFFSET);
        aSum %= CAP;
        bSum %= CAP;
        /* exit */
        stdout.println(aSum == bSum ? "GO" : "STAY");
	}
}
