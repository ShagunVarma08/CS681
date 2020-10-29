package edu.umb.cs681.hw06;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellablePrimeGenerator extends RunnablePrimeGenerator {
	
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();

	public RunnableCancellablePrimeGenerator(long from, long to) {
		super(from, to);
		// TODO Auto-generated constructor stub
	}
	
	public void generatePrimes() {
		
		for (long number = from; number <= to; number++) {
			lock.lock();
			try {
				if (done) {	break;}
				if (numberIsPrime(number)) { this.primes.add(number);}
			} finally {
				lock.unlock();
			}
		}
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = false;
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		
		RunnableCancellablePrimeGenerator gen = new RunnableCancellablePrimeGenerator(1, 100);
		
		Thread thread = new Thread(gen);
		thread.start();
		gen.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gen.getPrimes().forEach((Long prime) -> System.out.print(prime + " | "));
		System.out.println("\nCount of Prime Numbers from 1 to 100 :\t" + gen.getPrimes().size());	
	}
}