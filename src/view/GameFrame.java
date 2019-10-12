package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ValidateSpin;
import model.interfaces.GameEngine;
@SuppressWarnings("serial")
public class GameFrame extends JFrame{
	private CoinPanel coinPanel = new CoinPanel();
	JPanel top = new JPanel(new GridLayout(2, 1));

	
	public GameFrame(GameEngine gameEngine) {
		super();
		
		//Set J Menu Bar Jemnu Items J Menu
		
		SummaryPanel summaryPanel = new SummaryPanel(gameEngine);
		PullDownMenu pullDownMenu = new PullDownMenu(gameEngine);
		ToolBar toolBar = new ToolBar(gameEngine, pullDownMenu);
		
		ValidateSpin validateSpin = new ValidateSpin();
		
        setBounds(100, 69, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        top.add(toolBar, BorderLayout.NORTH);
        top.add(pullDownMenu, BorderLayout.SOUTH);
        top.setPreferredSize(new Dimension(150,100));

        add(top, BorderLayout.NORTH);
        add(coinPanel, BorderLayout.CENTER);
        add(summaryPanel, BorderLayout.WEST);
        summaryPanel.setPreferredSize(new Dimension(150,20));
        toolBar.setPreferredSize(new Dimension(150, 40));
        
        setVisible(true);
	}
}