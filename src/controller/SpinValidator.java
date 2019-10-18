package controller;

import java.util.HashMap;
import java.util.Map;

import model.interfaces.CoinPair;
import model.interfaces.Player;

public class SpinValidator {

	private Map<Player, Boolean> spunPlayers;
	private Map<Player, Integer> playerPointsBeforeSpin;
	private Map<Player, CoinPair> spunPlayerResults;
	private Boolean spinnerSpunStatus;
	private CoinPair spinnerSpunResult;

	public SpinValidator() {
		this.spunPlayers = new HashMap<Player, Boolean>();
		this.playerPointsBeforeSpin = new HashMap<Player, Integer>();
		this.spunPlayerResults = new HashMap<Player, CoinPair>();
		this.spinnerSpunStatus = false;
	}

	public boolean checkPlayerSpinStatus(Player player) {
		return this.spunPlayers.get(player);
	}

	public boolean checkAllSpinStatus() {

		for (Boolean spinStatus : spunPlayers.values()) {
			if (!spinStatus) {
				return false;
			}
		}
		return true;
	}

	public void setPlayerPointsBeforeSpin(Player player, int points) {
		if (player != null) {
			this.playerPointsBeforeSpin.put(player, points);
		}
	}

	public int getPlayerPointsBeforeSpin(Player player) {
		return this.playerPointsBeforeSpin.get(player);
	}

	public void addPlayerSpinStatus(Player player, Boolean spinStatus) {
		if (player != null) {
			this.spunPlayers.put(player, spinStatus);
		}
	}

	public void addPlayerSpinResults(Player player, CoinPair coinPair) {
		if (player != null) {
			this.spunPlayerResults.put(player, coinPair);
		}
	}

	public CoinPair getPlayerSpinResults(Player player) {
		return this.spunPlayerResults.get(player);
	}

	public void removePlayerSpinStatus(Player player) {
		this.spunPlayers.remove(player);
	}

	public void resetAllSpinStatus() {
		this.spunPlayers.clear();
	}

	public void setSpinnerSpunStatus(Boolean status) {
		this.spinnerSpunStatus = status;
	}

	public Boolean getSpinnerSpunStatus() {
		return this.spinnerSpunStatus;
	}

	public void setSpinnerSpunResult(CoinPair coinPair) {
		this.spinnerSpunResult = coinPair;
	}

	public CoinPair getSpinnerSpunResult() {
		return this.spinnerSpunResult;
	}
	
	public void removePlayer(Player player) {
		this.removePlayerSpinStatus(player);
		this.playerPointsBeforeSpin.remove(player);
		this.spunPlayerResults.remove(player);
	}
}