package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.GameFrame;

public class RemovePlayerActionListener implements ActionListener {
	private GameFrame gameFrame;

	public RemovePlayerActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		int confirm = JOptionPane.showConfirmDialog(
				null, "Are you sure you want to remove "
						+ gameFrame.getPlayerMenu().getSelectedPlayer().getPlayerName() + " ?",
				"Remove Player", JOptionPane.OK_CANCEL_OPTION);
		try {
			if (confirm == JOptionPane.YES_OPTION) {
				gameFrame.removePlayer(gameFrame.getPlayerMenu().getSelectedPlayer());
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Player Doesnt Exist", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}