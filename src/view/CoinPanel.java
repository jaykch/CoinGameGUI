package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class CoinPanel extends JPanel {
	private JLabel coin1 = new JLabel();
	private JLabel coin2 = new JLabel();
	private ImageIcon heads = new ImageIcon("img/heads.png");
	private ImageIcon tails = new ImageIcon("img/tails.png");
	private JLabel playerLabel;

	public CoinPanel(String playerName) {

		// Create a label with player name so the user knows which players coins they
		// are currently viewing
		playerLabel = new JLabel(playerName, JLabel.LEFT);
		// Add Padding Around Label
		playerLabel.setBorder(new EmptyBorder(15, 15, 15, 15));// top,left,bottom,right
		// Add background color
		playerLabel.setOpaque(true);
		playerLabel.setBackground(Color.LIGHT_GRAY);
		;

		this.setLayout(new BorderLayout());
		add(new StatusBar(), BorderLayout.SOUTH);

		coin1.setIcon(heads);
		coin2.setIcon(tails);
		add(coin1, BorderLayout.WEST);
		add(coin2, BorderLayout.EAST);
		add(playerLabel, BorderLayout.NORTH);
	}

	public void setCoin1(String face) {

		if (face.equals("HEADS")) {
			coin1.setIcon(heads);
		} else {
			coin1.setIcon(tails);
		}
	}

	public void setCoin2(String face) {

		if (face.equals("HEADS")) {
			coin2.setIcon(heads);
		} else {
			coin2.setIcon(tails);
		}
	}
}