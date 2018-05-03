package ref;

public class ClockTick {
	public static void main(String[] args) {
		Clock k = new Clock();
		TickTock tick = new TickTock("Tick", k);
		TickTock tock = new TickTock("Tock", k);
	}
	
}

class TickTock implements Runnable {
	Thread tOb; // thread object
	Clock runOb; // provides clock functions
	
	/** Creates a thread that either ticks or tocks
	 * 
	 * @param name
	 * - User designation for thread
	 * @param chrono
	 * - Common Clock for all threads to synchronize actions
	 * */
	public TickTock(String name, Clock chrono) {
		tOb = new Thread(this, name);
		runOb = chrono;
		tOb.run();
	}
	
	public void run() {
		if (tOb.getName().equals("Tick")) {
			while(true) {
				runOb.tick(true);
			}
		}
		else if (tOb.getName().equals("Tock")) {
			while (true) {
				runOb.tock(true);
			}
		}
	}
}

/* Provides ticking/tocking functionality. */
class Clock {
	String clockState = "tick";
	
	synchronized void tick(boolean runState) {
		if (!runState) { // stop the clock
			clockState = "ticked";
			notify();
			return;
		}
		// ticking behavior
		System.out.println("Tick ");
		// allow tocking
		clockState = "ticked";
		notify();
		// wait for tocking to finish
		try {
			while (!clockState.equals("tocked"))
				wait();
		}
		catch (InterruptedException e) {
			System.out.println("Clock counting interrupted");
		}
	}
	
	synchronized void tock(boolean runState) {
		if (!runState) { // stop the clock
			clockState = "tocked";
			notify();
			return;
		}
		// ticking behavior
		System.out.println("Tock ");
		// allow tocking
		clockState = "tocked";
		notify();
		// wait for tocking to finish
		try {
			while (!clockState.equals("ticked"))
				wait();
		}
		catch (InterruptedException e) {
			System.out.println("Clock counting interrupted");
		}
	}
	
}