package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

@SuppressWarnings("serial")
public class KioskLogView extends JPanel implements Observer{
	
	private JTextArea tx = new JTextArea(10,95);
	private JLabel title = new JLabel("Log Area");
	
	public KioskLogView(){
		
		JScrollPane scrollPane = new JScrollPane(this.tx,
	            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.tx.setEditable(false);
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup()
						.addComponent(this.title)
						.addComponent(scrollPane)
						)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(this.title)
				.addComponent(scrollPane)
		);
		
	}

	public JTextArea getTx() {
		return tx;
	}

	public void setTx(JTextArea tx) {
		this.tx = tx;
	}

	public JLabel getTitle() {
		return title;
	}

	public void setTitle(JLabel title) {
		this.title = title;
	}
	
	public synchronized void appendLog(String text){
		tx.append(text);
		tx.append("\n");
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
