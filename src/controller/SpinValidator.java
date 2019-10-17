package controller;

import java.util.HashMap;
import java.util.Map;

import model.interfaces.Player;

public class SpinValidator {

	private Map<Player, Boolean> spunPlayers;

	public SpinValidator() {
		this.spunPlayers = new HashMap<Player, Boolean>();
	}

	public boolean checkPlayerBetStatus(Player player) {
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

	public void addPlayerSpinStatus(Player player, Boolean spinStatus) {
		if (player != null) {
			this.spunPlayers.put(player, spinStatus);
		}
	}

	public void removePlayerSpinStatus(Player player) {
		this.spunPlayers.remove(player);
	}

	public void resetAllSpinStatus() {
		this.spunPlayers.clear();
	}
}