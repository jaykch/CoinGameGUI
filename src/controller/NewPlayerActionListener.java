package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import view.GameFrame;
import view.PullDownMenu;

public class NewPlayerActionListener implements ActionListener {
	private GameEngine gameEngine;
	private PullDownMenu pullDownMenu;
	private Integer lastID;

	public NewPlayerActionListener(GameFrame gameFrame) {
		this.pullDownMenu = gameFrame.getPullDownMenu();
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
			SimplePlayer newPlayer = new SimplePlayer(lastID.toString(), newPlayerName.getText(),
					Integer.parseInt(newPlayerScore.getText()));
			gameEngine.addPlayer(newPlayer);
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Not the correct input type", "Error", JOptionPane.ERROR_MESSAGE);
		}
		pullDownMenu.populate();
	}
}