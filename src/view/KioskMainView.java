package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KioskMainView extends JFrame{
	
	public KioskMainView (){
		
		setTitle("Kiosk Taxi");
		KioskWindowView window1 = new KioskWindowView();
		KioskWindowView window2 = new KioskWindowView();
		KioskWindowView window3 = new KioskWindowView();
		KioskListView taxiQueue = new KioskListView();
		taxiQueue.setTitleLabel("Taxi Queue");
		taxiQueue.setButtonLabel("Add Taxi");
		KioskLogView log = new KioskLogView();
		KioskListView passengerQueue = new KioskListView();
		passengerQueue.setButtonLabel("Add Passenger");
		
		JPanel northPanel = new JPanel();
		northPanel.add(window1);
		northPanel.add(window2);
		northPanel.add(window3);
		JPanel centerPanel = new JPanel();
		centerPanel.add(passengerQueue);
		centerPanel.add(taxiQueue);
		Container contentPane = getContentPane();
		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPanel,BorderLayout.CENTER);
		contentPane.add(log, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		
	}

}
