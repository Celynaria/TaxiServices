package models;

import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

import entities.Taxi;

public class TaxiQueue extends Observable{
	//Vector is synchronised data structure so only one thread can update vector at the time
	private Vector<Taxi> taxiList = new Vector<Taxi>();
	private static final TaxiQueue INSTANCE = new TaxiQueue();
	
	private TaxiQueue() {}
	
	public static TaxiQueue getInstance() {
		return INSTANCE;
	}

	public Vector<Taxi> getTaxiList() {
		return taxiList;
	}
	/**
	 * Add taxi list to singleton class to ensure that all thread
	 * will work on the same list
	 * @param tList
	 */
	public void setTaxiList(Collection<Taxi> tList) {
		this.taxiList.addAll(tList);
		setChanged();
		notifyObservers(2);
	}
	
}
