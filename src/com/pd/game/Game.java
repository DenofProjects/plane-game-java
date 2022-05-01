package com.pd.game;

public class Game {
    private GamePanel gamePanel;

    public Game() {
        gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
}
