package edu.umb.cs681.hw12;

public class MultiThread implements Runnable {

    public void run() {
    	
        Customer customer = new Customer(new Address("Beverly Hills", "Los Angeles", "CA", 90209));
        System.out.println("Customer's original address	\t\t:	"+ customer.getAddress());
        customer.setAddress(customer.getAddress().change("Gramercy Park", "Manhattan", "NY", 10010));
        System.out.println("Customer's original address changed to	\t:	"+ customer.getAddress());
        customer.setAddress(new Address("Addison", "Dallas", "TX", 75001));
        System.out.println("Customer's new address is set to	\t:	"+ customer.getAddress());
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
