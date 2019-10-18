package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameFrame;

public class SpinActionListener implements ActionListener {
	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private Player selectedPlayer;

	private int initialDelay1 = 100;
	private int finalDelay1 = 1000;
	private int delayIncrement1 = 100;
	private int initialDelay2 = 50;
	private int finalDelay2 = 500;
	private int delayIncrement2 = 50;

	public SpinActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.gameEngine = gameFrame.getGameEngine();
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		this.selectedPlayer = this.gameFrame.getPlayerMenu().getSelectedPlayer();

		new Thread() {

			@Override
			public void run() {
				if (gameFrame.getBetValidator().checkPlayerBetStatus(selectedPlayer)) {

					if (!gameFrame.getSpinValidator().checkPlayerSpinStatus(selectedPlayer)) {

						this.playerHandler();
						this.spinnerHandler();

					} else {
						JOptionPane.showMessageDialog(null,
								"Error: " + selectedPlayer.getPlayerName() + " has already spun or selected no bet!", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Error: " + selectedPlayer.getPlayerName() + "has not made a bet yet!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void playerHandler() {
				// Store players initial points before spin
				gameFrame.getSpinValidator().setPlayerPointsBeforeSpin(selectedPlayer, selectedPlayer.getPoints());

				// Set Spin status to true so user cannot spin coins again
				gameFrame.getSpinValidator().addPlayerSpinStatus(selectedPlayer, true);

				// Set active coin panel to show the spinning coins only on that panel
				gameFrame.setActiveCoinPanel(
						gameFrame.getPanelHandler().getPlayerPanel(gameFrame.getPlayerMenu().getSelectedPlayer()));

				// Disable spin button while player is spinning
				gameFrame.getPlayerMenu().getSpinButton().setEnabled(false);
				gameFrame.getStatusBar().setStatus(selectedPlayer.getPlayerName() + " is spinnging coins!");
				gameEngine.spinPlayer(selectedPlayer, initialDelay1, finalDelay1, delayIncrement1, initialDelay2,
						finalDelay2, delayIncrement2);

				// Enable spin button after spinning
				gameFrame.getPlayerMenu().getSpinButton().setEnabled(true);
			}

			private void spinnerHandler() {

				if (gameFrame.getSpinValidator().checkAllSpinStatus()) {
					gameFrame.getStatusBar().setStatus("Spinner is spinning coins!");
					gameEngine.spinSpinner(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2,
							delayIncrement2);
				}
			}
		}.start();
	}
}