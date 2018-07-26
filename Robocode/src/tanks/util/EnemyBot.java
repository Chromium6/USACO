package tanks.util;

import robocode.ScannedRobotEvent;

public class EnemyBot {
	private double bearing, distance, energy, heading, velocity; // data for pinpointing
	private String name; // designation for enemy robot
	
	public EnemyBot() {
		// init vars
		reset();
	}
	
	// update parameters for the enemy
	public void update(ScannedRobotEvent e) {
		bearing = e.getBearing();
		distance = e.getDistance();
		energy = e.getDistance();
		heading = e.getHeading();
		velocity = e.getVelocity();
		name = e.getName();
	}
	
	// reconfigure for a new enemy
	public void reset() {
		bearing = 0.0;
		distance = 0.0;
		energy = 0.0;
		heading = 0.0;
		velocity = 0.0;
		name = "";
	}
	
	// detects if the EnemyBot is in a "clean slate" state
	public boolean isReset() { return name.equals(""); }
	
	// for debugging
	@Override
	public String toString() {
		if (isReset()) return "EnemyRobot has been reset";
		return String.format("[%s]\n"
				+ "\tBearing: %e\n"
				+ "\tDistance to me: %e\n"
				+ "\tEnergy: %e/100\n"
				+ "\tHeading: %e\n"
				+ "\tVelocity: %e\n",
				name, bearing, distance, energy, heading, velocity);
	}
	
	/* Accessors */
	public double getBearing() { return bearing; }
	public double getDistance() { return distance; }
	public double getEnergy() { return energy; }
	public double getHeading() { return heading; }
	public double getVelocity() { return velocity; }
	public String getName() { return name; }
}
