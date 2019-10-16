package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CoinPanel extends JPanel {
	private JLabel coin1 = new JLabel();
	private JLabel coin2 = new JLabel();
	private ImageIcon heads = new ImageIcon("img/heads.png");
	private ImageIcon tails = new ImageIcon("img/tails.png");

	public CoinPanel() {
		this.setLayout(new BorderLayout());
		add(new StatusBar(), BorderLayout.SOUTH);

		coin1.setIcon(heads);
		coin2.setIcon(tails);
		add(coin1, BorderLayout.WEST);
		add(coin2, BorderLayout.EAST);
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