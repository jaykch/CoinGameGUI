package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.GameFrame;

public class ShowSpinnerActionListener implements ActionListener {
	private GameFrame gameFrame;

	public ShowSpinnerActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameFrame.updateVisibleCoinPanel(gameFrame.getSpinnerCoinPanel());
	}
}
