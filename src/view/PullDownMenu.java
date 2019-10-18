package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controller.AddBetActionListener;
import controller.ExitActionListener;
import controller.NewPlayerActionListener;
import controller.RemoveBetActionListener;
import controller.RemovePlayerActionListener;
import controller.ShowSpinnerActionListener;

@SuppressWarnings("serial")
public class PullDownMenu extends JMenuBar {
	
	private JMenuItem showSpinner = new JMenuItem("Show Spinner");
	private JMenuItem addPlayer = new JMenuItem("Add Player");
	private JMenuItem removePlayer = new JMenuItem("Remove Player");
	private JMenuItem addBet = new JMenuItem("Add Bet");
	private JMenuItem removeBet = new JMenuItem("Remove Bet");
	private JMenuItem exit = new JMenuItem("Exit");

	
	public PullDownMenu(GameFrame gameFrame) {	
		ShowSpinnerActionListener showSpinnerActionListener =  new ShowSpinnerActionListener(gameFrame);
		NewPlayerActionListener newPlayerActionListener =  new NewPlayerActionListener(gameFrame);
		RemovePlayerActionListener removePlayerActionListener =  new RemovePlayerActionListener(gameFrame);
		AddBetActionListener addBetActionListener =  new AddBetActionListener(gameFrame);
		RemoveBetActionListener removeBetActionListener =  new RemoveBetActionListener(gameFrame);
		ExitActionListener exitActionListener =  new ExitActionListener(gameFrame);
		
		JMenu menu = new JMenu("File");
		
		menu.setPreferredSize(new Dimension(120, 10));
		menu.setOpaque(true);
		menu.setBackground(Color.LIGHT_GRAY);
		
		menu.add(showSpinner);
		menu.add(addPlayer);
		menu.add(removePlayer);
		menu.add(addBet);
		menu.add(removeBet);
	    menu.add(new JSeparator()); // SEPARATOR
		menu.add(exit);
		
		showSpinner.addActionListener(showSpinnerActionListener);
		addPlayer.addActionListener(newPlayerActionListener);
		removePlayer.addActionListener(removePlayerActionListener);
		addBet.addActionListener(addBetActionListener);
		removeBet.addActionListener(removeBetActionListener);
		exit.addActionListener(exitActionListener);
		
		add(menu);

	}

}