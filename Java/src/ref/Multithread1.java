package ref;

public class Multithread1 {
	/* Threads can be in many states:
	 * 1) Running (Executing task)
	 * 2) Ready to run (Waiting for CPU priority)
	 * 3) Suspended/Resumed
	 * 4) Blocked (Waiting for a resource to be free)
	 * 5) Terminated
	 * */
	
	public static void main(String[] args) {
		RunThread myThread = new RunThread("Counting Numbers");
		MyThread myThread2 = new MyThread("Counting Numbers Ha");
		// MyThread myThread3 = new MyThread("Counting Numbers Bob");
		
		do {
			// check if threads are running with .isAlive()
		} while(myThread.runOb.isAlive() || myThread2.isAlive());
		
		/*
		try { // monitor thread activity with .join()
			myThread.runOb.join(); // wait until this thread terminates
			System.out.println(myThread.runOb.getName() + " has terminated");
			myThread2.join();
			System.out.println(myThread2.getName() + " has terminated");
		}
		catch (InterruptedException e) {
			System.err.println(e.getLocalizedMessage());
		}*/
	}

}

/* Create thread by implementing Runnable interface (Recommended) */
class RunThread implements Runnable {
	Thread runOb; // responsible for execution of this thread
	
	public RunThread(String name) {
		runOb = new Thread(this, name); // set trigger to start execution
		runOb.start(); // auto-start the thread upon its creation
	}
	
	// thread execution point
	public void run() {
		try {
			for (int i = 0; i < 10; i ++) {
				System.out.print((i+1) + "...");
				Thread.sleep(500);
			}
		}
		catch (InterruptedException ie) {
			System.err.println("Thread \"" + runOb.getName() + "\" has been prematurely terminated [" + ie.getLocalizedMessage() + "]");
		}
	}
}

/* Create thread by extending Thread class (Use if overriding Thread methods)*/
class MyThread extends Thread {
	
	public MyThread(String name) {
		super(name); // MyThread already is a Thread object
		start();
	}
	
	public void run() {
		try {
			for (int i = 0; i < 10; i ++) {
				System.out.print((10-i) + "...");
				Thread.sleep(750);
			}
		}
		catch (InterruptedException ie) {
			System.err.println("Thread \"" + getName() + "\" has been prematurely terminated [" + ie.getLocalizedMessage() + "]");
		}
	}
}