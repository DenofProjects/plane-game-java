package com.pd.game;

import static com.pd.constants.Constants.*;

public class GamePanelActions {
    private int xDirPlane = 0;
    private final int yDirPlane = GAME_WINDOW_HEIGHT - 2 * RECT_HEIGHT;

    private int xDirBullet = RECT_HEIGHT;

    private int yDirBullet = RECT_WIDTH/2;

    public int getxDirBullet() {
        return xDirBullet;
    }

    public int getyDirBullet() {
        return yDirBullet;
    }

    public int getxDirPlane() {
        return xDirPlane;
    }

    public int getyDirPlane() {
        return yDirPlane;
    }

    public void changeDirX(int x){
        this.xDirPlane += x;
        if(this.xDirPlane < 0){
            xDirPlane = 0;
        }
        if(xDirPlane > 435){
            xDirPlane = 435;
        }
        System.out.println("x dir is : " + xDirPlane);
    }

    public void moveBullet(int x){

    }
}
