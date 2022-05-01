package com.pd.game;

import com.pd.controllers.KeyBoardEvents;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private int xDir = 0;
    private int yDir = 0;

    public GamePanel() {
        addKeyListener(new KeyBoardEvents());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawRect(100, 100, 100, 50);
    }

}
