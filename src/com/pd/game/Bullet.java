package com.pd.game;

import java.awt.*;

import static com.pd.constants.Constants.*;

public class Bullet {
    private int xDirBullet = RECT_WIDTH / 2;

    private int yDirBullet = GAME_WINDOW_HEIGHT - 3 * RECT_HEIGHT;

    public Bullet() {

    }

    public int getyDirBullet(){
        return this.yDirBullet;
    }

    public void updateBullet() {
        yDirBullet += -1;
    }

    public void draw(Graphics graphics) {
        graphics.fillRect(xDirBullet, yDirBullet, BULLET_RECT_WIDTH, BULLET_RECT_HEIGHT);
    }
}
