package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	ArrayList<JLabel> playerSum = new ArrayList<JLabel>();
	
	private JLabel statusLabel1 = new JLabel("Shit Works", JLabel.LEFT);


	public SummaryPanel(GameEngine engine) {
		setLayout(new GridLayout(10, 1)); // Up to 10 players can be displayed
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		Border grayBorder = BorderFactory.createLineBorder(Color.BLUE);
		setBorder(blackBorder);
		add(statusLabel1);


		createLabels(engine);

		for (JLabel jLabel : playerSum) {
			add(jLabel);
			jLabel.setBorder(grayBorder);
		}
	}

	public void createLabels(GameEngine engine) {
		for (Player player : engine.getAllPlayers()) {
			String playerDets = "";

			playerDets += String.format("%s, points = %d\n", player.getPlayerName(), player.getPoints());

			playerSum.add(new JLabel(playerDets));
		}
	}
}