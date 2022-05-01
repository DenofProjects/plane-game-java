package com.pd.game;

import com.pd.controllers.KeyBoardEvents;

import javax.swing.*;
import java.awt.*;

import static com.pd.constants.Constants.*;

public class GamePanel extends JPanel {

    private GamePanelActions gamePanelActions = new GamePanelActions();

    public GamePanelActions getGamePanelActions() {
        return gamePanelActions;
    }

    public GamePanel() {
        addKeyListener(new KeyBoardEvents(this));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getPlane(g);
        repaint();
    }

    private void getPlane(Graphics graphics){
        graphics.drawRect(gamePanelActions.getxDirPlane(), gamePanelActions.getyDirPlane(), RECT_WIDTH, RECT_HEIGHT);
    }

    public void getBullet(Graphics graphics){
        graphics.drawRect(gamePanelActions.getxDirBullet(), gamePanelActions.getyDirBullet(), BULLET_RECT_WIDTH, BULLET_RECT_HEIGHT);
    }

}
