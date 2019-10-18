package client;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class Client {
	
	public static void main (String args[]) {
	GameEngine gameEngine = new GameEngineImpl();
	
	gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(gameEngine));
	
	}
}