package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameFrame;

public class NewPlayerActionListener implements ActionListener {
	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private Integer lastID;

	public NewPlayerActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.gameEngine = gameFrame.getGameEngine();
		this.lastID = gameEngine.getAllPlayers().size();
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		JTextField newPlayerName = new JTextField();
		JTextField newPlayerScore = new JTextField();
		Object[] fields = { "New Player Name:", newPlayerName, "Starting Points (Amount):", newPlayerScore, };
		JOptionPane.showConfirmDialog(null, fields, "Add New Player", JOptionPane.OK_CANCEL_OPTION);
		try {
			this.lastID++;
			// Add created player to combo box and update the summary panel with new player
			Player player = gameFrame.createPlayer(lastID.toString(), newPlayerName.getText(),
					Integer.parseInt(newPlayerScore.getText()));
			gameFrame.getPlayerMenu().addPlayer(player);
			gameFrame.getStatusBar().setStatus("New player: " + player.getPlayerName() + " added to game!");
			gameFrame.getSummaryPanel().update();
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Not the correct input type", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}