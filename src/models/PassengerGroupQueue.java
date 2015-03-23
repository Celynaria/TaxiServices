package models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;

import entities.Destination;
import entities.PassengerGroup;
/**
 * Singleton Class of PassengerGroup
 * @author Wonchana
 *
 */
public class PassengerGroupQueue extends Observable{
	private LinkedList<PassengerGroup> cList = new LinkedList<PassengerGroup>();
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
	public synchronized void setPassengerGroup(Collection<Destination> destinations,int numberOfGroup){
		
		for(int i=0;i<numberOfGroup;i++){
			PassengerGroup pg = new PassengerGroup(destinations);
			cList.add(pg);
		}
		setChanged();
		notifyObservers(1);
		
	}
	
	public synchronized LinkedList<PassengerGroup> getPassengerGroup() {
		return cList;
	}
	
	public synchronized boolean hasNext(){
		return !cList.isEmpty();
	}
	
	public synchronized PassengerGroup getNextGroup(){
		PassengerGroup pg = cList.poll();
		setChanged();
		notifyObservers(1);
		return pg;
	}

}
