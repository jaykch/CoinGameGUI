package view;
import javax.swing.JLabel;
import javax.swing.JToolBar;

@SuppressWarnings("serial")
public class StatusBar extends JToolBar{
	private JLabel statusLabel1 = new JLabel("Player betting at the moment: ", JLabel.LEFT);
	public StatusBar() {
		add(statusLabel1);
	}
}