package sys;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class test {
    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        out.println("Enter a string: ");
        String k = stdin.readLine();
        out.println(k.split(" ")[0]);
    }
}
