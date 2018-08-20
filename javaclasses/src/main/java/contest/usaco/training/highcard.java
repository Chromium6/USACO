package contest.usaco.training;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: highcard
 * NOTES:
 */

import java.io.*;
import java.util.*;

public class highcard {
    private static final String programName = "highcard";

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0);
        List<Integer> e = new ArrayList<Integer>(); // temp Elsie
        List<Integer> b = new ArrayList<Integer>(); // temp Bessie
        for (int i = 0; i < n; i ++) {
            read = new StringTokenizer(stdin.readLine());
            e.add(get(read, 0));
        }
        for (int i = 1; i <= 2*n; i ++) {
            if (!e.contains(i)) b.add(i);
        }
        /* run */
        Collections.sort(b);
        Collections.sort(e);
        System.out.println("Bessie:" + b);
        System.out.println("Elsie:" + e);
        int bPos = 0, ePos = 0; // take minimum cards
        while (bPos < b.size() && ePos < e.size()) {
            
        }
        /*/ Big to small
        for (int j = b.size()-1; j >= 0; j --) {
            if (j >= b.size()) continue;
            for (int i = e.size()-1; i >= 0; i --) {
                if(b.get(j) > e.get(i)) {
                    //System.out.println(b.get(j) + " -> " + e.get(i));
                    sum ++;
                    e.remove(i);
                    b.remove(j);
                    //System.out.println("B: " + b + "\nE: " + e);
                    break;
                }
            }
        }*/
        /* exit */
        stdout.println(ePos);
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

/*/ Generating test cases
        while (e.size() != b.size()) {
            Random r = new Random();
            card = r.nextInt(2*n)+1;
            if(b.contains(card) && !e.contains(card)) {
                b.remove((Integer)card);
                e.add((Integer)card);
            }
        }
        */