package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.KioskListView;
import view.KioskMainView;
import view.KioskWindowView;
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
public class Kiosk implements ActionListener{
	
	private PassengerGroupQueue passengerGroupQueue = PassengerGroupQueue.getInstance();
	private TaxiQueue taxiQueue = TaxiQueue.getInstance();
	private KioskWindowList winList = KioskWindowList.getInstance();

	public void init(){
		//init view
		KioskMainView views = new KioskMainView(winList);
		((KioskWindowView)winList.getComponentList().get("window1")).addActionListener(this,"winp1");
		((KioskWindowView)winList.getComponentList().get("window2")).addActionListener(this,"winp2");
		((KioskWindowView)winList.getComponentList().get("window3")).addActionListener(this,"winp3");
		((KioskListView)winList.getComponentList().get("passengerQueue")).addActionListener(this);
		((KioskListView)winList.getComponentList().get("taxiQueue")).setButtonEnable(false);
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
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		if(arg.getActionCommand().equals("winp1")){
			
		}else if(arg.getActionCommand().equals("winp2")){
			
		}else if(arg.getActionCommand().equals("winp3")){
			
		}else if(arg.getActionCommand().equals("Add Passenger")){
			
		}
		
	}

}
