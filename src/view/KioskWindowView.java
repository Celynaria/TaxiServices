package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class KioskWindowView extends JPanel implements Observer{
	
	private JLabel windowStatus = new JLabel();
	private JLabel destination = new JLabel();
	private JLabel passengers = new JLabel();
	private JLabel taxi = new JLabel();
	
	public KioskWindowView() {
		JLabel j1 = new JLabel("WINDOW");
		JLabel j2 = new JLabel("Destination   :");
		JLabel j3 = new JLabel("Passengers :");
		JLabel j4 = new JLabel("Taxi                :");
		
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(j1)
							.addComponent(j2)
							.addComponent(j3)
							.addComponent(j4)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.windowStatus)
							.addComponent(this.destination)
							.addComponent(this.passengers)
							.addComponent(this.taxi)
						)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(j1)
							.addComponent(this.windowStatus)
						)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(j2)
						.addComponent(this.destination)
						)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(j3)
						.addComponent(this.passengers)
						)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(j4)
						.addComponent(this.taxi)
						)
		);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}
	
	public JLabel getWindowStatus() {
		return windowStatus;
	}

	public void setWindowStatus(JLabel windowStatus) {
		this.windowStatus = windowStatus;
	}

	public JLabel getDestination() {
		return destination;
	}

	public void setDestination(JLabel destination) {
		this.destination = destination;
	}

	public JLabel getPassengers() {
		return passengers;
	}

	public void setPassengers(JLabel passengers) {
		this.passengers = passengers;
	}

	public JLabel getTaxi() {
		return taxi;
	}

	public void setTaxi(JLabel taxi) {
		this.taxi = taxi;
	}

}
