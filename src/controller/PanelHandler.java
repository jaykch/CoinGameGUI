package controller;

import java.util.HashMap;
import java.util.Map;


import model.interfaces.Player;
import view.CoinPanel;

public class PanelHandler {

	private Map<Player, CoinPanel> playerPanels;

	public PanelHandler() {
		this.playerPanels = new HashMap<Player, CoinPanel>();
	}

	public void addPlayerPanel(Player player, CoinPanel panel) {
		this.playerPanels.put(player, panel);
	}

	public void removePlayerPanel(Player player) {
		this.playerPanels.remove(player);
	}

	public CoinPanel getPlayerPanel(Player player) {
		return this.playerPanels.get(player);
	}
}