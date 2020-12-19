package edu.umb.cs681.hw18;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Observable {
		
	private AtomicBoolean changed = new AtomicBoolean(false);
	private ConcurrentLinkedQueue<Observer> observers;
		
	Observable() {
        observers = new ConcurrentLinkedQueue<>();
    }
	
	public void addObserver(Observer o) {
		this.observers.offer(o);
	}
	
	protected void setChanged() {
		changed.set(true);
	}

	protected boolean hasChanged() {
		return changed.get();
	}
	
	protected void clearChanged() {
		changed.set(false);
	}

	public void notifyObservers(Object arg) {
		if (hasChanged()) {
            observers.forEach(observer -> observer.update(this, arg));
            clearChanged();
        }
	}
	
	public void deleteObserver(Observer o) {
		this.observers.remove(o);
	}

	protected int countObserver() {
		return observers.size();
	}
}
