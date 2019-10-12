package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import model.interfaces.GameEngine;
import view.PullDownMenu;

public class SpinActionListener implements ActionListener {
	GameEngine gameEngine = null;
	PullDownMenu pullDownMenu = null;

	private int initialDelay1 = 100;
	private int finalDelay1 = 1000;
	private int delayIncrement1 = 100;
	private int initialDelay2 = 50;
	private int finalDelay2 = 500;
	private int delayIncrement2 = 50;

	public SpinActionListener(GameEngine gameEngine, PullDownMenu pullDownMenu) {
		this.gameEngine = gameEngine;
		this.pullDownMenu = pullDownMenu;
	}

	@Override
	public void actionPerformed(ActionEvent AE) {

		new Thread() {
			@Override
			public void run() {
				gameEngine.spinPlayer(pullDownMenu.getSelectedPlayer(), initialDelay1, finalDelay1, delayIncrement1,
						initialDelay2, finalDelay2, delayIncrement2);
			}
		}.start();

		try {

		} catch (NullPointerException e) {
			// do nothing
		}
	}
}