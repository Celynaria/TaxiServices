package models;

public class PassengerGroup {
	
	private boolean allocated = false;
	private String destination;
	private int passengers;
	
	public PassengerGroup(String destination, int passengers) {
		this.destination = destination;
		this.passengers = passengers;
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
