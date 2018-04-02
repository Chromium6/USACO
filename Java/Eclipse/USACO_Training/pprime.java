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
    static String programName = "pprime";
    static int low, high; // range for generating palindromes
    static ArrayList<Integer> s; // store prime palindromes

    /* func dec */
    static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3; i*i<=n; i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    static int synthPalindrome(int inp, int mid, boolean oddLength) {
        int n = inp;
        int palindrome = inp;
        if (oddLength) n /= mid;
        while (n > 0) {
            palindrome = palindrome * mid + (n % mid);
            n /= mid;
        }
        return palindrome;
    }

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stderr = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true); //System.err, true);// 
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        low = get(read, 0);
        high = get(read, 0);
        s = new ArrayList<Integer>();
        /* run */
        // brute force XD
        int num;
        // Run two times for odd and even length palindromes
        for (int j = 0; j < 2; j++) {
            int i = 1;
            while ((num = synthPalindrome(i, 10, (j % 2 == 0 ? true : false))) < high) {
                if (isPrime(num) && num >= low) s.add(num);
                i++;
            }
        }
        Collections.sort(s);
        for (int i = 0; i < s.size(); i ++) {
            stderr.println(s.get(i));
        }
        /* exit */
        //stderr.println();
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
