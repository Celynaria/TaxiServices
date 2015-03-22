package models;

import java.util.Collection;
import java.util.Observable;
import java.util.Vector;

import entities.Destination;
import entities.PassengerGroup;
/**
 * Singleton Class of PassengerGroup
 * @author Wonchana
 *
 */
public class PassengerGroupQueue extends Observable{
	//Vector is synchronised data structure so only one thread can update vector at the time
	private Vector<PassengerGroup> cList = new Vector<PassengerGroup>();
	private static final PassengerGroupQueue INSTANCE = new PassengerGroupQueue();
	
	private PassengerGroupQueue() {}
	
	public static PassengerGroupQueue getInstance() {
		return INSTANCE;
	}
	
	public synchronized int getSize() {
		return cList.size();
	}
	
	/**
	 * generate random passenger group of specific size with destination list.
	 * @param destinations
	 * list of destination
	 * @param numberOfGroup
	 * number of groups that will be generated
	 */
	public void setPassengerGroup(Collection<Destination> destinations,int numberOfGroup){
		
		for(int i=0;i<numberOfGroup;i++){
			PassengerGroup pg = new PassengerGroup(destinations);
			cList.add(pg);
		}
		setChanged();
		notifyObservers(1);
		
	}
	
	public void addPassengerGroup(Collection<Destination> destinations) {
		
	}
	
	public Vector<PassengerGroup> getPassengerGroup() {
		return cList;
	}

}
