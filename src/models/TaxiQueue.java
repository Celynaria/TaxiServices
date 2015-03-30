package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

public class TaxiQueue extends Observable{
	private ArrayList<Taxi> taxiList = new ArrayList<Taxi>();
	private static final TaxiQueue INSTANCE = new TaxiQueue();
	
	private TaxiQueue() {}
	
	public static TaxiQueue getInstance() {
		return INSTANCE;
	}

	public ArrayList<Taxi> getTaxiList() {
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

	/**
	 * Get taxi that big enough for specified number of passengers
	 * @param passengers
	 * @return null if no taxi matched the condition
	 */
	public synchronized Taxi getAvailableTaxi(int passengers) {
		Iterator<Taxi> iterator = taxiList.iterator();
		Boolean flag = true;
		Taxi taxi = null;
		while(iterator.hasNext()&&flag){
			Taxi tx = iterator.next();
			if(tx.getMaximumPassenger()>= passengers){
				taxi = tx;
				iterator.remove();
				flag = false;
				setChanged();
				notifyObservers(2);
			}
		}
		return taxi;
	}
	
	public synchronized boolean hasNext(int passengers){
		Iterator<Taxi> iterator = taxiList.iterator();
		Boolean flag = true;
		while(iterator.hasNext()&&flag){
			Taxi tx = iterator.next();
			if(tx.getMaximumPassenger()>= passengers){
				flag = false;
			}
		}
		return !flag;
	}
	
	public synchronized boolean hasNext(){
		return !taxiList.isEmpty();
	}
	
}
