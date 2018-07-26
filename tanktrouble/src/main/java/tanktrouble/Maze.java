package tanktrouble;

import java.io.*;
import java.util.*;

public class Maze implements Grid {
	private Cell[] data; // flattens 2D maze to 1D array with hash function
	private String empty, wall, start, exit; // for reading and saving mazes from files
	Pair iLoc; // start destination
	Pair fLoc; // final destination
	
	public Maze(int size) { 
		data = new Cell[size*size+1];
		iLoc = fLoc = new Pair(0, 0);
		// name cells: convention is id(i) = (x+1)+(y*w)
	}
	
	public Maze(String fileName) { readFromFile(fileName); }
	
	public int getVal(int x, int y) { return data[flatten(x, y)].val; }
	
	public Cell getCell(int x, int y) { return data[flatten(x, y)]; }
	
	public void setVal(int x, int y, int val) { data[flatten(x, y)].val = val; }
	
	public void setCell(int x, int y, Cell val) { data[flatten(x, y)] = val; }
	
	public int getSize() { return (int)Math.sqrt(data.length); }
	
	public int flatten(int x, int y) { return (x+1)+(y*getSize()); }

	public void readFromFile(String filePath) {
		try (BufferedReader stdin = new BufferedReader(new FileReader(filePath))) {
			StringTokenizer read;
			// first line specifies components for empty, wall, start, exit blocks respectively
			read = new StringTokenizer(stdin.readLine());
			empty = read.nextToken();
			wall = read.nextToken();
			start = read.nextToken();
			exit = read.nextToken();
			// infer grid size (guaranteed to be a square)
			read = new StringTokenizer(stdin.readLine());
			int n = read.countTokens();
			data = new Cell[n*n+1];
			// parse information
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < n; j ++) {
					//System.out.print(flatten(j, i) + " ");
					String val = read.nextToken();
					int flatId = flatten(j, i);
					data[flatId] = new Cell(0);
					
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
				//System.out.println();
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
	
	public void saveFile(String fileName) {
		try {
			PrintWriter stdout = new PrintWriter(fileName);
			stdout.println(empty + " " + wall + " " + start + " " + exit);
			for (int i = 0; i < getSize(); i ++) {
				for (int j = 0; j < getSize(); j ++) {
					char val = 'p';
					switch (getVal(j, i)) {
					case 1:
						val = empty.charAt(0);
						break;
					case 2:
						val = wall.charAt(0);
						break;
					case 3:
						val = start.charAt(0);
						break;
					case 4:
						val = exit.charAt(0);
						break;
					}
					stdout.print(val + " ");
				}
				stdout.println();
			}
			stdout.flush();
		}
		catch (IOException ioe) {
			System.err.println("Problem when saving to " + fileName + ": " + ioe.getMessage());
		}
	}
	
}
