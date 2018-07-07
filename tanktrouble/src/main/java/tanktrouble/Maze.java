package tanktrouble;

import java.io.*;
import org.jbox2d.common.Vec2;
import java.util.*;

public class Maze implements Grid {
	private int[][] data;
	Pair iLoc; // start destination
	Pair fLoc; // final destination
	
	public Maze(int size) { 
		data = new int[size][size];
		iLoc = fLoc = new Pair(0, 0);
	}
	
	public Maze(String fileName) { readFromFile(fileName); }
	
	public int getVal(int x, int y) { return data[x][y]; }

	public void setVal(int x, int y, int val) { data[x][y]= val; }
	
	public int getSize() { return data.length; }

	public void readFromFile(String filePath) {
		try (BufferedReader stdin = new BufferedReader(new FileReader(filePath))) {
			StringTokenizer read;
			String empty, wall, start, exit;
			// first line specifies components for empty, wall, start, exit blocks respectively
			read = new StringTokenizer(stdin.readLine());
			empty = read.nextToken();
			wall = read.nextToken();
			start = read.nextToken();
			exit = read.nextToken();
			// infer grid size (guaranteed to be a square)
			read = new StringTokenizer(stdin.readLine());
			int n = read.countTokens();
			data = new int[n][n];
			// parse information
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					String val = read.nextToken();
					int equiVal = 0;
					if (val.equals(empty)) equiVal = 1;
					else if (val.equals(wall)) equiVal = 2;
					else if (val.equals(start)) {
						equiVal = 3;
						iLoc = new Pair(j, i);
					}
					else if (val.equals(exit)) {
						equiVal = 4;
						fLoc = new Pair(j, i);
					}
					setVal(j, i, equiVal); 
				}
				if (i+1 < n) read = new StringTokenizer(stdin.readLine());
			}
		}
		catch (IOException ioe) {
			System.err.println("[KHRYO] Unable to read data from " + filePath + ": " + ioe.getMessage());
		}
		catch (NoSuchElementException nsee) {
			System.err.println("[KHRYO] " + filePath + " was not formatted properly: " + nsee.getMessage());
		}
	}
	
}
