package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.PullDownMenu;

public class RemovePlayerActionListener implements ActionListener {
	GameEngine gameEngine = null;
	PullDownMenu pullDownMenu = null;

	public RemovePlayerActionListener(GameEngine gameEngine, PullDownMenu pullDownMenu) {
		this.pullDownMenu = pullDownMenu;
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		int confirm = JOptionPane.showConfirmDialog(null,
				"Are you sure you would like to remove " + pullDownMenu.getSelectedPlayer().getPlayerName(),
				"Remove Player", JOptionPane.OK_CANCEL_OPTION);
		try {
			if (confirm == JOptionPane.YES_OPTION) {

				new Thread() {
					@Override
					public void run() {
						gameEngine.removePlayer(pullDownMenu.getSelectedPlayer());
					}
				}.start();
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						pullDownMenu.populate();
					}
				});
			}

		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Player Doesnt Exist", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}