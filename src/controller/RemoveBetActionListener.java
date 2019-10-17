package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.GameFrame;
import view.PullDownMenu;

public class RemoveBetActionListener implements ActionListener {
	private GameFrame gameFrame;

	public RemoveBetActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		gameFrame.getPullDownMenu().getSelectedPlayer().resetBet();
		JOptionPane.showMessageDialog(null, "Your bet has been reset!", "Success", JOptionPane.OK_OPTION);
	}
}