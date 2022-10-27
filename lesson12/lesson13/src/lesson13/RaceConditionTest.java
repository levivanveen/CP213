package lesson13;

class Counter {

	private int counter;

	public Counter() {
		counter = 0;
	}

	public int value() {
		return counter;
	}

	public void increment() {
		int local;
		synchronized (this) {
			local = counter;
			local++;
			counter = local;
		}
	}
}

public class RaceConditionTest extends Thread {
	
	
	private Counter countObject;

	public RaceConditionTest(Counter ctr) {
		countObject = ctr;
	}

	public void run() {
		countObject.increment();
	}

	
	public static void main(String[] args) {
		int i;
		Counter masterCounter = new Counter();
		RaceConditionTest[] threads = new RaceConditionTest[33000];

		System.out.println("The counter is " + masterCounter.value());
		for (i = 0; i < threads.length; i++) {
			threads[i] = new RaceConditionTest(masterCounter);
			threads[i].start();
		}

	
		// Wait for the threads to finish
		for (i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("The counter is " + masterCounter.value());
	}
}
