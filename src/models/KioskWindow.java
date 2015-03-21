package models;

import java.util.Observable;

import main.Kiosk;

public class KioskWindow extends Observable implements Runnable {
	
	private PassengerGroupQueue pgq;
	private TaxiQueue tq;
	private Kiosk kiosk;
	
	public KioskWindow(Kiosk k) {
		pgq = PassengerGroupQueue.getInstance();
		tq = TaxiQueue.getInstance();
		kiosk = k;
	}

	@Override
	public void run() {
		while(!kiosk.isFinished()) {
			PassengerGroup pg = pgq.getPassengerGroup();
			//Taxi t = tq.getTaxi();
		}
	}

}
