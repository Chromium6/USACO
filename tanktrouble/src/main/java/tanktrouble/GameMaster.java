package tanktrouble;

import org.jbox2d.common.Vec2;
import org.jbox2d.particle.ParticleSystem;

import processing.core.*;

public class GameMaster extends PApplet{
	Tank player;
	Maze maze;
	MazeRunner runner;
	
	// necessary in Eclipse to define size() and smooth() 
	public void settings() {
		size(500, 500);
	}
	
	// Processing
	public void setup() {
		player  = new Tank(this, new PVector(width/2, height/2));
		maze = new Maze("testMaze.txt");
		runner = new MazeRunner(maze);
		runner.setDisplay(this);
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
		/*runner.bfsTransverse(maze.iLoc, maze.fLoc);
		Vec2 backProp = maze.fLoc;
		while (runner.cameFrom[(int)backProp.x][(int)backProp.y] != backProp) {
			if (backProp == null) continue;
			fill(255, 0, 0);
			rect(runner.cameFrom[(int)backProp.x][(int)backProp.y].x*maze.getSize()/height, runner.cameFrom[(int)backProp.x][(int)backProp.y].y*maze.getSize()/height, maze.getSize()/height, maze.getSize()/height);
			backProp = runner.cameFrom[(int)backProp.x][(int)backProp.y];
		}
		*/
	}
	
	// Processing
	public void draw() {
		// background(255);
		//player.display();
	}
	
	public static void main(String[] args) {
		PApplet.main("tanktrouble.GameMaster");
	}

}
