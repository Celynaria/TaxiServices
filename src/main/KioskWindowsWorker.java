package main;

import java.util.Observable;

import models.KioskWindowList;
import models.PassengerGroupQueue;
import models.TaxiQueue;

import view.KioskLogView;

import entities.Window;

public class KioskWindowsWorker extends Observable implements Runnable{
	
	private KioskWindowList winList = KioskWindowList.getInstance();
	private TaxiQueue txq = TaxiQueue.getInstance();
	private PassengerGroupQueue pgq = PassengerGroupQueue.getInstance();
	private String windowNum;
	private Boolean working = true;
	
	public KioskWindowsWorker(){}
	
	public KioskWindowsWorker(String windowNum) {
		this.windowNum = windowNum;
		addObserver(winList.getComponentList().get(windowNum));
	}

	@Override
	public void run() {
		
		Window win = null;
		try {
			do{
				if(!working){
					Thread.currentThread().wait();
				}
				appendLog(windowNum+" Requesting next task");
				win = getNextJob();
				if(win!=null){
					win.setWinNum(windowNum);
					setChanged();
					notifyObservers(win);
				}else{
					appendLog(windowNum+" cannot find next task");
				}
				appendLog(win.toString());
				Thread.sleep(win.getProcessingTime()*1000);
				appendLog(windowNum+" Processing Complete");
			}while(win!=null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Window getNextJob() {
		return winList.getNextJob();
	}
	private void appendLog(String text) {
		KioskLogView log = (KioskLogView) winList.getComponentList().get("log");
		log.appendLog(text);
	}
	public void pauseThread(Boolean boo){
		working = boo;
	}

}
