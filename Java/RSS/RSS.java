import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.System.*;

public class RSS {
    
    /* var dec */
    static String url = "rss.cnn.com/rss/edition.rss";
    static URL path;

    public static void main(String args[]) {
        init();
        logic();
        exit();
    }

    private static void init() {
        try {
            path = new URL(url);
        }
        catch (MalformedURLException mue) {
            System.out.println("Bad URL");
        }
    }

    private static void logic() {
        System.out.println(readRSS(url));
    }

    private static String readRSS(String url) {
        String humanReadable = ""; // returned result
        String line; // line-by-line reading
        // open connection (autoclose resource)
        try(BufferedReader stdin = new BufferedReader(new InputStreamReader(path.openStream()))) {
            // keep reading while there is still stuff to read
            while ((line = stdin.readLine()) != null) {
                // only print the lines with title (CUSTOMIZABLE)
                if (line.contains("<title>") && line.contains("</title>")) {
                    // locate tags
                    int head = line.indexOf("<title>");
                    String result = line.substring(head).replace("<title>", "");
                    // chop them off
                    int end = result.indexOf("</title>");
                    result = result.substring(0, end);
                    // add to result
                    humanReadable += result + "\n";
                }
            }
            return humanReadable;
        }
        catch (IOException ioe) {
            System.out.println("Error opening website " + url);
            humanReadable = "\n";
        }
        catch (NullPointerException mue) {
            System.out.println("Bad URL. Please advise.");
        }
        return "";
    }

    private static void exit() {
        
    }
}