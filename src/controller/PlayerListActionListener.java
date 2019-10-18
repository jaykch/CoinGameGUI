package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.GameFrame;

public class PlayerListActionListener implements ActionListener {

	private GameFrame gameFrame;

	public PlayerListActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameFrame.updateVisibleCoinPanel(
				gameFrame.getPanelHandler().getPlayerPanel(gameFrame.getPlayerMenu().getSelectedPlayer()));
	}
}
