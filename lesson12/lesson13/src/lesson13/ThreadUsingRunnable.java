package lesson13;

public class ThreadUsingRunnable implements Runnable {
	
	
	@Override
	public void run () {
		System.out.println ("your run code") ; 
		
	}
	
	public void startThread() {
		Thread theThread = new Thread(this);
		theThread.start();
	}

	 public static void main (String args [] ) {
		 
		 ThreadUsingRunnable tr = new ThreadUsingRunnable () ; 
		 tr.startThread();
		 
	 }
}
