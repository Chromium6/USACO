package tanktrouble;

import processing.core.*;

public class Tank {
	private static final int width = 25, height = 40; // standard dimensions
	private PApplet pSuper; // parent PApplet
	private PVector loc, vel, acc;
	
	public Tank(PApplet parentPApplet, PVector initLocation) {
		pSuper = parentPApplet;
		loc = initLocation;
		vel = acc = new PVector(0, 0);
	}
	
	public void display() {
		pSuper.pushMatrix();
		pSuper.fill(200);
		pSuper.rect(loc.x, loc.y, width, height);
		pSuper.popMatrix();
	}
}
