package edu.umb.cs681.hw01;

import java.util.LinkedList;

public class Observable {
	
	protected LinkedList<Observer> observers = new LinkedList<Observer>();
	protected boolean observer_changed = false;

	public void addObserver(Observer o) {
		if (!observers.contains(o)) {
			observers.add(o);
		}
	}
	
	protected void setChanged() {
		observer_changed = true;
	}

	protected boolean hasChanged() {
		return observer_changed;
	}
	
	protected void clearChanged() {
		observer_changed = false;
	}

	public void notifyObservers(Object arg) {
		if (hasChanged()) {
			observers.forEach((Observer observers) -> observers.update(this, arg));
			clearChanged();
		}
	}
	
	public void deleteObserver(Observer o) {
		if (observers.contains(o)) {
			observers.remove(o);
		}
	}

	protected int countObserver() {
		return observers.size();
	}
}
