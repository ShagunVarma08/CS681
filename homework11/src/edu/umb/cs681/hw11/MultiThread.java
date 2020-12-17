package edu.umb.cs681.hw11;

public class MultiThread implements Runnable {
	
    public void run() {
        System.out.println(ConcurrentSingleton.getInstance());
        System.out.println("\nEnd of Thread " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
    	
    	Thread T1 = new Thread(new MultiThread());
		Thread T2 = new Thread(new MultiThread());
		Thread T3 = new Thread(new MultiThread());
		Thread T4 = new Thread(new MultiThread());
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		
		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
