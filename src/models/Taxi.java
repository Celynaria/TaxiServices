package models;

import java.util.Random;


public class Taxi {

	private String taxiReg;
	private int capacity;

	public Taxi(String reg) {
		taxiReg = reg;
		Random ran = new Random();
		int x = ran.nextInt(6) + 3;
		this.capacity = x;
	}

	public void setReg(String reg){
		taxiReg = reg;
	}
	
	public String getReg() {
		return taxiReg;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
