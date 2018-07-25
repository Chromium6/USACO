package tanktrouble;

import processing.core.*;

public class GameMaster extends PApplet{
	Maze maze;
	BFSRunner crudeRunner;
	
	// necessary in Eclipse to define size() and smooth() 
	public void settings() {
		size(600, 600);
	}
	
	// Processing
	public void setup() {
		maze = new Maze("testMaze.txt");
		crudeRunner = new BFSRunner();
		rectMode(CENTER);
		
		for (int i = 0; i < maze.getSize(); i ++) {
			for (int j = 0; j < maze.getSize(); j ++) {
				int unitL = height/maze.getSize();
				if (maze.getVal(j, i) == 1) fill(255);
				else if (maze.getVal(j, i) == 2) fill(0);
				else if (maze.getVal(j, i) == 3) fill(0, 255, 0);
				else if (maze.getVal(j, i) == 4) fill(255, 255, 0);
				rect(j*unitL + unitL/2, i*unitL + unitL/2, unitL, unitL);
			}
		}
		
		crudeRunner.run(maze);
		Pair curr = maze.fLoc;
		Pair prev = curr;
		while (prev != maze.iLoc) {
			prev = crudeRunner.cameFrom[prev.x][prev.y];
			if (prev == maze.iLoc) break;
			fill(255, 0, 0);
			float unit = height/maze.getSize();
			rect((float)((prev.x+0.5)*unit), (float)((prev.y+0.5)*unit), unit, unit);			
		}
		
	}
	
	// Processing
	public void draw() {
		noStroke();
		background(255);
		int unit = height/maze.getSize();
		int x = (int)Math.round(mouseX/unit), y = (int)Math.round(mouseY/unit);
		if (maze.getVal(x, y) == 1) maze.iLoc = new Pair(x, y);
		crudeRunner.run(maze);
		Pair curr = maze.fLoc;
		Pair prev = curr;
		for (int i = 0; i < maze.getSize(); i ++) {
			for (int j = 0; j < maze.getSize(); j ++) {
				int unitL = height/maze.getSize();
				if (maze.getVal(j, i) == 1) fill(255);
				else if (maze.getVal(j, i) == 2) fill(0);
				else if (maze.getVal(j, i) == 3) fill(0, 255, 0);
				else if (maze.getVal(j, i) == 4) fill(255, 255, 0);
				rect(j*unitL + unitL/2, i*unitL + unitL/2, unitL, unitL);
			}
		}
		
		//System.out.println(String.format("Mouse is at (%s, %s)", x, y));
		
		while (prev != maze.iLoc) {
			prev = crudeRunner.cameFrom[prev.x][prev.y];
			fill(255, 0, 0);
			rect((float)((prev.x+0.5)*unit), (float)((prev.y+0.5)*unit), unit, unit);			
		}
		
		maze.saveFile("backup.txt");
	}
	
	public static void main(String[] args) {
		PApplet.main("tanktrouble.GameMaster");
		System.out.println("Checkpoint");
	}

}
