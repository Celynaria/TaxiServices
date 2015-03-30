package main;

import java.util.Observable;

import models.KioskWindowList;
import models.Window;
import utilities.AseLog;
import view.KioskLogView;

public class KioskWindowsWorker extends Observable implements Runnable{
	
	private KioskWindowList winList = KioskWindowList.getInstance();
	private String windowNum;
	private AseLog aseLog = AseLog.getInstance();
	private boolean working = true;
	private boolean isFinished = false;
	
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
					appendLog(windowNum+" is on breaking time");
					aseLog.write(windowNum+" is on breaking time");
					setChanged();
					win.setProcessingTime(-1);//set negative time for as breaking status
					notifyObservers(win);
					synchronized (this) {
						this.wait();	
					}
				}
				appendLog(windowNum+" Requesting next task");
				aseLog.write(windowNum+" Requesting next task");
				win = getNextJob();
				if(win!=null){
					win.setWinNum(windowNum);
					setChanged();
					notifyObservers(win);
					appendLog(win.toString());//write to GUI
					aseLog.write(win.toString());//write to log file
					Thread.sleep(win.getProcessingTime()*1000);//simulate processing time using thread sleep
					appendLog(windowNum+" Processing Complete");//write to GUI
					aseLog.write(windowNum+" Processing Complete");//write to log file
				}else{
					win = new Window(-2, "", 0, "", 0);// only -2 matter, it is a sign to end programme
					setChanged();
					notifyObservers(win);
					isFinished = true;
					appendLog(windowNum+" cannot find next task");
					aseLog.write(windowNum+" cannot find next task");
					appendLog(windowNum+" is now closed");
					aseLog.write(windowNum+" is now closed");
					win = null;// set to null to end the loop
				}
			}while(win!=null);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Window getNextJob() {
		return winList.getNextJob();
	}
	/**
	 * log to GUI
	 * @param text
	 */
	private void appendLog(String text) {
		KioskLogView log = (KioskLogView) winList.getComponentList().get("log");
		log.appendLog(text);
	}
	public void pauseThread(Boolean boo){
		working = !boo;
	}
	public boolean threadStatus(){
		return working;
	}
	public boolean isFinished(){
		return isFinished;
	}

}
