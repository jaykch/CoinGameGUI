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

	private GameEngine gameEngine;
	private ArrayList<JLabel> playerLabels = new ArrayList<JLabel>();

	public SummaryPanel(GameEngine gameEngine) {

		this.gameEngine = gameEngine;

		// Note: Maximum 10 players can be displayed
		setLayout(new GridLayout(10, 1));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(blackBorder);

		update();
	}

	// Get all player details and generate labels accordingly
	public void update() {
		playerLabels.clear();
		this.removeAll();

		Border grayBorder = BorderFactory.createLineBorder(Color.BLUE);
		for (Player player : this.gameEngine.getAllPlayers()) {
			String playerDetails = "";

			if (player.getBetType() == null) {
				playerDetails += "<html>" + player.getPlayerName() + " Points: " + player.getPoints() + "<br/>"
						+ "Bet: No bet made!" + "</html>";
			} else {
				playerDetails += "<html>" + player.getPlayerName() + " Points: " + player.getPoints() + "<br/>"
						+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "</html>";
			}

			playerLabels.add(new JLabel(playerDetails));
		}

		for (JLabel jLabel : playerLabels) {
			add(jLabel);
			jLabel.setBorder(grayBorder);
		}
	}
}