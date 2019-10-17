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
	
	gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameEngine));
	
	}
}