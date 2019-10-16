package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.PullDownMenu;
import view.ViewModel;

public class RemoveBetActionListener implements ActionListener {
	PullDownMenu pullDownMenu = null;

	public RemoveBetActionListener(ViewModel viewModel) {
		this.pullDownMenu = viewModel.getPullDownMenu();
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		pullDownMenu.getSelectedPlayer().resetBet();
		JOptionPane.showMessageDialog(null, "Your bet has been reset!", "Success", JOptionPane.OK_OPTION);
	}
}