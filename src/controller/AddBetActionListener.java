package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameFrame;

public class AddBetActionListener implements ActionListener {

	private GameEngine gameEngine;
	private Player selectedPlayer;;
	private GameFrame gameFrame;

	public AddBetActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.gameEngine = gameFrame.getGameEngine();
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		this.selectedPlayer = this.gameFrame.getPlayerMenu().getSelectedPlayer();

		String[] betTypes = { "Coin1", "Coin2", "Both", "No Bet" };
		JComboBox<String> betType = new JComboBox<String>(betTypes);
		JTextField betInput = new JTextField();

		try {

			Object[] fields = { "Select Bet Type", betType, "Add Points:", betInput };
			JOptionPane.showConfirmDialog(null, fields, "Add Bet", JOptionPane.OK_CANCEL_OPTION);

			int bet = Integer.parseInt(betInput.getText());

			if (bet < 0 || bet > selectedPlayer.getPoints()) {
				JOptionPane.showMessageDialog(null, "Error: Bet cannot be lower than 0 or greater than current points",
						"Error", JOptionPane.ERROR_MESSAGE);
			} else {

				switch (betType.getSelectedItem().toString()) {

				case "Coin1":
					this.placeBet(selectedPlayer, BetType.COIN1, bet);
					break;

				case "Coin2":
					this.placeBet(selectedPlayer, BetType.COIN2, bet);
					break;
				case "Both":
					this.placeBet(selectedPlayer, BetType.BOTH, bet);
					break;
				case "No Bet":
					this.placeBet(selectedPlayer, BetType.NO_BET, bet);
					gameFrame.getSpinValidator().addPlayerSpinStatus(selectedPlayer, true);
					break;
				default:
					JOptionPane.showMessageDialog(null, selectedPlayer.getPlayerName() + "has not made a bet yet!",
							"Error", JOptionPane.ERROR_MESSAGE);
					break;
				}
				gameFrame.getSummaryPanel().update();
				gameFrame.getStatusBar().setStatus(selectedPlayer.getPlayerName() + " made a bet!");
			}

		} catch (NumberFormatException e) {

			JOptionPane.showMessageDialog(null,
					"Error: Invalid Bet! Please select a valid bet. (Add 0 points if no bet is selected)", "Error",
					JOptionPane.ERROR_MESSAGE);

		}

	}

	public void placeBet(Player player, BetType betType, int bet) {
		gameEngine.placeBet(player, bet, betType);
		gameFrame.getBetValidator().addPlayerBetStatus(player, true);
	}
}