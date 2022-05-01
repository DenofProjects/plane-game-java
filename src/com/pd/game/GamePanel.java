package com.pd.game;

import com.pd.controllers.KeyBoardEvents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

import static com.pd.constants.Constants.*;

public class GamePanel extends JPanel implements Runnable {

    private final java.util.List<Bullet> bulletList = new ArrayList<>();

    private final java.util.List<EnemyPlane> enemyPlanes = new ArrayList<>();
    Thread enemyPlaneThread;

    private boolean collided = false;

    int yBullet, yEnemy;

    public GamePanel() {
        addKeyListener(new KeyBoardEvents(this));
        enemyPlaneThread = new Thread(this);
        enemyPlaneThread.start();
    }

    private final GamePanelActions gamePanelActions = new GamePanelActions();

    public GamePanelActions getGamePanelActions() {
        return gamePanelActions;
    }

    public void createBullet() {
        bulletList.add(new Bullet(gamePanelActions.getxDirPlane()));
    }

    public void paintComponent(Graphics g) {
        enemyPlaneThread.stop();
        super.paintComponent(g);
        if (yEnemy == yBullet) {
            collided = true;
        }
        this.getPlane(g);
        this.processBullet(g);
        this.processEnemyPlane(g);
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
            yBullet = bullet.getyDirBullet();
            if (bullet.getyDirBullet() < 10) {
                ltr.remove();
            } else if (collided) {
                ltr.remove();
            }
        }
    }

    private void processEnemyPlane(Graphics g) {
        ListIterator<EnemyPlane> ltr = enemyPlanes.listIterator();
        while (ltr.hasNext()) {
            EnemyPlane enemyPlane = ltr.next();
            enemyPlane.draw(g);
            enemyPlane.udpate();
            yEnemy = enemyPlane.getYDirEnemyPlane();
            if (enemyPlane.getYDirEnemyPlane() >= 435) {
                ltr.remove();
            } else if (collided) {
                ltr.remove();
                collided = false;
            }
        }
    }

    @Override
    public void run() {
        int n = 100;
        while (n-- > 0) {
            enemyPlanes.add(new EnemyPlane());
            System.out.println("size is : " + enemyPlanes.size());
        }
    }
}
