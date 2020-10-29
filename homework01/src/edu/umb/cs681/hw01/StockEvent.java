package edu.umb.cs681.hw01;

public class StockEvent {
	private String ticker;
	private float quote;

	public StockEvent(String tickers, float quote) {
		this.ticker = tickers;
		this.quote = quote;
	}

	public String getTicker() {
		return ticker;
	}

	public float getQuote() {
		return quote;
	}
}
