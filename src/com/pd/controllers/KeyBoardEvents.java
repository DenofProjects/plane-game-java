package com.pd.controllers;

import com.pd.game.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardEvents implements KeyListener {

    GamePanel gamePanel;

    public KeyBoardEvents(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                gamePanel.getGamePanelActions().changeDirX(-5);
                System.out.println("A pressed");
                break;
            case KeyEvent.VK_D:
                gamePanel.getGamePanelActions().changeDirX(5);
                System.out.println("D pressed");
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getGamePanelActions().changeDirX(-5);
                System.out.println("left Key pressed");
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGamePanelActions().changeDirX(5);
                System.out.println("right Key pressed");
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.createBullet();
                System.out.println("space Key pressed");
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A:
                gamePanel.getGamePanelActions().changeDirX(-5);
                System.out.println("A pressed");
                break;
            case KeyEvent.VK_D:
                gamePanel.getGamePanelActions().changeDirX(5);
                System.out.println("D pressed");
                break;
            case KeyEvent.VK_LEFT:
                gamePanel.getGamePanelActions().changeDirX(-5);
                System.out.println("left Key pressed");
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getGamePanelActions().changeDirX(5);
                System.out.println("right Key pressed");
                break;
            case KeyEvent.VK_SPACE:
                gamePanel.createBullet();
                System.out.println("space Key pressed");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
