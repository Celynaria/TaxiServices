package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import models.KioskWindowList;

@SuppressWarnings("serial")
public class KioskMainView extends JFrame{
	
	public KioskMainView (KioskWindowList viewList){
		setResizable(false);
		setTitle("Kiosk Taxi");
		//create 3 windows
		KioskWindowView window1 = new KioskWindowView("WINDOW 1");
		KioskWindowView window2 = new KioskWindowView("WINDOW 2");
		KioskWindowView window3 = new KioskWindowView("WINDOW 3");
		
		//create taxi view and set text to button and header
		KioskListView taxiQueue = new KioskListView();
		taxiQueue.setTitleLabel("Taxi Queue");
		taxiQueue.setButtonLabel("Add Taxi");
		taxiQueue.addTableColumnHeader("TaxiID");
		taxiQueue.addTableColumnHeader("Capacity");
		
		//create passenger view and set text to button
		KioskListView passengerQueue = new KioskListView();
		passengerQueue.setTitleLabel("Passenger Queue");
		passengerQueue.setButtonLabel("Add Passenger");
		passengerQueue.addTableColumnHeader("Destination");
		passengerQueue.addTableColumnHeader("Passengers");
		
		//create log view
		KioskLogView log = new KioskLogView();
		
		//add list of component to main controller
		viewList.getComponentList().put("window1", window1);
		viewList.getComponentList().put("window2", window2);
		viewList.getComponentList().put("window3", window3);
		viewList.getComponentList().put("taxiQueue", taxiQueue);
		viewList.getComponentList().put("passengerQueue", passengerQueue);
		viewList.getComponentList().put("log", log);
		
		//create north panel
		JPanel northPanel = new JPanel();
		northPanel.add(window1);
		northPanel.add(window2);
		northPanel.add(window3);
		northPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//create centre panel
		JPanel centerPanel = new JPanel();
		centerPanel.add(passengerQueue);
		centerPanel.add(taxiQueue);
		centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//create south panel
		JPanel southPanel = new JPanel();
		southPanel.add(log);
		southPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(3,3));
		contentPane.add(northPanel,BorderLayout.NORTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		contentPane.add(southPanel,BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}

}
