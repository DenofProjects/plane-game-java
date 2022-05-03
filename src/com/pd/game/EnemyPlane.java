package com.pd.game;

import java.awt.*;

import static com.pd.constants.Constants.*;

public class EnemyPlane {
    private final int MAX = 435;
    private final int MIN = 1;

    private final int xDirEnemyPlane = (int)(Math.random() * (MAX - MIN) + MIN);
    private int yDirEnemyPlane = (int)(Math.random() * (-50000));

    public int getYDirEnemyPlane() {
        return  yDirEnemyPlane;
    }

    public int getxDirEnemyPlane() {
        return  xDirEnemyPlane;
    }

    public void draw(Graphics graphics) {
        graphics.fillRect(xDirEnemyPlane,  yDirEnemyPlane, RECT_WIDTH, RECT_HEIGHT);
    }

    public void udpate() {
        System.out.println("y enemy : " + yDirEnemyPlane);
        yDirEnemyPlane += 1;
    }
}
