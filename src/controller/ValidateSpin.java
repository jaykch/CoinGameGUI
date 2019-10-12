package controller;

import java.util.HashMap;
import java.util.Map;

import model.interfaces.Player;

public class ValidateSpin {

	private Map<Player, Boolean> spinMap;

	public ValidateSpin() {
		this.spinMap = new HashMap<Player, Boolean>();
	}

	public void addSpunPlayer(Player player, Boolean spunStatus) {
		if (player != null) {
			this.spinMap.put(player, spunStatus);
		}
	}

	public boolean checkSpunPlayer(Player player) {
		return this.spinMap.get(player);
	}
	
	public void removeSpunPlayer(Player player) {
		this.spinMap.remove(player);
	}

	public void resetSpunPlayers() {
		this.spinMap.clear();
	}
}