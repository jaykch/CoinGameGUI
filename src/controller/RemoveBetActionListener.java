package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.PullDownMenu;

public class RemoveBetActionListener implements ActionListener {
	PullDownMenu pullDownMenu = null;

	public RemoveBetActionListener(PullDownMenu pullDownMenu) {
		this.pullDownMenu = pullDownMenu;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		pullDownMenu.getSelectedPlayer().resetBet();
		JOptionPane.showMessageDialog(null, "Your bet has been reset!", "Success", JOptionPane.OK_OPTION);
	}
}