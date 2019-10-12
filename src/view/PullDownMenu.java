package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

import controller.RemoveBetActionListener;
import controller.SpinActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PullDownMenu extends JMenuBar {
	private JComboBox<String> playerList = new JComboBox<String>();
	private GameEngine gameEngine;
	JButton spinButton = new JButton("Spin");


	public PullDownMenu(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		SpinActionListener spinActionListener =  new SpinActionListener(gameEngine, this);

		populate();
		
		
		playerList.setPreferredSize(new Dimension(150, 0));
		this.setLayout(new BorderLayout());
		this.add(playerList, BorderLayout.CENTER);
		spinButton.setPreferredSize(new Dimension(100, 40));
		this.add(spinButton, BorderLayout.WEST);
		
		spinButton.addActionListener(spinActionListener);
	}

	public void populate() {

		this.refreshList();

		for (Player player : gameEngine.getAllPlayers()) {
			playerList.addItem(player.getPlayerId() + ") " + player.getPlayerName());
		}

	}

	public void refreshList() {
		playerList.removeAllItems();
	}

	public Player getSelectedPlayer() {
		String playerID = this.playerList.getSelectedItem().toString().substring(0, 1);
		return gameEngine.getPlayer(playerID);
	}

}