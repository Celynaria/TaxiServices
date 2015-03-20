package models;

import java.util.LinkedList;
import java.util.Queue;

public class PassengerGroupQueue {
	
	private Queue<PassengerGroup> cList = new LinkedList<PassengerGroup>();
	private static final PassengerGroupQueue INSTANCE = new PassengerGroupQueue();
	
	private PassengerGroupQueue() {}
	
	public static PassengerGroupQueue getInstance() {
		return INSTANCE;
	}
	
	public synchronized int getSize() {
		return cList.size();
	}
	
	public void addPassengerGroup(PassengerGroup pg) {
		while(true) {
			try {
				cList.add(pg);
				return;
			} catch(IllegalStateException e) {
				System.out.println("PassengerGroupQueue is full, retrying");
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
	}
	
	public PassengerGroup getPassengerGroup() {
		return cList.poll();
	}
	
	public boolean loadData(){
		return true;
	}

}
