package models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class PassengerGroup {
	
	private boolean allocated = false;
	private String destination;
	private int passengers;
	
	public PassengerGroup(Collection<Destination> destinations) {
		ArrayList<Destination> array = new ArrayList<Destination>(destinations);
		int size = array.size();
		Random ran = new Random();
		this.passengers = ran.nextInt(5) + 1;
		this.destination = array.get(ran.nextInt(size)).getName();
	}
	
	public boolean isAllocated() {
		return allocated;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public int getPassengers() {
		return passengers;
	}
	
	public void setDestination(String d) {
		destination = d;
	}
	
	public void setPassengers(int p) {
		passengers = p;
	}

}
