package models;

import java.util.Observable;

import entities.PassengerGroup;

public class KioskWindow extends Observable implements Runnable {
	
	private PassengerGroupQueue pgq = PassengerGroupQueue.getInstance();
	private TaxiQueue tq = TaxiQueue.getInstance();
	
	public KioskWindow() {}

	@Override
	public void run() {
		//Taxi t = tq.getTaxi();
	}

}
