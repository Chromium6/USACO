package tanktrouble;

import java.util.LinkedList;
import java.util.Queue;

public class BFSRunner {
	Queue<Pair> toVisit; // bfs
	Pair[][] cameFrom; // for tracing back
	boolean[][] visited; // prevent loops
	
	public void run(Maze maze) {
		toVisit = new LinkedList<Pair>();
		cameFrom = new Pair[maze.getSize()][maze.getSize()];
		visited = new boolean[maze.getSize()][maze.getSize()];
		toVisit.add(maze.iLoc);
		cameFrom[maze.iLoc.x][maze.iLoc.y] = null;
		/* run */
		Pair curr = new Pair(0, 0), neighbor;
		int counting = 0; // label cells in the order in which transversed
		while (!toVisit.isEmpty()) { // condition for empty queue set in program
			curr = toVisit.poll();
			
			// if this is destination, stop
			if (curr.equals(maze.fLoc)) break;
			
			// if neighbors are inside maze and haven't been visited
			for (int i = -1; i <= 1; i ++) {
				for (int j = -1; j <= 1; j ++) {
					// allow only Manhattan movement
					if (!(i+j == 1 || i+j == -1)) continue;
					neighbor = curr.add(i, j);
					//System.out.println(i + " " + j);
					if (neighbor.isValid(0, maze.getSize()) &&
							!visited[neighbor.x][neighbor.y] &&
							maze.getVal(neighbor.x, neighbor.y) != 2) {
						toVisit.add(neighbor);
						cameFrom[neighbor.x][neighbor.y] = curr;
					}
				}
			}
			counting++;
			visited[curr.x][curr.y] = true;
		}
		//System.out.println(counting + " steps to arrive at (" + curr.x + ", " + curr.y + ")");
		
		/*
		// trace the route back
		Pair prev = curr;
		while (prev != maze.iLoc) {
			System.out.print("(" + prev.x + ", " + prev.y + ") -> ");
			prev = cameFrom[prev.x][prev.y];
		}*/
	}
}
