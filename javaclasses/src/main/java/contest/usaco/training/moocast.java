package contest.usaco.training;

import java.io.*;
import java.util.*;

// passed
public class moocast {
	private static final String programName = "moocast";
	static Cow[] data;
	static double[][] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0);
        data = new Cow[n];
        dist = new double[n][n];
        for (int i = 0; i < n; i ++) {
        	read = new StringTokenizer(stdin.readLine());
        	data[i] = new Cow(get(read, 0), get(read, 0), get(read, 0));
        	//System.out.println(data[i]);
        }
        for (int a = 0; a < n-1; a ++) {
        	for (int b = a+1; b < n; b ++) {
        		int dx = (data[a].x-data[b].x)*(data[a].x-data[b].x);
        		int dy = (data[a].y-data[b].y)*(data[a].y-data[b].y);
        		dist[a][b] = dist[b][a] = Math.sqrt(dx + dy);
        		//System.out.println(String.format("[%s] <-> [%s] = %s", data[a], data[b], dist[a][b]));
        	}
        }
        /* run */
        int max = 0;
        for (int i = 0; i < n; i ++) {
        	max = Math.max(max, sendSignal(i, new ArrayList<Integer>())+1);
        }
        /* exit */
        stdout.println(max);
        stdin.close();
        stdout.close();
	}
	
	static int sendSignal(int cow, List<Integer> visited) {
		int reached = 0;
		visited.add(cow);
		for (int i = 0; i < data.length; i ++) {
			if (i == cow || visited.contains(i)) continue;
			if (dist[cow][i] <= data[cow].power) {
				//System.out.println("Cow " + data[cow] + " can reach " + "Cow " + data[i] + " with distance " + dist[cow][i]);
				reached += 1 + sendSignal(i, visited);
			}
			//else System.out.println("\tCow " + data[cow] + " can't reach " + "Cow " + data[i] + " with distance " + dist[cow][i]);
		}
		return reached;
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

class Cow implements Comparable<Cow>{
	int x, y, power;
	
	Cow(int ix, int iy, int ip) {
		x = ix;
		y = iy;
		power = ip;
	}
	
	@Override
	public String toString() {
		return (String.format("(%s, %s) -> %s", x, y, power));
	}

	public int compareTo(Cow arg0) {
		if (arg0.power == this.power) return 0;
		return (arg0.power > this.power ? -1 : 1);
	}
	
}
