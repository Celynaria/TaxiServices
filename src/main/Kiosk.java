package main;

import java.awt.Component;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import entities.Destination;
import entities.Taxi;
import models.PassengerGroupQueue;
import models.TaxiQueue;

public class Kiosk implements Observer {
	
	private PassengerGroupQueue passengerGroupQueue = PassengerGroupQueue.getInstance();
	private TaxiQueue taxiQueue = TaxiQueue.getInstance();
	private HashMap<String,Observer> componentList = new HashMap<String,Observer>();
	private boolean finished = false;

	public boolean isFinished() {
		return finished;
	}

	public void init(){
		//add observer
		passengerGroupQueue.addObserver(componentList.get("passengerQueue"));
		taxiQueue.addObserver(componentList.get("taxiQueue"));
		//init data
		passengerGroupQueue.setPassengerGroup(Destination.read().values(),10);
		taxiQueue.setTaxiList(Taxi.read().values());
	}
	public void start(){

//		KioskWindow window1 = new KioskWindow();
//		new Thread(window1).start();
//		KioskWindow window2 = new KioskWindow();
//		new Thread(window2).start();
//		KioskWindow window3 = new KioskWindow();
//		new Thread(window3).start();
	}
	
	public HashMap<String, Observer> getComponentList() {
		return componentList;
	}

	public void setComponentList(HashMap<String, Observer> componentList) {
		this.componentList = componentList;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
//		this.next((int)arg1);
	}

}
