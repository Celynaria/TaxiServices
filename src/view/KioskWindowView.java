package view;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import entities.Window;

@SuppressWarnings("serial")
public class KioskWindowView extends JPanel implements Observer{
	
	private JLabel windowStatus = new JLabel();
	private JLabel destination = new JLabel();
	private JLabel passengers = new JLabel();
	private JLabel taxi = new JLabel();
	private JLabel header = new JLabel();
	private JButton pause = new JButton("PAUSE");
	
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
							.addComponent(j2)
							.addComponent(j3)
							.addComponent(j4)
							.addComponent(pause)
						)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.windowStatus,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addComponent(this.destination,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addComponent(this.passengers,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
							.addComponent(this.taxi,GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup()
							.addComponent(this.header)
							.addComponent(this.windowStatus)
						)
				.addGroup(
						layout.createParallelGroup()
						.addComponent(j2)
						.addComponent(this.destination)
						)
				.addGroup(
						layout.createParallelGroup()
						.addComponent(j3)
						.addComponent(this.passengers)
						)
				.addGroup(
						layout.createParallelGroup()
						.addComponent(j4)
						.addComponent(this.taxi)
						)
				.addGroup(
						layout.createParallelGroup()
						.addComponent(pause)
				)
		);

	}

	@Override
	public void update(Observable o, Object arg) {
		Window win = (Window)arg;
		windowStatus.setText(Integer.toString(win.getProcessingTime()));
		destination.setText(win.getDestination());
		passengers.setText(Integer.toString(win.getPassengers()));
		taxi.setText(win.getTaxiID());
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

	public JButton getPause() {
		return pause;
	}

	public void setPause(JButton pause) {
		this.pause = pause;
	}

}
