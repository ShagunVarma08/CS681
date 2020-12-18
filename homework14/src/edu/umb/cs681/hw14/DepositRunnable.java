package edu.umb.cs681.hw14;

import java.util.concurrent.atomic.AtomicBoolean;

public class DepositRunnable implements Runnable {
	
	private ThreadSafeBankAccount account = null;
	public AtomicBoolean done = new AtomicBoolean(false);
	
	public void setDone() {
		done.getAndSet(true);
	}
	
	public DepositRunnable(ThreadSafeBankAccount account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			if(done.get()) {
				System.out.println(Thread.currentThread().getName() +"\t Successfuly deposited money!");
    			break;
			}
			
			System.out.println(Thread.currentThread().getName() +"\t Depositing money!");
			account.deposit(300);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				System.out.println(e.toString());
				continue;
			}
		}
	}
}
