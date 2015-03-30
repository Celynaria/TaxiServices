package models;

import java.util.HashMap;
import java.util.Observer;
import java.util.Random;

public class KioskWindowList {
	private HashMap<String,Observer> componentList = new HashMap<String,Observer>();
	private static final KioskWindowList INSTANCE = new KioskWindowList();
	
	private KioskWindowList(){}
	
	public HashMap<String,Observer> getComponentList() {
		return componentList;
	}
	public void setComponentList(HashMap<String,Observer> componentList) {
		this.componentList = componentList;
	}
	public static KioskWindowList getInstance() {
		return INSTANCE;
	}
	
	/**
	 * 
	 * @return
	 */
	public synchronized Window getNextJob() {
		
		PassengerGroupQueue pgq = PassengerGroupQueue.getInstance();
		TaxiQueue txq = TaxiQueue.getInstance();
		Window win = null;
		Taxi tx = null;
		PassengerGroup pg = null;
		if(pgq.hasNext()){
			if(txq.hasNext(pgq.getFirstPassengerGroupSize())){
				pg = pgq.getNextGroup();
				tx = txq.getAvailableTaxi(pg.getPassengers());
				Random ran = new Random();
				int x = ran.nextInt(6) + 4;//random processing time for each job
				if(tx!=null&&pg!=null){
					win = new Window(x, pg.getDestination(), pg.getPassengers(), tx.getRegistrationID(), tx.getMaximumPassenger());
				}
			}
		}
		return win;
	}
}
