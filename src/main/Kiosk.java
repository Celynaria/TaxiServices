package main;

import java.util.Observable;
import java.util.Observer;

import models.KioskWindow;
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
		
		KioskWindow window1 = new KioskWindow();
		new Thread(window1).start();
		KioskWindow window2 = new KioskWindow();
		new Thread(window2).start();
		KioskWindow window3 = new KioskWindow();
		new Thread(window3).start();
	}

}
