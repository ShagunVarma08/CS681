package edu.umb.cs681.hw07;

import java.util.LinkedList;

public class PrimeFactorizer {
	
	protected long dividend;
	protected long from, to;
	protected LinkedList<Long> factors = new LinkedList<Long>();

	public PrimeFactorizer(long dividend) {
		if (dividend > 1) {
			this.dividend = dividend;
			this.from = 2;
			this.to = dividend;
		} else {
			throw new RuntimeException("dividend must be >= 2. dividend==" + dividend);
		}
	}

	public long getDividend() {
		return dividend;
	}

	public long getFrom() {
		return from;
	}

	public long getTo() {
		return to;
	}

	public void generatePrimeFactors() {
		
		long divisor = 2;
		while (dividend != 1 && divisor <= to) {
			
			if (dividend % divisor == 0) {
				factors.add(divisor);
				dividend /= divisor;
			} 
			else if (divisor == 2) { divisor++; } 
			else { divisor += 2; }
		}
	}
	
	public LinkedList<Long> getPrimeFactors() { return factors; }

	public static void main(String[] args) {
		
		PrimeFactorizer fac = new PrimeFactorizer(6);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 6\t:\t" + fac.getPrimeFactors());

		fac = new PrimeFactorizer(84);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 84\t:\t" + fac.getPrimeFactors());

		fac = new PrimeFactorizer(2489);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 2489\t:\t" + fac.getPrimeFactors());

		fac = new PrimeFactorizer(8633);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 8633\t:\t" + fac.getPrimeFactors());

		fac = new PrimeFactorizer(100056);
		fac.generatePrimeFactors();
		System.out.println("Prime factors of 100056\t:\t" + fac.getPrimeFactors());
	}
}
