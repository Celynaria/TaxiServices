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
	private JLabel header = new JLabel();
	
	public KioskWindowView(String title) {
		
		this.header.setText(title);
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
							.addComponent(this.header)
							.addComponent(j2,GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addComponent(j3,GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
							.addComponent(j4,GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
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
							.addComponent(this.header)
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

	public JLabel getHeader() {
		return header;
	}

	public void setHeader(JLabel header) {
		this.header = header;
	}

}
