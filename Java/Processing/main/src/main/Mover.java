package main;
import processing.core.*; // processing lib

public class Mover {
	PApplet p; // Processing sketch in which this Mover exists
	PVector location, velocity, acceleration; // physics
	float maxForce; // limitations
	float maxSpeed;
	float size;
	float wandering; // angle for wandering
	
	/* init */
	public Mover(PApplet current, int xi, int yi) {
		p = current;
		location = new PVector(xi, yi);
		velocity = new PVector(0, 0);
		acceleration = new PVector(0, 0);
		wandering = 0;
		
		// physical settings
		maxForce = 0.1f;
		maxSpeed = 4;
		size = 6;
	}
	
	/* methods */
	public void wander(int arrivingRadius) {
		float wanderR = 25; // Radius for our "wander circle"
	    float wanderD = 40; // Distance for our "wander circle"
	    float change = 0.3f; // range for change
	    wandering += p.random(-change,change);

	    // Now we have to calculate the new location to steer towards on the wander circle
	    PVector circleloc = velocity.get();    // Start with velocity
	    circleloc.normalize();            // Normalize to get heading
	    circleloc.mult(wanderD);          // Multiply by distance
	    circleloc.add(location);               // Make it relative to boid's location
	    
	    float h = velocity.heading();        // We need to know the heading to offset wandertheta

	    PVector circleOffSet = new PVector(wanderR*p.cos(wandering+h),wanderR*p.sin(wandering+h));
	    PVector target = PVector.add(circleloc,circleOffSet);
	    seek(target, arrivingRadius);

	    // Debugging stuff
	    // drawWanderStuff(location,circleloc,target,wanderR);
		seek(target, arrivingRadius);
	}
	
	public void seek(PVector target, int arrivingRadius) {
		PVector desiredVelocity = PVector.sub(target, location);
		float d = desiredVelocity.mag();
		desiredVelocity.normalize(); // make it a rational [0, 1]
		
		if (d < arrivingRadius) {
			// slowly arrive
			float reducedSpeed = (float)(p.map(d, 0, arrivingRadius, 0, maxSpeed));// slowly arrive at target
			desiredVelocity.mult(reducedSpeed);
		}
		else
			// full speed ahead!
			desiredVelocity.mult(maxSpeed);
		
		PVector steer = PVector.sub(desiredVelocity, velocity);
		steer.limit(maxForce); // limited propulsion force
		applyForce(steer);
	}
	
	public void bound(int border) { // stay a certain distance away from walls
		PVector steer = velocity.get();
		if (location.x < border)
			steer.x = maxSpeed;
		if (location.x > p.width-border)
			steer.x = -maxSpeed;
		if (location.y < border)
			steer.y = maxSpeed;
		if (location.y > p.height-border)
			steer.y = -maxSpeed;
		PVector delta = PVector.sub(steer, velocity);
		delta.limit(maxForce);
		applyForce(delta);
	}
	
	public void applyForce(PVector f) {
		acceleration.add(f);
	}
	
	public void update() {
		velocity.add(acceleration);
		//velocity.limit(maxSpeed);
		location.add(velocity);
		
		location.x = p.constrain(location.x, 0, p.width);
		location.y = p.constrain(location.y, 0, p.height);
		
		acceleration.mult(0); // reset acceleration after step
	}
	
	public void manifest() {
		float angle = velocity.heading() + p.PI/2;
		p.fill(175);
		p.stroke(0);
		p.pushMatrix();
		p.translate(location.x,location.y);
		p.rotate(angle);
		p.beginShape();
		p.vertex(0, -size*2);
		p.vertex(-size, size*2);
		p.vertex(size, size*2);
		p.endShape(p.CLOSE);
		p.popMatrix();
	}
}
