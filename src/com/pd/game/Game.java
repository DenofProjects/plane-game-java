package com.pd.game;

public class Game implements Runnable {

    private final double FPS = 120;
    private final GamePanel gamePanel;
    private Thread gameThread;

    public Game() {
        gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        this.startThread();
    }

    private void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double lastFrameTime = System.nanoTime();
        while (true) {
            double now = System.nanoTime();
            if (now - lastFrameTime >= timePerFrame) {
                gamePanel.repaint();
                lastFrameTime = now;
            }
        }
    }
}
