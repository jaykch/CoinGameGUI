package controller;

import java.util.HashMap;
import java.util.Map;

import model.interfaces.Player;

public class BetValidator {

	private Map<Player, Boolean> betPlayers;

	public BetValidator() {
		this.betPlayers = new HashMap<Player, Boolean>();
	}

	public boolean checkPlayerBetStatus(Player player) {
		return this.betPlayers.get(player);
	}

	public void addPlayerBetStatus(Player player, Boolean betStatus) {
		if (player != null) {
			this.betPlayers.put(player, betStatus);
		}
	}

	public void removePlayerBetStatus(Player player) {
		this.betPlayers.remove(player);
	}

	public void resetAllBetStatus() {
		this.betPlayers.clear();
	}
}