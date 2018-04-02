/**
NAME: agentmz1
LANG: JAVA
PROG: test
*/

import java.io.*;
import java.util.*;

public class multimoo {

    /* var dec */
    static String programName = "multimoo";
    static int n; // dimensions
    static int[][] grid;
    static boolean[][] visited; // don't scan same area multiple times
    static int[] totalCount; // total count
    static int[] areaCount; // area size max for a value  

    /* func dec */
    static int fill(int x, int y, int target) { // finding largest area of one number
        if (visited[x][y] || grid[x][y] != target) return 0;
        int sum = 1;
        visited[x][y] = true;
        if (x+1 < n) sum += fill(x+1, y, target);
        if (y+1 < n) sum += fill(x, y+1, target);
        if (x-1 >= 0) sum += fill(x-1, y, target);
        if (y-1 >= 0) sum += fill(x, y-1, target);
        return sum;
    }

    static int fill(int x, int y, int t1, int t2) { // finding largest area of two numbers
        if (visited[x][y] || grid[x][y] != t1 || grid[x][y] != t2) return 0;
        int sum = 1;
        visited[x][y] = true;
        if (x+1 < n) sum += fill(x+1, y, t1, t2);
        if (y+1 < n) sum += fill(x, y+1, t1, t2);
        if (x-1 >= 0) sum += fill(x-1, y, t1, t2);
        if (y-1 >= 0) sum += fill(x, y-1, t1, t2);
        return sum;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        n = get(read, 0);
        grid = new int[n][n];
        visited = new boolean[n][n];
        int maxVal = 0;
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            for (int j = 0; j < n; j ++) {
                grid[i][j] = get(read, 0);
                maxVal = Math.max(maxVal, grid[i][j]);
                //stderr.print(grid[i][j] + " ");
            }
            //stderr.println();
        }
        totalCount = new int[maxVal+1];
        areaCount = new int[maxVal+1];
        /* run */
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                totalCount[grid[i][j]] ++;
                if (visited[i][j]) continue;
                areaCount[grid[i][j]] = Math.max(areaCount[grid[i][j]], fill(i, j, grid[i][j]));
            }
        }
        /*for (int i = 0; i < maxVal+1; i ++) {
            stderr.println(i + ": " + areaCount[i]);
        }*/
        Arrays.sort(totalCount);
        Arrays.sort(areaCount);
        /* exit */
        stderr.println(areaCount[maxVal]);
        stderr.println(totalCount[maxVal] + totalCount[maxVal-1]);
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
