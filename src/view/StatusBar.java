package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class StatusBar extends JToolBar {
	private JLabel label;

	public StatusBar() {
		this.label = new JLabel("New game started!", JLabel.LEFT);
		label.setForeground(Color.red);
		add(label);
	}
	
	public void setStatus(String status) {
		label.setText(status);		
	}

}