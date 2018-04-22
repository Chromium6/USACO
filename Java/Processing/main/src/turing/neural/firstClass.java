package turing.neural;
import processing.core.*; // processing lib

public class firstClass extends PApplet {
	
	public void settings() {
		size(500, 500);
	}
	
	Mover k = new Mover(this, 250, 250);
	public void draw() {
		background(0);
		if (mousePressed)
			k.seek(new PVector(mouseX, mouseY), 50);
		else
			k.wander(50);
		k.bound(50);
		k.update();
		k.manifest();
	}

	public static void main(String[] args) {
		// standard loading procedures
		String[] processingArgs = {"firstClass"};
		firstClass mySketch = new firstClass();
		PApplet.runSketch(processingArgs, mySketch);
	}

}
