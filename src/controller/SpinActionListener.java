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
		this.selectedPlayer = this.gameFrame.getPullDownMenu().getSelectedPlayer();

		new Thread() {

			@Override
			public void run() {
				if (gameFrame.getBetValidator().checkPlayerBetStatus(selectedPlayer)) {

					if (!gameFrame.getSpinValidator().checkPlayerBetStatus(selectedPlayer)) {
						// Set Spin status to true so user cannot spin coins again
						gameFrame.getSpinValidator().addPlayerSpinStatus(selectedPlayer, true);

						// Set active coin panel to show the spinning coins only on that panel
						gameFrame.setActiveCoinPanel(gameFrame.getPanelHandler()
								.getPlayerPanel(gameFrame.getPullDownMenu().getSelectedPlayer()));

						// Disable spin button while player is spinning
						gameFrame.getPullDownMenu().getSpinButton().setEnabled(false);
						gameEngine.spinPlayer(selectedPlayer, initialDelay1, finalDelay1, delayIncrement1,
								initialDelay2, finalDelay2, delayIncrement2);

						this.spinnerHandler();

						// Enable spin button after spinning
						gameFrame.getPullDownMenu().getSpinButton().setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "Error: Player has already spun!", "Error",
								JOptionPane.ERROR_MESSAGE);

					}

				} else {
					JOptionPane.showMessageDialog(null, "Error: No Bet Type selected!", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void spinnerHandler() {

				if (gameFrame.getSpinValidator().checkAllSpinStatus()) {
					gameEngine.spinSpinner(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2,
							delayIncrement2);
				}
			}
		}.start();
	}
}