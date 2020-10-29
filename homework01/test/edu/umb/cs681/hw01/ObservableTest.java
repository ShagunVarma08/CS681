package edu.umb.cs681.hw01;

import org.junit.jupiter.api.Test;

public class ObservableTest {
	
	StockQuoteObservable stock = new StockQuoteObservable();
	DJIAQuoteObservable djia = new DJIAQuoteObservable();
		
	@Test
	public void StockTest() {
		
		System.out.println("Number of Stock Observers : " + stock.countObserver());
		stock.changeQuote("Alpha", 10);
		stock.addObserver((Observable obs, Object obj) -> {
			System.out.println("Stock Observer 1 added.");
			stock.setChanged();
		});		
		
		
		stock.addObserver((Observable obs, Object obj) -> {
			System.out.println("Stock Observer 2 added.");
		});	
		stock.changeQuote("Beta", 20);
		
		System.out.println("Number of Stock Observers : " + stock.countObserver());
	}
	
	@Test
	public void DJIATest() {		
		
		
		System.out.println("Number of DJIA Observers : " + djia.countObserver());
		djia.changeQuote(30);
		djia.addObserver((Observable obs, Object obj) -> {
			System.out.println("DJIA Observer 1 added.");
		});
		
		djia.addObserver((Observable obs, Object obj) -> {
			System.out.println("DJIA Observer 2 added.");
		});		
		djia.changeQuote(40);		
		System.out.println("Number of DJIA Observers : " + djia.countObserver());
	}
}