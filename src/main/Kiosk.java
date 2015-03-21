package main;

import java.util.Observable;
import java.util.Observer;

import models.PassengerGroupQueue;
import models.TaxiQueue;

public class Kiosk implements Observer {
	
	private PassengerGroupQueue passengerGroupQueue = PassengerGroupQueue.getInstance();
	private TaxiQueue taxiQueue = TaxiQueue.getInstance();
	private boolean finished = false;
	
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
//		this.next((int)arg1);
	}
	
	public void start(){
//		KioskWindow window1 = new KioskWindow();
//		KioskWindow window2 = new KioskWindow();
//		KioskWindow window3 = new KioskWindow();
	}

}
