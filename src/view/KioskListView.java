package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;

/**
 * This view control layout of the list remaining passenger groups and taxis.
 * @author ts5
 *
 */
@SuppressWarnings("serial")
public class KioskListView extends JPanel implements Observer{	
		
	private	JLabel title = new JLabel();
	private	JLabel number = new JLabel();
	private	JButton process = new JButton();
	private JTable table = new JTable(0,1);
	
	/**
	 * For construct the layout of this view.
	 */
	public KioskListView(){
		
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
	    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		table.setTableHeader(null);
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
			.addGroup(
					layout.createParallelGroup()
					.addGroup(
							layout.createSequentialGroup()
							.addComponent(title)
							.addComponent(number)
					)
					.addComponent(scrollPane,400,400,400)
					.addComponent(process, GroupLayout.Alignment.CENTER)
			)
		);
		layout.setVerticalGroup(
			layout.createSequentialGroup()
			.addGroup(
					layout.createParallelGroup()
					.addComponent(title)
					.addComponent(number)
			)
			.addComponent(scrollPane,125,125,125)
			.addComponent(process)	
		);
	}
	
	/**
	 * Set header's text of the component
	 * @param title
	 */
	public void setTitleLabel(String title){
		this.title.setText(title);
	}
	
	/**
	 * Set the counter number of objects in the list
	 * @param number
	 */
	public void setNumberLabel(int number){
		this.number.setText("("+number+")");
	}
	
	/**
	 * Set the name of button
	 * @param name
	 */
	public void setButtonLabel(String name){
		this.process.setText(name);
	}
	
	public void addRow(){
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
	}

}
