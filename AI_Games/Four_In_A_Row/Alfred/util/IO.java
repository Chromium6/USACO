package util;
import java.io.*;

/**
Handles communications with the game engine (I/O)
*/
public class IO {
    private BufferedReader stdin;
    private PrintWriter stdout;

    public IO() {
        // read from standard ports
        stdin = new BufferedReader(new InputStreamReader(System.in));
        stdout = new PrintWriter(System.out);
    }

    public String nextLine() throws IOException {
        return stdin.readLine();
    }

    public void putToken(int column) {
        stdout.println("place_disc " + column);
        stdout.flush();
    }

}