package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.GameFrame;

public class RemoveBetActionListener implements ActionListener {
	private GameFrame gameFrame;

	public RemoveBetActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		gameFrame.getBetValidator().addPlayerBetStatus(gameFrame.getPlayerMenu().getSelectedPlayer(), false);
		gameFrame.getPlayerMenu().getSelectedPlayer().resetBet();
		gameFrame.getSummaryPanel().update();
		gameFrame.getStatusBar()
				.setStatus(gameFrame.getPlayerMenu().getSelectedPlayer().getPlayerName() + " reset their bet!");
		JOptionPane.showMessageDialog(null, "Your bet has been reset!", "Success", JOptionPane.OK_OPTION);
	}
}