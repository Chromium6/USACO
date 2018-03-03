import java.io.*;
import java.util.*;

public class IO {

    /* var dec */
    static String programName = "test";

	public static void main(String args[]) throws IOException {
		BufferedReader stdin = new BufferedReader(new FileReader(programName + ".in"));
        PrintWriter stdout = new PrintWriter(new BufferedWriter(new FileWriter(programName + ".out")), true);
        PrintWriter stderr = new PrintWriter(System.err, true);
        StringTokenizer read = new StringTokenizer(stdin.readLine());
        /* init */
        int a = Integer.parseInt(read.nextToken());
        int b = Integer.parseInt(read.nextToken());
        /* run */
        stderr.println("Is this thing optimized?");
        stderr.println(a + b);
        /* exit */
	}
}
