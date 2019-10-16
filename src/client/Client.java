package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class Client {
	
	public static void main (String args[]) {
	GameEngine gameEngine = new GameEngineImpl();
	
	Player player1 = new SimplePlayer("1", "The Coin Master", 100);
	Player player2 = new SimplePlayer("2", "The Dabbler", 300);
	Player player3 = new SimplePlayer("3", "The Loser", 300);
	

	gameEngine.addPlayer(player1);
	gameEngine.addPlayer(player2);
	gameEngine.addPlayer(player3);
	
	gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameEngine));
	
	}
}