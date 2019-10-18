package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;

import controller.PlayerListActionListener;
import controller.SpinActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class PlayerMenu extends JMenuBar {
	private GameEngine gameEngine;
	private JComboBox<String> playerList;
	private JButton spinButton;

	public PlayerMenu(GameFrame gameFrame) {
		this.gameEngine = gameFrame.getGameEngine();
		this.playerList = new JComboBox<String>();
		this.spinButton = new JButton("Spin");

		populate();

		playerList.setPreferredSize(new Dimension(150, 0));
		this.setLayout(new BorderLayout());
		this.add(playerList, BorderLayout.CENTER);
		spinButton.setPreferredSize(new Dimension(100, 40));
		this.add(spinButton, BorderLayout.WEST);

		SpinActionListener spinActionListener = new SpinActionListener(gameFrame);
		PlayerListActionListener playerListActionListener = new PlayerListActionListener(gameFrame);
		spinButton.addActionListener(spinActionListener);
		playerList.addActionListener(playerListActionListener);
	}

	public void populate() {

		for (Player player : gameEngine.getAllPlayers()) {
			this.playerList.addItem(player.getPlayerId() + ") " + player.getPlayerName());
		}

	}

	public void removePlayer() {
		this.playerList.removeItem(this.playerList.getSelectedItem());
	}

	public void addPlayer(Player player) {
		this.playerList.addItem(player.getPlayerId() + ") " + player.getPlayerName());
	}

	public Player getSelectedPlayer() {
		String playerID = this.playerList.getSelectedItem().toString().substring(0, 1);
		return this.gameEngine.getPlayer(playerID);
	}

	public JButton getSpinButton() {
		return this.spinButton;
	}

}