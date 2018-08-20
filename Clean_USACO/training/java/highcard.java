// package training;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: BLANK
 * NOTES:
 */

// passed
import java.io.*;
import java.util.*;

public class highcard {
    private static final String programName = "highcard";
    /* var dec */
    static ArrayList<Integer> bessie, elsie; // two cow's cards (a is Bessie, the first player)
    static int maxPoints; // maximum points Bessie can earn

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        int n = get(read, 0);
        bessie = new ArrayList<Integer>();
        elsie = new ArrayList<Integer>();
        maxPoints = 0;
        boolean[] elsieHas = new boolean[2*n];
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            elsieHas[get(read, 0)-1] = true;
        }
        for (int i = 1; i <= 2*n; i ++) {
            if (elsieHas[i-1]) elsie.add(i);
            else bessie.add(i);
        }
        // System.out.println(String.format("Bessie:\t%s\nElsie:\t%s", bessie, elsie));
        /* run */
        // check every card of Bessie's cards
        int bessieIndex = 0;
        int elsieIndex = 0;
        while(bessieIndex < n && elsieIndex < n) {
            // check if Bessie's smallest card could beat Elsie's
            if (bessie.get(bessieIndex) > elsie.get(elsieIndex)) {
                // a) if so, pair them and count
                bessieIndex++;
                elsieIndex++;
                maxPoints++;
            } 
            else {
                // b) if not, discard Bessie's card
                bessieIndex++;
            }
        }
        /* exit */
        stdout.println(maxPoints);
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