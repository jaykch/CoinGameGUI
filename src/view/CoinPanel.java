package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CoinPanel extends JPanel{
	
	public CoinPanel() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLUE);
		add(new StatusBar(), BorderLayout.SOUTH);
		
		//Create a panel for each player
	
	}
}