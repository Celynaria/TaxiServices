package models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;

import entities.Taxi;

public class TaxiQueue extends Observable{
	
	private LinkedList<Taxi> taxiList = new LinkedList<Taxi>();
	private static final TaxiQueue INSTANCE = new TaxiQueue();
	
	private TaxiQueue() {}
	
	public static TaxiQueue getInstance() {
		return INSTANCE;
	}

	public LinkedList<Taxi> getTaxiList() {
		return taxiList;
	}
	/**
	 * Add taxi list to singleton class to ensure that all thread
	 * will work on the same list
	 * @param tList
	 */
	public void setTaxiList(Collection<Taxi> tList) {
		this.taxiList.addAll(tList);
	}
	
}
