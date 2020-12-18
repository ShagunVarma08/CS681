package edu.umb.cs681.hw17;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class RequestHandler implements Runnable {
	
	private ReentrantLock lock = new ReentrantLock();
	private boolean done = false;
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}
		finally {
			lock.unlock();
		}
	}

	public void run() {
		Random random = new Random();
		int randomHtml = random.nextInt(5);
		while(true) {
			lock.lock();
			try {
				if(done) {
					System.out.println(Thread.currentThread().getName() + " Done.");
					break;
				}
			} finally {
				lock.unlock();
			}
			java.nio.file.Path path = null;
			switch(randomHtml){
			case 0:
				path = java.nio.file.Paths.get("a.html");
				break;
			case 1:
				path = java.nio.file.Paths.get("b.html");
				break;
			case 2:
				path = java.nio.file.Paths.get("c.html");
				break;
			case 3:
				path = java.nio.file.Paths.get("d.html");
				break;
			case 4:
				path = java.nio.file.Paths.get("e.html");
				break;
			default:
			}
			
			AccessCounter.getInstance().increment(path);
			AccessCounter.getInstance().getCount(path);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException e) {
				System.out.println(e);
				continue;
			}
		}
	}
	
	public static void main(String[] args) {
		
		RequestHandler r1  = new RequestHandler();
		RequestHandler r2  = new RequestHandler();
		RequestHandler r3  = new RequestHandler();
		RequestHandler r4  = new RequestHandler();
		RequestHandler r5  = new RequestHandler();
		RequestHandler r6  = new RequestHandler();
		RequestHandler r7  = new RequestHandler();
		RequestHandler r8  = new RequestHandler();
		RequestHandler r9  = new RequestHandler();		
		RequestHandler r10 = new RequestHandler();
		RequestHandler r11 = new RequestHandler();
		RequestHandler r12 = new RequestHandler();
		RequestHandler r13 = new RequestHandler();
		RequestHandler r14 = new RequestHandler();
		RequestHandler r15 = new RequestHandler();
		
		Thread T1  = new Thread(r1);
		Thread T2  = new Thread(r2);
		Thread T3  = new Thread(r3);
		Thread T4  = new Thread(r4);
		Thread T5  = new Thread(r5);
		Thread T6  = new Thread(r6);
		Thread T7  = new Thread(r7);
		Thread T8  = new Thread(r8);
		Thread T9  = new Thread(r9);
		Thread T10 = new Thread(r10);
		Thread T11 = new Thread(r11);
		Thread T12 = new Thread(r12);
		Thread T13 = new Thread(r13);
		Thread T14 = new Thread(r14);
		Thread T15 = new Thread(r15);
		
		T1.start();
		T2.start();
		T3.start();
		T4.start();
		T5.start();
		T6.start();
		T7.start();
		T8.start();
		T9.start();
		T10.start();
		T11.start();
		T12.start();
		T13.start();
		T14.start();
		T15.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		r1.setDone();
		r2.setDone();
		r3.setDone();
		r4.setDone();
		r5.setDone();
		r6.setDone();
		r7.setDone();
		r8.setDone();
		r9.setDone();
		r10.setDone();
		r11.setDone();
		r12.setDone();
		r13.setDone();
		r14.setDone();
		r15.setDone();
		
		T1.interrupt();
		T2.interrupt();
		T3.interrupt();
		T4.interrupt();
		T5.interrupt();
		T6.interrupt();
		T7.interrupt();
		T8.interrupt();
		T9.interrupt();
		T10.interrupt();
		T11.interrupt();
		T12.interrupt();
		T13.interrupt();
		T14.interrupt();
		T15.interrupt();
		
		try {
			T1.join();
			T2.join();
			T3.join();
			T4.join();
			T5.join();
			T6.join();
			T7.join();
			T8.join();
			T9.join();
			T10.join();
			T11.join();
			T12.join();
			T13.join();
			T14.join();
			T15.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}   		
	}	
}