package main;
import view.KioskMainView;


public class Launcher {

	public static void main(String[] args) {
		Kiosk kiosk = new Kiosk();
		KioskMainView view = new KioskMainView(kiosk);
		kiosk.init();
		kiosk.start();
		
		view.setVisible(true);
	}

}
