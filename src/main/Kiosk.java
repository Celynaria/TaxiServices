package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import utilities.AseLog;
import view.KioskListView;
import view.KioskLogView;
import view.KioskMainView;
import view.KioskWindowView;
import models.Destination;
import models.KioskWindowList;
import models.PassengerGroupQueue;
import models.Taxi;
import models.TaxiQueue;

/**
 * This is main controller class
 * @author 
 *
 */
public class Kiosk implements ActionListener{
	
	private PassengerGroupQueue passengerGroupQueue = PassengerGroupQueue.getInstance();
	private TaxiQueue taxiQueue = TaxiQueue.getInstance();
	private KioskWindowList winList = KioskWindowList.getInstance();
	private ArrayList<KioskWindowsWorker> workerGroup = new ArrayList<KioskWindowsWorker>();
	private Collection<Destination> destinationList;
	private AseLog aseLog = AseLog.getInstance();

	/**
	 * Initial all GUI and load data from files + random generated some data
	 */
	public void init(){
		//init view
		new KioskMainView(winList);
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
		try {
			win1.join();
			win2.join();
			win3.join();
			((KioskLogView)winList.getComponentList().get("log")).appendLog("All threads are finished, Application is closed");
			aseLog.write("All threads are finished, Application is closed");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	/**
	 * Action perform to control threads and GUI
	 */
	public void actionPerformed(ActionEvent arg) {
		if(arg.getActionCommand().equals("winp1")){
			((KioskWindowView)winList.getComponentList().get("window1")).getPause().setEnabled(false);
			if(workerGroup.get(0).threadStatus()){
				workerGroup.get(0).pauseThread(true);
			}else{
				workerGroup.get(0).pauseThread(false);
				synchronized (workerGroup.get(0)) {
					workerGroup.get(0).notify();
				}
			}
		}else if(arg.getActionCommand().equals("winp2")){
			((KioskWindowView)winList.getComponentList().get("window2")).getPause().setEnabled(false);
			if(workerGroup.get(1).threadStatus()){
				workerGroup.get(1).pauseThread(true);
			}else{
				workerGroup.get(1).pauseThread(false);
				synchronized (workerGroup.get(1)) {
					workerGroup.get(1).notify();
				}
			}
		}else if(arg.getActionCommand().equals("winp3")){
			((KioskWindowView)winList.getComponentList().get("window3")).getPause().setEnabled(false);
			if(workerGroup.get(2).threadStatus()){
				workerGroup.get(2).pauseThread(true);
			}else{
				workerGroup.get(2).pauseThread(false);
				synchronized (workerGroup.get(2)) {
					workerGroup.get(2).notify();
				}
			}
		}else if(arg.getActionCommand().equals("Add Passenger")){
			passengerGroupQueue.setPassengerGroup(destinationList,1);
		}
	}

}
