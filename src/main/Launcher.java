package main;

import view.KioskMainView;


public class Launcher {

	public static void main(String[] args) {
		//Kiosk model = new Kiosk();
		//MVCAuctionView   view  = new MVCAuctionView  (model);
		//MVCAuctionController controller = new MVCAuctionController(model, view);   
		//view.setVisible(true);
		KioskMainView view = new KioskMainView();
		view.setVisible(true);
	}

}
