package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.GameFrame;

public class ExitActionListener implements ActionListener {
	private GameFrame gameFrame;

	public ExitActionListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {
		
		int confirm = JOptionPane.showConfirmDialog(
				null, "Are you sure you want to remove exit the game ?",
				"Remove Player", JOptionPane.OK_CANCEL_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			gameFrame.dispose();
		}
	}
}