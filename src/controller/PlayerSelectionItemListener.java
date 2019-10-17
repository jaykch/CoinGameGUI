package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameFrame;

public class PlayerSelectionItemListener implements ActionListener {

	private GameFrame gameFrame;

	public PlayerSelectionItemListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gameFrame.updateVisibleCoinPanel(
				gameFrame.getPanelHandler().getPlayerPanel(gameFrame.getPullDownMenu().getSelectedPlayer()));

	}
}
