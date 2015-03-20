package main;

import java.util.Observable;
import java.util.Observer;

import models.PassengerGroupQueue;
import models.TaxiQueue;
import models.WindowList;

public class Kiosk implements Observer {
	
	private static TaxiQueue tq;
	private static PassengerGroupQueue pq;
	private WindowList winThreads;
	private boolean finished = false;

	public WindowList getWindows() {
		return winThreads;
	}
	
	public boolean isFinished() {
		return finished;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}
