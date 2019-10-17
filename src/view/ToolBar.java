package view;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.AddBetActionListener;
import controller.NewPlayerActionListener;
import controller.RemoveBetActionListener;
import controller.RemovePlayerActionListener;
import controller.ShowSpinnerActionListener;


@SuppressWarnings("serial")
public class ToolBar extends JToolBar{
	
	private JButton showSpinner = new JButton("Show Spinner");
	private JButton addPlayer = new JButton("Add Player");
	private JButton removePlayer = new JButton("Remove Player");
	private JButton addBet = new JButton("Add Bet");
	private JButton removeBet = new JButton("Remove Bet");
	

	
	public ToolBar(GameFrame gameFrame) {	
		
		ShowSpinnerActionListener showSpinnerActionListener =  new ShowSpinnerActionListener(gameFrame);
		NewPlayerActionListener newPlayerActionListener =  new NewPlayerActionListener(gameFrame);
		RemovePlayerActionListener removePlayerActionListener =  new RemovePlayerActionListener(gameFrame);
		AddBetActionListener addBetActionListener =  new AddBetActionListener(gameFrame);
		RemoveBetActionListener removeBetActionListener =  new RemoveBetActionListener(gameFrame);

		showSpinner.setMargin(new Insets(10, 50, 10, 50));
		

		add(showSpinner);
		add(addPlayer);
		add(removePlayer);
		add(addBet);
		add(removeBet);
		
		showSpinner.addActionListener(showSpinnerActionListener);
		addPlayer.addActionListener(newPlayerActionListener);
		removePlayer.addActionListener(removePlayerActionListener);
		addBet.addActionListener(addBetActionListener);
		removeBet.addActionListener(removeBetActionListener);
	}
}
