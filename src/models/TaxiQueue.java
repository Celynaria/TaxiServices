package models;

import java.util.LinkedList;
import java.util.Queue;

public class TaxiQueue {
	
	private Queue<Taxi> tList = new LinkedList<Taxi>();
	private static final TaxiQueue INSTANCE = new TaxiQueue();
	
	private TaxiQueue() {}
	
	public static TaxiQueue getInstance() {
		return INSTANCE;
	}
	
	public void addTaxi(Taxi t) {
		while(true) {
			try {
				tList.add(t);
				return;
			} catch(IllegalStateException e) {
				System.out.println("TaxiQueue is full, retrying");
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {}
		}
	}
	
	public Taxi getTaxi() {
		return tList.poll();
	}
	
	public boolean loadData(){
		for(int i=0;i<10;i++ ){
			this.addTaxi(new Taxi());
		}
		return true;
	}

}
