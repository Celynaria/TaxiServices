package models;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Observable;

import entities.Destination;
import entities.PassengerGroup;

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
	public void setPassengerGroup(Collection<Destination> destinations,int numberOfGroup){
		
		for(int i=0;i<numberOfGroup;i++){
			PassengerGroup pg = new PassengerGroup(destinations);
			cList.add(pg);
		}
	}
	
	public void addPassengerGroup(Collection<Destination> destinations) {
		
	}
	
	public PassengerGroup getPassengerGroup() {
		return cList.poll();
	}

}
