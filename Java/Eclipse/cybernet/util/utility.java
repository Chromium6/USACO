package cybernet.util;
import java.io.*;

public final class utility { // prevent from being extended

    private utility() {} // prevent it from being constructed

    public static void printArray(int[] k, PrintWriter out) throws IOException {
        for (int i = 0; i < k.length; i ++)
            out.print(k[i] + " ");
        out.println();
        out.flush();
    }
}