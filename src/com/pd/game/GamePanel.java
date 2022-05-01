package com.pd.game;

import com.pd.controllers.KeyBoardEvents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

import static com.pd.constants.Constants.*;

public class GamePanel extends JPanel {

    private final java.util.List<Bullet> bulletList = new ArrayList<>();

    public GamePanel() {
        addKeyListener(new KeyBoardEvents(this));
    }

    private GamePanelActions gamePanelActions = new GamePanelActions();

    public GamePanelActions getGamePanelActions() {
        return gamePanelActions;
    }

    public void createBullet() {
        bulletList.add(new Bullet());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.getPlane(g);
        this.processBullet(g);
    }

    private void getPlane(Graphics graphics) {
        graphics.fillRect(gamePanelActions.getxDirPlane(), gamePanelActions.getyDirPlane(), RECT_WIDTH, RECT_HEIGHT);
    }

    private void processBullet(Graphics g) {
        ListIterator<Bullet> ltr = bulletList.listIterator();
        while (ltr.hasNext()) {
            Bullet bullet = ltr.next();
            bullet.draw(g);
            bullet.updateBullet();
            if (bullet.getyDirBullet() < 10) {
                ltr.remove();
            }
        }
    }

}
