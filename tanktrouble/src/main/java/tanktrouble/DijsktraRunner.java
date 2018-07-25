package tanktrouble;

import java.util.*;

public class DijsktraRunner {
	static Maze maze;
	static Queue<Cell> runThrough = new PriorityQueue<Cell>();
	static Pair[][] cameFrom;
	static boolean[][] visited;

	public static void main(String[] args) {
		//maze = new Maze("testMaze.txt");
		//cameFrom = new Pair[maze.getSize()][maze.getSize()];
		//visited = new boolean[maze.getSize()][maze.getSize()];
		int w = 7, h = 3;
		for (int x = 0; x < h; x ++) {
			System.out.print(x + ": ");
			for (int y = 0; y < w; y ++) {
				System.out.print(y + " ");
				//System.out.print((y+1+(x)*w) + " ");
			}
			System.out.println();
		}
	}

}
