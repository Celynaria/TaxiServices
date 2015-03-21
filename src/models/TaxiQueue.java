package models;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

import entities.Taxi;

public class TaxiQueue extends Observable{
	
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
	
}
