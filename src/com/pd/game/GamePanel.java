package com.pd.game;

import com.pd.controllers.KeyBoardEvents;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.pd.constants.Constants.*;

public class GamePanel extends JPanel implements Runnable {

    private java.util.List<Bullet> bulletList = new ArrayList<>();

    private final java.util.List<EnemyPlane> enemyPlanes = new ArrayList<>();
    Thread enemyPlaneThread;

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
            if (bullet.getyDirBullet() < 10) {
                ltr.remove();
            }
        }
    }

    private void processEnemyPlane(Graphics g) {
        ListIterator<EnemyPlane> ltr = enemyPlanes.listIterator();
        while (ltr.hasNext()) {
            EnemyPlane enemyPlane = ltr.next();
            enemyPlane.draw(g);
            ListIterator<Bullet> bulletListIterator = bulletList.listIterator();
            while (bulletListIterator.hasNext()) {
                Bullet bullet = bulletListIterator.next();
                if (this.bulletCollision(bullet, enemyPlane) && (enemyPlane.getxDirEnemyPlane() <= bullet.getxDirBullet() && (enemyPlane.getxDirEnemyPlane() + RECT_WIDTH) >= bullet.getxDirBullet())) {
                    ltr.remove();
                    bulletListIterator.remove();
                }
            }
            enemyPlane.udpate();

            if (enemyPlane.getYDirEnemyPlane() >= 435) {
                ltr.remove();
            }
        }
    }

    private boolean bulletCollision(Bullet bullet, EnemyPlane enemyPlane) {
        return (bullet.getyDirBullet() > enemyPlane.getYDirEnemyPlane() + BULLET_COLLISION_BUFFER) && (bullet.getyDirBullet() <= enemyPlane.getYDirEnemyPlane() + RECT_HEIGHT);
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
