package edu.umb.cs681.hw10;

public class RunnablePrimeFactorizer extends PrimeFactorizer implements Runnable {

	public RunnablePrimeFactorizer(long dividend, long from, long to) {
		super(dividend);
		if (from >= 2 && to >= from) {
			this.from = from;
			this.to = to;
		} else {
			throw new RuntimeException("'From' must be >= 2, 'To' must be >= 'From'. From = " + from + " to = " + to);
		}
	}

	protected boolean numberIsEven(long number) {
		// TODO Auto-generated method stub
		if(number%2 == 0){ 
			return true; 
		}
		else{ 
			return false; 
		}
	}

	public void generatePrimeFactors() {
		
		long divisor = from;
		while (dividend != 1 && divisor <= to) {
			
			if (divisor > 2 && numberIsEven(divisor)) {
				divisor++;
				continue;
			}
			if (dividend % divisor == 0) {
				factors.add(divisor);
				dividend /= divisor;
			} 
			else if (divisor == 2) { divisor++; } 
			else { divisor += 2; }
		}
	}

	public void run() {
		generatePrimeFactors();
		System.out.println("Thread #" + Thread.currentThread().getId() + " found factors	" + factors 
				+ "	in the range [" + getFrom() + "," + getTo() + "]");
	}

	public static void main(String[] args) {
		
		//-----------Single Thread ----------------------------------------------------------------
		
		System.out.println("\nPrime Factorization of 40	:\n");
		
		RunnablePrimeFactorizer r = new RunnablePrimeFactorizer(40, 2, (long) Math.sqrt(40));
		Thread thread = new Thread(r);
		
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Factors are	:\t\t" + r.getPrimeFactors() + "\n");

		//-----------Multi - Thread ----------------------------------------------------------------
				
		System.out.println("\nPrime Factorization of 84	:\n");
		
		RunnablePrimeFactorizer r1 = new RunnablePrimeFactorizer(84, 2, (long) Math.sqrt(84) / 2);
		RunnablePrimeFactorizer r2 = new RunnablePrimeFactorizer(84, 1 + (long) Math.sqrt(84) / 2, (long) Math.sqrt(84));
		
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		if (r1.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r2.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);	
		}
		else if (r2.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r1.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);
		}
		else {		
			System.out.print("Factors are	:\t\t");		
			r1.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			r2.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
		}
		
		//-----------Multi - Thread ----------------------------------------------------------------
		
		System.out.println("\n\nPrime Factorization of 2489	:\n");

		RunnablePrimeFactorizer r3 = new RunnablePrimeFactorizer(2489, 2, (long) Math.sqrt(2489) / 2);
		RunnablePrimeFactorizer r4 = new RunnablePrimeFactorizer(2489, 1 + (long) Math.sqrt(2489) / 2, (long) Math.sqrt(2489));

		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		
		t3.start();
		t4.start();
		
		try {
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		 
		if (r3.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r4.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r4.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);	
		}
		else if (r4.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r3.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r3.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);
		}
		else {		
			System.out.print("Factors are	:\t\t");		
			r3.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			r4.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
		}
		
		//-----------Multi - Thread ----------------------------------------------------------------
		
		System.out.println("\n\nPrime Factorization of 8633	:\n");

		RunnablePrimeFactorizer r5 = new RunnablePrimeFactorizer(8633, 2, (long) Math.sqrt(8633) / 2);
		RunnablePrimeFactorizer r6 = new RunnablePrimeFactorizer(8633, 1 + (long) Math.sqrt(8633) / 2, (long) Math.sqrt(8633));

		Thread t5 = new Thread(r5);
		Thread t6 = new Thread(r6);
		
		t5.start();
		t6.start();
		
		try {
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		if (r5.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r6.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r6.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);	
		}
		else if (r6.getPrimeFactors().isEmpty() ) {		
			Long temp = 2489 / r5.getPrimeFactors().element();
			System.out.println("Since, one set is empty, the complete set of prime numbers can be derived from generated factors");
			System.out.print("Factors are	:\t\t");
			r5.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			System.out.print(temp);
		}
		else {		
			System.out.print("Factors are	:\t\t");		
			r5.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
			r6.getPrimeFactors().forEach((Long l) -> System.out.print(l + ", "));
		}
	}
}
