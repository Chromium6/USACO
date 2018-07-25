package contest.usaco.training;

import java.io.*;
import java.util.*;

public class citystate {
	private static final String programName = "test";

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        int n = get(read, 0);
        City[] data = new City[n];
        String a, b;
        for (int i = 0; i < n; i ++) {
        	read = new StringTokenizer(stdin.readLine());
        	a = get(read);
        	b = get(read);
        	data[i] = new City(a, b);
        }
        /* var dec */
        /* run */
        Arrays.sort(data);
        for (City place : data) {
        	System.out.println(place.name + " " + place.state);
        }
        HashMap<Integer, ArrayList<String>> k = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> l = new ArrayList<String>();
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

class City implements Comparable<City> {
	String name, state; // only store first 2 letters
	
	public City(String cityName, String stateName) {
		name = cityName.substring(0, 2);
		state = stateName.substring(0, 2);
	}
	
	public boolean isPairedWith(City sister) {
		return (this.name.equals(sister.state) && this.state.equals(sister.name));
	}

	public int compareTo(City arg0) {
		if (arg0.name.equals(this.name)) return 0;
		return (arg0.name.charAt(0) > this.name.charAt(0) ? -1 : 1);
	}
	
}
