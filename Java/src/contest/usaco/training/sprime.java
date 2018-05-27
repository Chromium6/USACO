//package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: sprime
NOTES: 
*/

import java.io.*;
import java.util.*;

public class sprime {
    static String programName = "sprime";

    /* func dec */
    static boolean isPrime(int n) {
    	if (n == 2) return true;
        //check if n is a multiple of 2
        if (n%2==0 || n<=1) return false;
        //if not, then just check the primes smaller than n
        for(int i=3; i*i <= n; i+=2) {
        	if(n%i==0)
                return false;
        }
        return true;
    }
    
    static boolean isSPrime(int n) {
    	while (n > 1) {
    		if (!isPrime(n)) return false;
    		n /= 10;
    	}
    	return true;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int numLength = get(read, 0);
        ArrayList<Integer> data = new ArrayList<Integer>();
        /* run */
        /* exit */
        for (int item : data)
        	stderr.println(item);
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
