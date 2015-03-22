package main;

import entities.Destination;
import entities.Taxi;
import models.PassengerGroupQueue;
import models.TaxiQueue;
import view.KioskMainView;


public class Launcher {

	public static void main(String[] args) {
		TaxiQueue.getInstance().setTaxiList(Taxi.read().values());
		PassengerGroupQueue.getInstance().setPassengerGroup(Destination.read().values(),10);
		
		KioskMainView view = new KioskMainView();
		Kiosk kiosk = new Kiosk();
		view.setVisible(true);
	}

}
