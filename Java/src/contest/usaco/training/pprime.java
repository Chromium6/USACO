package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: pprime
NOTES:
ok to brute force, only 20,000 permutations (palindromes)
only print numbers, no need to count
max four digits plus {0, 1}
*/

import java.io.*;
import java.util.*;

public class pprime {

    /* var dec */
    static String programName = "test";
    static int low, high; // range for generating palindromes
    static ArrayList<Integer> s; // store prime palindromes

    /* func dec */
    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0 || n<=1) return false;
        //if not, then just check the primes smaller than n
        for(int i=3; i*i <= n; i+=2) {
        	if(n%i==0)
                return false;
        }
        return true;
    }

    static int synthPalindrome(int inp, int mid, boolean oddLength) {
    	// use string processing, useful in reversing numbers
        String n = inp + "";
        StringBuilder revN = new StringBuilder(n);
        String palindrome = n + (oddLength? mid : "") + revN.reverse();
    
        return Integer.parseInt(palindrome);
    }
    
    // passed
	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true); //System.err, true);// 
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        low = get(read, 0);
        high = get(read, 0);
        s = new ArrayList<Integer>();
        /* run */
        int num;
        // Run two times for odd and even length palindromes
        // avoid even numbers
        for (int a = 1; a <10; a += 2) {
        	if (a > high || a > (high+"").charAt(0)) break;
        	else if (isPrime(a) && a >= low) s.add(a);
        	for (int b = 0; b < 10; b ++) {
        		num = synthPalindrome(a, b, false);
        		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
        		num = synthPalindrome(a, b, true);
        		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
        		for (int c = 0; c < 10; c ++) {
        			num = synthPalindrome(10*a+b, c, false);
            		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
            		num = synthPalindrome(10*a+b, c, true);
            		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
            		for (int d = 0; d < 10; d ++) {
            			num = synthPalindrome(100*a+10*b+c, d, false);
                		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
                		num = synthPalindrome(100*a+10*b+c, d, true);
                		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
                		num = synthPalindrome(1000*a+100*b+10*c+d, 0, false);
                		if (isPrime(num) && s.lastIndexOf(num) == -1 && num >= low && num <= high) s.add(num);
            		}
        		}
        	}
        }
        Collections.sort(s);
        for (int i : s)
        	stdout.println(i);
        /* exit */
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
