package main;

import java.util.Observable;
import java.util.Random;

import models.KioskWindowList;
import models.PassengerGroupQueue;
import models.TaxiQueue;
import view.KioskLogView;
import entities.PassengerGroup;
import entities.Taxi;
import entities.Window;

public class KioskWindowsWorker extends Observable implements Runnable{
	private KioskWindowList winList = KioskWindowList.getInstance();
	private TaxiQueue txq = TaxiQueue.getInstance();
	private PassengerGroupQueue pgq = PassengerGroupQueue.getInstance();
	private static final KioskWindowsWorker INSTANCE = new KioskWindowsWorker();
	private String windowNum;
	
	public KioskWindowsWorker(){}
	public static KioskWindowsWorker getInstance() {
		return INSTANCE;
	}
	
	public KioskWindowsWorker(String windowNum) {
		this.windowNum = windowNum;
		addObserver(winList.getComponentList().get(windowNum));
	}

	@Override
	public void run() {
		
		Window win = null;
		do{
			appendLog(windowNum+" Requesting next task");
			win = getNextJob();
			if(win!=null){
				win.setWinNum(windowNum);
				setChanged();
				notifyObservers(win);
			}else{
				appendLog(windowNum+" cannot find next task");
			}
			try {
				appendLog(win.toString());
				Thread.sleep(win.getProcessingTime()*1000);
				appendLog(windowNum+" Processing Complete");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(win!=null);
		
	}
	
	private synchronized Window getNextJob() {
		PassengerGroup pg = pgq.getNextGroup();
		Window win = null;
		Taxi tx = txq.getAvailableTaxi(pg.getPassengers());
		Random ran = new Random();
		int x = ran.nextInt(2) + 4;
		if(tx!=null&&pg!=null){
			win = new Window(x, pg.getDestination(), pg.getPassengers(), tx.getRegistrationID(), tx.getMaximumPassenger());
		}
		return win;
	}
	private synchronized void appendLog(String text) {
		KioskLogView log = (KioskLogView) winList.getComponentList().get("log");
		log.appendLog(text);
	}

}
