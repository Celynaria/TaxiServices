package models;

import java.util.ArrayList;

public class WindowList {
	private ArrayList<KioskWindow> windows;
	
	public WindowList() {
		this.windows = new ArrayList<KioskWindow>();
	}
	
	public void add(KioskWindow kw) {
		windows.add(kw);
	}
	
//	public KioskWindow find(int id) {
//		for (KioskWindow kw : windows) {
//			if (kw.getId() == id){
//				return kw;
//			}
//		}
//		return null;
//	}
	
	public KioskWindow get(int i) {
		return windows.get(i);
	}
	
	
	public int getSize() {
		return windows.size();
	}
}
