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
	private JPanel top = new JPanel(new GridLayout(3, 1));
	private GameEngine gameEngine;
	private SummaryPanel summaryPanel;
	private CoinPanel spinnerCoinPanel;
	private CoinPanel visibleCoinPanel;
	private CoinPanel activeCoinPanel;
	private PlayerMenu playerMenu;
	private BetValidator betValidator;
	private SpinValidator spinValidator;
	private PanelHandler panelHandler;
	private StatusBar statusBar;

	public GameFrame(GameEngine gameEngine) {
		super();

		this.spinnerCoinPanel = new CoinPanel("Spinner");
		this.gameEngine = gameEngine;
		this.betValidator = new BetValidator();
		this.spinValidator = new SpinValidator();
		this.panelHandler = new PanelHandler();
		this.statusBar = new StatusBar();
		// Add Seed Data
		this.addSeedData(gameEngine);

		this.summaryPanel = new SummaryPanel(this);
		ToolBar toolBar = new ToolBar(this);
		PullDownMenu pullDownMenu = new PullDownMenu(this);
		this.playerMenu = new PlayerMenu(this);

		setBounds(100, 69, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		top.add(pullDownMenu, BorderLayout.NORTH);
		top.add(toolBar, BorderLayout.CENTER);
		top.add(playerMenu, BorderLayout.SOUTH);
		toolBar.setPreferredSize(new Dimension(150, 40));
		pullDownMenu.setPreferredSize(new Dimension(150, 10));

		add(top, BorderLayout.NORTH);
		add(summaryPanel, BorderLayout.WEST);
		summaryPanel.setPreferredSize(new Dimension(300, 20));
		add(statusBar, BorderLayout.SOUTH);

		this.visibleCoinPanel = panelHandler.getPlayerPanel(playerMenu.getSelectedPlayer());
		this.addVisibleCoinPanel(visibleCoinPanel);

		setVisible(true);
	}

	public void addSeedData(GameEngine gameEngine) {
		// Add Seed PLayers
		this.createPlayer("1", "The Coin Master", 1000);
		this.createPlayer("2", "The Dabbler", 750);
		this.createPlayer("3", "The Loser", 500);
	}

	public SummaryPanel getSummaryPanel() {
		return this.summaryPanel;
	}

	public PlayerMenu getPlayerMenu() {
		return this.playerMenu;
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

	public StatusBar getStatusBar() {
		return this.statusBar;
	}

	public Player createPlayer(String id, String name, int points) {
		Player player = new SimplePlayer(id, name, points);
		gameEngine.addPlayer(player);
		this.panelHandler.addPlayerPanel(player, new CoinPanel(player.getPlayerName()));
		this.betValidator.addPlayerBetStatus(player, false);
		this.spinValidator.addPlayerSpinStatus(player, false);

		return player;
	}

	public void removePlayer(Player player) {
		this.statusBar.setStatus(player.getPlayerName() + " has been removed from the game!");
		gameEngine.removePlayer(player);
		this.spinValidator.removePlayer(player);
		this.betValidator.removePlayerBetStatus(player);
		this.summaryPanel.update();
		this.playerMenu.removePlayer();
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

	public void removeNoPointsPlayers() {
		for (Player player : gameEngine.getAllPlayers()) {
			if (player.getPoints() <= 0) {
				this.removePlayer(player);
			}
		}
	}
	
	public void resetGame() {
		
		this.getSpinValidator().setSpinnerSpunStatus(false);
		for (Player player : gameEngine.getAllPlayers()) {
			this.spinValidator.setPlayerPointsBeforeSpin(player, player.getPoints());
			this.spinValidator.addPlayerSpinStatus(player, false);
			this.betValidator.addPlayerBetStatus(player, false);
			player.resetBet();
		}
	}

}