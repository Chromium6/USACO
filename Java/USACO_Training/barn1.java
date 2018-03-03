/**
NAME: agentmz1
LANG: JAVA
PROG: barn1
*/

import java.io.*;
import java.util.*;

public class barn1 {

    /* var dec */
    static String programName = "test";
    static int m; // max purchasable boards
    static int n; // total stalls
    static int c; // total occupied stalls
    static int gap[]; // lengths we can remove
    static int s[]; // store occupied stalls
    static int first, last, dist; // earliest and latest blocked stalls

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        // PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        m = Integer.parseInt(read.nextToken());
        n = Integer.parseInt(read.nextToken());
        c = Integer.parseInt(read.nextToken());
        gap = new int[c-1];
        s = new int[c];
        first = n+1;
        last = 0;
        dist = 0;
        for (int i = 0; i < c; i ++) {
            s[i] = Integer.parseInt(stdin.readLine());
            last = Math.max(last, s[i]);
            first = Math.min(first, s[i]);
        }
        dist = last-first+1;
        for (int j = 0; j < c-1; j ++)
            gap[j] = Math.abs(s[j]-s[j+1])-1;
        Arrays.sort(gap);
        /* run */
        int lengthRemove = c-2;
        for (int k = 0; k < m-1 || lengthRemove < 0; k ++) {
            if (lengthRemove < 0) break;
            dist -= gap[lengthRemove];
            lengthRemove --;
        }
        /* exit */
        stdout.println(dist);
        stdin.close();
        stdout.close();
	}
}
