package main;

import view.KioskMainView;
import entities.Destination;
import entities.Taxi;
import models.KioskWindowList;
import models.PassengerGroupQueue;
import models.TaxiQueue;

/**
 * This is main controller class
 * @author Wonchana
 *
 */
public class Kiosk {
	
	private PassengerGroupQueue passengerGroupQueue = PassengerGroupQueue.getInstance();
	private TaxiQueue taxiQueue = TaxiQueue.getInstance();
	private KioskWindowList winList = KioskWindowList.getInstance();

	public void init(){
		//init view
		KioskMainView views = new KioskMainView(winList);
		views.setVisible(true);
		//add observer
		passengerGroupQueue.addObserver(winList.getComponentList().get("passengerQueue"));
		taxiQueue.addObserver(winList.getComponentList().get("taxiQueue"));
		//init data
		passengerGroupQueue.setPassengerGroup(Destination.read().values(),10);
		taxiQueue.setTaxiList(Taxi.read().values());
	}
	public void start(){ 
		Thread win1 = new Thread(new KioskWindowsWorker("window1"));
		Thread win2 = new Thread(new KioskWindowsWorker("window2"));
		Thread win3 = new Thread(new KioskWindowsWorker("window3"));
		
		win1.start();
		win2.start();
		win3.start();
		
	}

}
