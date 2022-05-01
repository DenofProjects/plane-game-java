package com.pd.game;

import javax.swing.*;

import static com.pd.constants.Constants.GAME_WINDOW_HEIGHT;
import static com.pd.constants.Constants.GAME_WINDOW_WIDTH;

public class GameWindow {
    private JFrame jFrame;

    public GameWindow(GamePanel gamePanel) {
        jFrame = new JFrame();
        jFrame.setSize(GAME_WINDOW_WIDTH, GAME_WINDOW_HEIGHT);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
