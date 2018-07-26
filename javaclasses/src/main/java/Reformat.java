import java.io.*;
import java.util.StringTokenizer;

public class Reformat {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new FileReader("C:\\Users\\Michael Zhang\\Documents\\NetBeansProjects\\BrailleCustomRecognize\\Raw Data\\BrailleAlphabet.txt"));
        StringTokenizer read;
        double[][] data = new double[32][26];
        for (int item = 0; item < 26; item ++) {
            read = new StringTokenizer(stdin.readLine());
        	//System.out.println((item+1) + ": " + stdin.readLine());
            for (int row = 0; row < 32; row++) {
                data[row][item] = (double)(Integer.parseInt(read.nextToken()));
                System.out.print(data[row][item] + " ");
            }
            System.out.println();
        }
        
        PrintWriter stdout = new PrintWriter(new File("C:\\Users\\Michael Zhang\\Documents\\NetBeansProjects\\BrailleCustomRecognize\\Raw Data\\BrailleAlphabetFormatted.txt"));
		for (int row = 0; row < 32; row ++) {
			for (int item = 0; item < 26; item ++) {
				stdout.print(data[row][item] + " ");
			}
			stdout.println();
		}
		stdout.flush();
	}
}
