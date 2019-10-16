package view;

import model.interfaces.GameEngine;

public class ViewModel {

	private GameEngine gameEngine;
	private SummaryPanel summaryPanel;
	private PullDownMenu pullDownMenu;
	private CoinPanel coinPanel;


	public ViewModel(GameEngine gameEngine, SummaryPanel summaryPanel, PullDownMenu pullDownMenu, CoinPanel coinPanel) {
		this.gameEngine = gameEngine;
		this.summaryPanel = summaryPanel;
		this.pullDownMenu = pullDownMenu;
		this.coinPanel = coinPanel;
	}

	public GameEngine getGameEngine() {
		return this.gameEngine;
	}
	
	public void updateSummaryPanel() {
		summaryPanel.update();		
	}
	
	public PullDownMenu getPullDownMenu() {
		return this.pullDownMenu;
	}
	
	public CoinPanel getCoinPanel() {
		return this.coinPanel;
	}
}