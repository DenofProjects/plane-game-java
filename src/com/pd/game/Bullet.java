package com.pd.game;

import java.awt.*;

import static com.pd.constants.Constants.*;

public class Bullet {

    private int xDirBullet;

    private int yDirBullet = GAME_WINDOW_HEIGHT - 2 * RECT_HEIGHT;

    public Bullet(int xDirPlane) {
        this.xDirBullet = (2 * xDirPlane + RECT_WIDTH - BULLET_RECT_WIDTH) / 2;
    }


    public int getyDirBullet() {
        return this.yDirBullet;
    }

    public void updateBullet() {
        yDirBullet += -1;
    }

    public void draw(Graphics graphics) {
//        System.out.println("x dir bullet : " + xDirBullet);
        graphics.fillRect(xDirBullet, yDirBullet, BULLET_RECT_WIDTH, BULLET_RECT_HEIGHT);
    }
}
