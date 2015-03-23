package entities;

public class Window {
	private String winNum;
	private int processingTime;
	private String destination;
	private int passengers;
	private String taxiID;
	private int taxiCap;
	
	public Window(int processingTime, String destination, int passengers,
			String taxiID, int taxiCap) {
		super();
		this.processingTime = processingTime;
		this.destination = destination;
		this.passengers = passengers;
		this.taxiID = taxiID;
		this.taxiCap = taxiCap;
	}
	public int getProcessingTime() {
		return processingTime;
	}
	public void setProcessingTime(int processingTime) {
		this.processingTime = processingTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public String getTaxiID() {
		return taxiID;
	}
	public void setTaxiID(String taxiID) {
		this.taxiID = taxiID;
	}
	public String getWinNum() {
		return winNum;
	}
	public void setWinNum(String winNum) {
		this.winNum = winNum;
	}
	public int getTaxiCap() {
		return taxiCap;
	}
	public void setTaxiCap(int taxiCap) {
		this.taxiCap = taxiCap;
	}
	public String toString(){
		return winNum+"Processing:[Destination: "+destination+", Number of passengers: "+passengers+", Taxi: "+taxiID +", Taxi's capacity: "+taxiCap+"]";
	}
	
	
}
