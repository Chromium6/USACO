package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: sprime
NOTES: 
*/

import java.io.*;
import java.util.*;

// passed
public class sprime {
    static String programName = "sprime";
    static final int[] headDigits = {2, 3, 5, 7}; // head digits
    static final int[] tailDigits = {1, 3, 5, 7, 9}; // subsequent digits
    static ArrayList<Integer> data = new ArrayList<Integer>();
    
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
    
    static void findSPrimes(int current, int numLength) {
    	//System.out.println("Testing " + current);
    	if ((""+current).length() == numLength) {
    		if (isPrime(current)) {
    			data.add(current);
    			//System.out.println("\tTrue");
    		}
    		return;
    	}
    	for (int tail : tailDigits) {
    		int newNum = current*10 + tail;
    		if (!isPrime(newNum)) continue;
    		findSPrimes(current*10+tail, numLength);
    	}
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int numLength = get(read, 0);
        /* run */
        String num;
        for (int head : headDigits) {
        	findSPrimes(head, numLength);
        }
        /* exit */
        for (int i : data)
        	stdout.println(i);
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
