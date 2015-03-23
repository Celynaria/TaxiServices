package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

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
	private ArrayList<KioskWindowsWorker> workerGroup = new ArrayList<KioskWindowsWorker>();
	private Collection<Destination> destinationList;

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
		destinationList = Destination.read().values();
		passengerGroupQueue.setPassengerGroup(destinationList,10);
		taxiQueue.setTaxiList(Taxi.read().values());
	}
	public void start(){ 
		KioskWindowsWorker worker1 = new KioskWindowsWorker("window1");
		KioskWindowsWorker worker2 = new KioskWindowsWorker("window2");
		KioskWindowsWorker worker3 = new KioskWindowsWorker("window3");
		workerGroup.add(worker1);workerGroup.add(worker2);workerGroup.add(worker3);
		
		Thread win1 = new Thread(worker1);
		Thread win2 = new Thread(worker2);
		Thread win3 = new Thread(worker3);
		win1.start();
		win2.start();
		win3.start();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg) {
		
		if(arg.getActionCommand().equals("winp1")){
			workerGroup.get(0).pauseThread(true);
		}else if(arg.getActionCommand().equals("winp2")){
			workerGroup.get(1).pauseThread(true);
		}else if(arg.getActionCommand().equals("winp3")){
			workerGroup.get(2).pauseThread(true);
		}else if(arg.getActionCommand().equals("Add Passenger")){
			passengerGroupQueue.setPassengerGroup(destinationList,1);
		}
		
	}

}
