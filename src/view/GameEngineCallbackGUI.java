package view;

import model.interfaces.Coin;
import model.interfaces.CoinPair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback {

	private GameFrame gameFrame;

	public GameEngineCallbackGUI(GameEngine gameEngine) {
		this.gameFrame = new GameFrame(gameEngine);
	}

	@Override
	public void playerCoinUpdate(Player player, Coin coin, GameEngine engine) {

		if (coin.getNumber() == 1) {
			this.gameFrame.getActiveCoinPanel().setCoin1(coin.getFace().toString());
		} else {
			this.gameFrame.getActiveCoinPanel().setCoin2(coin.getFace().toString());
		}

	}

	@Override
	public void spinnerCoinUpdate(Coin coin, GameEngine engine) {
		if (coin.getNumber() == 1) {
			this.gameFrame.getSpinnerCoinPanel().setCoin1(coin.getFace().toString());
		} else {
			this.gameFrame.getSpinnerCoinPanel().setCoin2(coin.getFace().toString());
		}

	}

	@Override
	public void playerResult(Player player, CoinPair coinPair, GameEngine engine) {
		gameFrame.getSpinValidator().addPlayerSpinResults(player, coinPair);
		gameFrame.getSummaryPanel().update();

	}

	@Override
	public void spinnerResult(CoinPair coinPair, GameEngine engine) {
		gameFrame.getSpinValidator().setSpinnerSpunStatus(true);
		gameFrame.getSpinValidator().setSpinnerSpunResult(coinPair);
		gameFrame.getSummaryPanel().update();
		gameFrame.getStatusBar().setStatus("Game results have been listed!");
		gameFrame.removeNoPointsPlayers();
		gameFrame.resetGame();
	}

}
