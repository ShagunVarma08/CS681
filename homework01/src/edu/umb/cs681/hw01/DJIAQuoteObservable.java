package edu.umb.cs681.hw01;

public class DJIAQuoteObservable extends Observable {

	public void changeQuote(float quote) {
		setChanged();
		notifyObservers(new DJIAEvent(quote));
	}

}