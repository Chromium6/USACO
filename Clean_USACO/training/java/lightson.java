//package lightson;

/**
 * NAME: agentmz1
 * LANG: JAVA
 * PROG: lightson
 * NOTES:
 * Brute force
 * 1-indexing
 */

import java.io.*;
import java.util.*;

public class lightson {
	private static final String programName = "test";

    static Room[][] data; // store light links
    static LinkedList<Room> toVisit; // modified BFS

	public static void main(String[] args) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);//System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* var dec */
        int n = get(read, 0), m = get(read, 0); // dimensions
        data = new Room[n][n]; // store light links
        toVisit = new LinkedList<Room>(); // modified BFS
        int counter = 0; // count max lights open
        int x, y, a, b;
        for (int i = 0; i < n; i ++)
            for (int j = 0; j < n; j ++)
                data[j][i] = new Room(0, 0);
        for (int i = 0; i < m; i ++) {
            read = new StringTokenizer(stdin.readLine());
            x = get(read, 0)-1;
            y = get(read, 0)-1;
            a = get(read, 0)-1;
            b = get(read, 0)-1;
            //System.err.println(String.format("{%d, %d} -> {%d, %d}", x, y, a, b));
            data[x][y].switches.add(data[a][b]);
        }
        //System.out.println("--------------------------------------------------");
        /* for (Room[] column : data) {
            for (Room room : column) {
                System.out.print(room.switches + " ");
            }
            System.out.println();
        }*/
        /* run */
        data[0][0].lighted = true;
        counter++;
        toVisit.addAll(data[0][0].switches);
        Room curr;
        while (!toVisit.isEmpty()) {
            curr = toVisit.poll();
            curr.visited = true;
            //System.err.println("Visiting " + curr);
            if (accessible(curr.x, curr.y, n)) {
                for (Room k : curr.switches) {
                    //System.err.println("\t Turned on " + k);
                    k.lighted = true;
                    if (!k.visited) {
                        //System.err.println("\t New room, +1");
                        toVisit.add(k);
                        counter ++;
                    }
                }
            }
        }
        /* exit */
        System.out.println(counter);
        stdin.close();
        stdout.close();
    }

    public static boolean accessible(int x, int y, int max) {
        boolean n = y-1 >= 0 ? data[x][y-1].visited : true;
        boolean s = y+1 < max ? data[x][y+1].visited : true;
        boolean e = x+1 < max ? data[x+1][y].visited : true;
        boolean w = x-1 >= 0 ? data[x-1][y].visited : true;
        return n && s && e && w;
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

class Room {
    int x, y;
    boolean lighted, visited;
    List<Room> switches;

    public Room(int x, int y) {
        this.x = x;
        this.y = y;
        lighted = false;
        visited = false;
        switches = new ArrayList<Room>();
    }

    @Override
    public String toString() {
        return String.format("{%d, %d}, linked to %s", x, y, switches);
    }
}
