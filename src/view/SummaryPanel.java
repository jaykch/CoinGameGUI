package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.enumeration.BetType;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class SummaryPanel extends JPanel {

	private GameEngine gameEngine;
	private GameFrame gameFrame;
	private ArrayList<JLabel> summaryLabels;

	public SummaryPanel(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		this.gameEngine = gameFrame.getGameEngine();
		this.summaryLabels = new ArrayList<JLabel>();

		// Note: Maximum 5 players can be displayed with 1 place reserved for spinner
		setLayout(new GridLayout(6, 1));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		setBorder(blackBorder);

		update();
	}

	public void update() {

		summaryLabels.clear();
		this.removeAll();
		Border grayBorder = BorderFactory.createLineBorder(Color.BLUE);

		this.handleLabels();

		for (JLabel jLabel : summaryLabels) {
			add(jLabel);
			jLabel.setBorder(grayBorder);
		}

		this.revalidate();
		this.repaint();
	}

	public void handlePlayerDetails() {
		// Get all player details and generate labels accordingly

		for (Player player : this.gameEngine.getAllPlayers()) {
			String playerDetails = "";
			if (player.getBetType() == null) {
				playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
						+ "Bet: No bet made!" + "<br/>" + "Coin Results: Not spun yet!" + "</html>";
			} else if ((player.getBetType() != null && !gameFrame.getSpinValidator().checkPlayerSpinStatus(player))
					|| player.getBetType() == BetType.NO_BET) {

				playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
						+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "<br/>"
						+ "Coin Results: Not spun yet!" + "</html>";

			} else if (gameFrame.getSpinValidator().checkPlayerSpinStatus(player)) {
				playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
						+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "<br/>" + "Coin Results: "
						+ gameFrame.getSpinValidator().getPlayerSpinResults(player).toString() + "</html>";
			}
			summaryLabels.add(new JLabel(playerDetails));
		}
	}

	public void handleLabels() {
		String spinnerDetails;

		// Display results if spinner has spun

		if (gameFrame.getSpinValidator().getSpinnerSpunStatus()) {
			spinnerDetails = "<html>" + "Spinner" + "<br/>" + "Coin Results: "
					+ gameFrame.getSpinValidator().getSpinnerSpunResult().toString() + "</html>";

			for (Player player : this.gameEngine.getAllPlayers()) {
				String playerDetails = "";
				int points = player.getPoints() - gameFrame.getSpinValidator().getPlayerPointsBeforeSpin(player);

				if (points > 0) {
					playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
							+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "<br/>"
							+ "Coin Results: " + gameFrame.getSpinValidator().getPlayerSpinResults(player).toString()
							+ "<br/>" + "Game Result: Won " + points + " points" + "</html>";
				} else if (points < 0) {
					playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
							+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "<br/>"
							+ "Coin Results: " + gameFrame.getSpinValidator().getPlayerSpinResults(player).toString()
							+ "<br/>" + "Game Result: Lost " + Math.abs(points) + " points" + "</html>";
				} else if (points == 0) {

					// If a draw is designed this would be displayed, ignore for the current logic

					playerDetails += "<html>" + player.getPlayerName() + "<br/> Points: " + player.getPoints() + "<br/>"
							+ "Bet Type: " + player.getBetType() + " Bet: " + player.getBet() + "<br/>"
							+ "Coin Results: " + gameFrame.getSpinValidator().getPlayerSpinResults(player).toString()
							+ "<br/>" + "Game Result: Draw - No points won or lost! " + points + "</html>";
				}
				summaryLabels.add(new JLabel(playerDetails));
			}

		} else {
			spinnerDetails = "<html>" + "Spinner" + "<br/>" + "Coin Results: Not spun yet!" + "</html>";
			this.handlePlayerDetails();
		}
		summaryLabels.add(new JLabel(spinnerDetails));
	}

}