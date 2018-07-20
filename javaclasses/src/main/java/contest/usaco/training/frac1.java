package contest.usaco.training;
/**
NAME: agentmz1
LANG: JAVA
PROG: frac1
NOTES: 
*/

import java.io.*;
import java.util.*;

// passed
public class frac1 {
	private static final String programName = "frac1";
	
	static double gcd(double x, double y) {
        double r = 0.0;
        double a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
 
        r = b;
        while(a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
	
	static boolean isReduced(Fraction k) {
		return gcd(k.num, k.den) != 1.0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0);
        List<Double> vals = new ArrayList<Double>();
        List<Fraction> valid = new ArrayList<Fraction>();
        /* run */
        vals.add(0.0);
        vals.add(1.0);
        valid.add(new Fraction(0.0, 1.0));
        for (double denominator = n; denominator > 0; denominator --) {
        	for (double numerator = 1.0; numerator < denominator; numerator ++) {
        		Fraction val = new Fraction(numerator, denominator);
        		//System.out.println(numerator + "/" + denominator + " = " + val);
        		if (isReduced(val)) continue;
        		valid.add(val);
        		vals.add(val.val);
        	}
        }
        valid.add(new Fraction(1.0, 1.0));
        Collections.sort(valid);
        /* exit */
        for (Fraction i : valid)
        	stdout.println((int)(i.num) + "/" + (int)(i.den));
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

class Fraction implements Comparable {
	double num, den, val;
	
	public Fraction(double n, double d) {
		num = n;
		den = d;
		val = num/den;
	}

	@Override
	public int compareTo(Object o) {
		if (((Fraction)o).val > this.val) return -1;
		return 1;
	}
}
