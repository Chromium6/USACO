package ref;

public class SyncThread {

	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6};
		ThreadOb m = new ThreadOb("Thread #1", a);
		ThreadOb n = new ThreadOb("Thread #2", a);
		
		try {
			m.runOb.join();
			n.runOb.join();
		}
		catch (InterruptedException e) {
			
		}
	}
	
}

class ThreadOb implements Runnable {
	Thread runOb;
	static SumArray arrayUtil = new SumArray();
	int[] array;
	int answer;
	
	public ThreadOb(String name, int[] a) {
		runOb = new Thread(this, name);
		array = a;
		runOb.run();
	}
	
	public void run() {
		int sum;
		System.out.println(runOb.getName() + " is starting");
		
		answer = arrayUtil.getSum(array);
		System.out.println("Answer for " + runOb.getName() + " is " + answer);
		System.out.println(runOb.getName() + " is terminating");
	}
}

class SumArray {
	int sum;
	
	synchronized int getSum(int[] array) {
		sum = 0;
		for (int i : array) {
			sum += i;
			System.out.println("\t" + Thread.currentThread().getName() + "'s sum is currently " + sum);// debug
		}
		// give time for task switch
		try {
			Thread.sleep(10);
		}
		catch (InterruptedException e) {
			System.err.println(Thread.currentThread().getName() + " was prematurely terminated");
		}
		return sum;
	}
}