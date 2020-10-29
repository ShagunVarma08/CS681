package edu.umb.cs681.hw01;

public class StockQuoteObservable extends Observable {

	public void changeQuote(String tickers, float quote) {
		this.setChanged();
		this.notifyObservers(new StockEvent(tickers, quote));
	}

}
