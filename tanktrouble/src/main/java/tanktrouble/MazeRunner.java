package tanktrouble;

import org.jbox2d.common.Vec2;
import processing.core.PApplet;

import java.util.*;

/** Implements A* pathfinding algorithm to exit a maze from a given start location
 * */
public class MazeRunner {
	private Maze maze;
	private Queue<Vec2> toTest; // frontier nodes to test
	Vec2 cameFrom[][]; // for bfs running
	/* debug */
	private PApplet p;
	private boolean debug;
	
	public MazeRunner(Maze toRun) {
		maze = toRun;
		toTest = new LinkedList<Vec2>();
		cameFrom = new Vec2[maze.getSize()][maze.getSize()];
	}
	
	public void bfsTransverse(Vec2 startNode, Vec2 endNode) {
		toTest.add(startNode);
		cameFrom[(int)startNode.x][(int)startNode.y] = startNode;
		Vec2 curr;
		curr = startNode;
		while ((curr = toTest.poll()) != null && curr != endNode) {
			for (int i = -1; i <= 1; i ++) {
				for (int j = -1; j <= 1; j ++) {
					if (j == 0) break;
					if (!(curr.x+i >= 0 && curr.x+i < maze.getSize()
							&& curr.y+j >= 0 && curr.y+j < maze.getSize())) continue;
					Vec2 next = new Vec2(curr.x+i, curr.y+j);
					cameFrom[(int)next.x][(int)next.y] = curr;
					if (!toTest.contains(next)) toTest.add(next);
				}
				if (i == 0) break;
			}
		}
	}
	
	public void setDisplay(PApplet parent) { p = parent; }
	public void setDebug(boolean val) { debug = val; }
}