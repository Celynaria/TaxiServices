package models;

import java.util.HashMap;
import java.util.Observer;

public class KioskWindowList {
	private HashMap<String,Observer> componentList = new HashMap<String,Observer>();
	private static final KioskWindowList INSTANCE = new KioskWindowList();
	
	private KioskWindowList(){}
	
	public HashMap<String,Observer> getComponentList() {
		return componentList;
	}
	public void setComponentList(HashMap<String,Observer> componentList) {
		this.componentList = componentList;
	}
	public static KioskWindowList getInstance() {
		return INSTANCE;
	}
}
