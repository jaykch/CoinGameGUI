package view;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.AddBetActionListener;
import controller.NewPlayerActionListener;
import controller.RemoveBetActionListener;
import controller.RemovePlayerActionListener;
import model.interfaces.GameEngine;


@SuppressWarnings("serial")
public class ToolBar extends JToolBar{
	
	private JButton addPlayer = new JButton("Add Player");
	private JButton removePlayer = new JButton("Remove Player");
	private JButton addBet = new JButton("Add Bet");
	private JButton removeBet = new JButton("Remove Bet");

	
	public ToolBar(GameEngine gameEngine, PullDownMenu pullDownMenu) {	
		
		NewPlayerActionListener newPlayerActionListener =  new NewPlayerActionListener(gameEngine, pullDownMenu);
		RemovePlayerActionListener removePlayerActionListener =  new RemovePlayerActionListener(gameEngine, pullDownMenu);
		AddBetActionListener addBetActionListener =  new AddBetActionListener(gameEngine, pullDownMenu);
		RemoveBetActionListener removeBetActionListener =  new RemoveBetActionListener(pullDownMenu);

		addPlayer.setPreferredSize(new Dimension(300,40));
		removePlayer.setPreferredSize(new Dimension(300,40));
		addBet.setPreferredSize(new Dimension(300,40));
		removeBet.setPreferredSize(new Dimension(300,40));

		add(addPlayer);
		add(removePlayer);
		add(addBet);
		add(removeBet);
		
		addPlayer.addActionListener(newPlayerActionListener);
		removePlayer.addActionListener(removePlayerActionListener);
		addBet.addActionListener(addBetActionListener);
		removeBet.addActionListener(removeBetActionListener);
	}
}
