package tanks;

import robocode.*; // tank API
import tanks.util.*; // custom utility classes

import java.awt.*;

public class FirstTank extends AdvancedRobot {
	private double turretRotation; // delta theta for turret turning 
						   // (positive y-axis is 0, positive is clockwise)
	private	EnemyBot target; // store enemy data
	
	public FirstTank() throws AWTException {
		super();
	}
	
	/* Reactions */
	public void onScannedRobot(ScannedRobotEvent e) {
		// update enemy information if it's the enemy we want
		if (target.isReset() || e.getName().equals(target.getName()))
			target.update(e);
		setTurnGunRight(getGunHeading()-getRadarHeading()+target.getBearing());
		fire(1);
	}
	
	/* Main function */
	public void run() {
		settings();
		//target.reset();
		// stay stationary and scan
		while (true) {
			turnGunRight(turretRotation);
		}
	}
	
	/* Tank specifications */
	private void settings() {
		// colors
		setBodyColor(new Color(0, 0, 255)); // solid blue
		setGunColor(new Color(255, 0, 0)); // solid red
		setRadarColor(new Color(255, 0, 255)); // solid purple
		setScanColor(Color.white); // default white
		setBulletColor(Color.blue); // default blue
		
		// turret
		setAdjustGunForRobotTurn(true); // keep gun still when robot turns
		setAdjustRadarForRobotTurn(true); // keep radar still when robot turns
		turretRotation = 5.0; // fine control
	}
	
}
