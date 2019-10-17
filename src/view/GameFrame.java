package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import controller.BetValidator;
import controller.PanelHandler;
import controller.SpinValidator;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private JPanel top = new JPanel(new GridLayout(2, 1));
	private GameEngine gameEngine;
	private SummaryPanel summaryPanel;
	private CoinPanel spinnerCoinPanel;
	private CoinPanel visibleCoinPanel;
	private CoinPanel activeCoinPanel;
	private PullDownMenu pullDownMenu;
	private BetValidator betValidator;
	private SpinValidator spinValidator;
	private PanelHandler panelHandler;

	public GameFrame(GameEngine gameEngine) {
		super();
		
		this.spinnerCoinPanel = new CoinPanel("Spinner");
		this.gameEngine = gameEngine;
		this.betValidator = new BetValidator();
		this.spinValidator = new SpinValidator();
		this.panelHandler = new PanelHandler();

		// Set J Menu Bar Jemnu Items J Menu

		// Add Seed Data
		this.addSeedData(gameEngine);

		this.summaryPanel = new SummaryPanel(gameEngine);
		ToolBar toolBar = new ToolBar(this);
		this.pullDownMenu = new PullDownMenu(this);

		setBounds(100, 69, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		top.add(toolBar, BorderLayout.NORTH);
		top.add(pullDownMenu, BorderLayout.SOUTH);
		top.setPreferredSize(new Dimension(150, 100));

		add(top, BorderLayout.NORTH);
		add(summaryPanel, BorderLayout.WEST);
		summaryPanel.setPreferredSize(new Dimension(200, 20));
		toolBar.setPreferredSize(new Dimension(150, 40));

		this.visibleCoinPanel = panelHandler.getPlayerPanel(pullDownMenu.getSelectedPlayer());
		this.addVisibleCoinPanel(visibleCoinPanel);

		setVisible(true);
	}

	public void addSeedData(GameEngine gameEngine) {
		// Add Seed PLayers

		this.createPlayer("1", "The Coint Master", 1000);
		this.createPlayer("2", "The Dabbler", 1500);
		this.createPlayer("3", "The Loser", 2000);
	}

	public SummaryPanel getSummaryPanel() {
		return this.summaryPanel;
	}

	public PullDownMenu getPullDownMenu() {
		return this.pullDownMenu;
	}

	public GameEngine getGameEngine() {
		return this.gameEngine;
	}

	public BetValidator getBetValidator() {
		return this.betValidator;
	}

	public SpinValidator getSpinValidator() {
		return this.spinValidator;
	}

	public PanelHandler getPanelHandler() {
		return this.panelHandler;
	}

	public void setActiveCoinPanel(CoinPanel coinPanel) {
		this.activeCoinPanel = coinPanel;
	}

	public CoinPanel getActiveCoinPanel() {
		return this.activeCoinPanel;
	}

	public CoinPanel getSpinnerCoinPanel() {
		return this.spinnerCoinPanel;
	}

	public void createPlayer(String id, String name, int points) {
		Player player = new SimplePlayer(id, name, points);
		gameEngine.addPlayer(player);
		this.panelHandler.addPlayerPanel(player, new CoinPanel(player.getPlayerName()));
		this.betValidator.addPlayerBetStatus(player, false);
		this.spinValidator.addPlayerSpinStatus(player, false);
	}

	public void updateVisibleCoinPanel(CoinPanel coinPanel) {
		remove(this.visibleCoinPanel);
		this.visibleCoinPanel = coinPanel;
		this.addVisibleCoinPanel(this.visibleCoinPanel);
	}

	public void addVisibleCoinPanel(CoinPanel coinPanel) {
		add(coinPanel, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

}