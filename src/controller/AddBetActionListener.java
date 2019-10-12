package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import view.PullDownMenu;

public class AddBetActionListener implements ActionListener {
	GameEngine gameEngine = null;
	PullDownMenu pullDownMenu = null;

	public AddBetActionListener(GameEngine gameEngine, PullDownMenu pullDownMenu) {
		this.pullDownMenu = pullDownMenu;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		String[] betTypes = { "Coin1", "Coin2", "Both", "No Bet" };
		JComboBox<String> betType = new JComboBox<String>(betTypes);

		JTextField betInput = new JTextField();

		Object[] fields = { "Select Bet Type", betType, "Add Points:", betInput };
		JOptionPane.showConfirmDialog(null, fields, "Add Bet", JOptionPane.OK_CANCEL_OPTION);

		int bet = Integer.parseInt(betInput.getText());

		if (bet <= 0) {
			JOptionPane.showMessageDialog(null, "Invalid Bet - Your bet has been reset", "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			try {

				switch (betType.getSelectedItem().toString()) {

				case "Coin1":
					gameEngine.placeBet(pullDownMenu.getSelectedPlayer(), bet, BetType.COIN1);
					break;

				case "Coin2":
					gameEngine.placeBet(pullDownMenu.getSelectedPlayer(), bet, BetType.COIN2);
					break;
				case "Both":
					gameEngine.placeBet(pullDownMenu.getSelectedPlayer(), bet, BetType.BOTH);
					break;
				case "No Bet":
					gameEngine.placeBet(pullDownMenu.getSelectedPlayer(), bet, BetType.NO_BET);
					break;
				default:
					JOptionPane.showMessageDialog(null, "No Bet  Type Selected", "Error", JOptionPane.ERROR_MESSAGE);
					break;
				}

			} catch (NumberFormatException e) {

				JOptionPane.showMessageDialog(null, "Not the correct input type", "Error", JOptionPane.ERROR_MESSAGE);

			}
		}

	}
}