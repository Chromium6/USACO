/**
NAME: agentmz1
LANG: JAVA
PROG: closing
*/

import java.io.*;
import java.util.*;

public class closing {

    /* var dec */
    static String programName = "test";
    static int n, m; // nodes and edges
    static int[][] adj; // adjacency matrix
    static int[][] sum; // total number of connections
    static boolean[][] wiped; // track removed node

    /* func dec */
    static boolean connected() { // check if all connected
        
        return true;
    }

    static void clear(int node) { // wipe all connections to and from a node
        for (int i = 0; i < n; i ++) {
            if (adj[i][node] == 1) adj[i][node] = 2;
            if (adj[node][i] == 1) adj[node][i] = 2;
        }
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        m = get(read, 0);
        adj = new int[n][n];
        for (int i = 0; i < m; i ++) {
            read = new StringTokenizer(stdin.readLine());
            int a, b;
            a = get(read, 0)-1;
            b = get(read, 0)-1;
            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        /* run */
        // m queries (removeing every node)
        for (int x = 0; x < n; x ++) {
            read = new StringTokenizer(stdin.readLine());
            int remove = get(read, 0)-1;
            clear(remove); // remove all links
            stderr.println(connected() ? "YES" : "NO");
            for (int i = 0; i < n; i ++) {
                for (int y = 0; y < n; y ++) {
                    stderr.print(adj[y][i] + " ");
                }
                stderr.println();
            }
        }
        /* exit */
        stdin.close();
        stdout.close();
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
