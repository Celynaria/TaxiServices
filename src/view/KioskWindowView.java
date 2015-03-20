package view;

import javax.swing.GroupLayout;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KioskWindowView extends JPanel {

	public KioskWindowView() {
		JPanel p = new JPanel();
		GroupLayout layout = new GroupLayout(p);
		p.setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(layout.createSequentialGroup()
				.addComponent(ta)
				.addGroup(
						layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(l1).addComponent(lkey)
										.addComponent(l2).addComponent(l3)
										.addComponent(l4).addComponent(lsig)
										.addComponent(lpkey).addComponent(l5))
				.addGroup(
						layout.createParallelGroup(
										GroupLayout.Alignment.LEADING)
										.addComponent(open)
										.addComponent(selectkey)
										.addComponent(users).addComponent(pb)
										.addComponent(sign)
										.addComponent(openSignature)
										.addComponent(selectpkey)
										.addComponent(valify)));

	}

}
