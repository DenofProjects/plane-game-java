package com.pd.game;

import java.awt.*;

import static com.pd.constants.Constants.*;

public class EnemyPlane {
    private final int MAX = 435;
    private final int MIN = 1;

    private final double xDirEnemyPlane = Math.random() * (MAX - MIN) + MIN;
    private double yDirEnemyPlane = Math.random() * (-10000);

    public int getYDirEnemyPlane() {
        return (int) yDirEnemyPlane;
    }

    public void draw(Graphics graphics) {
        graphics.fillRect((int) xDirEnemyPlane, (int) yDirEnemyPlane, RECT_WIDTH, RECT_HEIGHT);
    }

    public void udpate() {
        yDirEnemyPlane += 1;
    }
}
