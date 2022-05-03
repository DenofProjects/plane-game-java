package com.pd.game;

import static com.pd.constants.Constants.*;

public class GamePanelActions {
    private int xDirPlane = 0;
    private final int yDirPlane = GAME_WINDOW_HEIGHT - 2 * RECT_HEIGHT;

    public int getxDirPlane() {
        return xDirPlane;
    }

    public int getyDirPlane() {
        return yDirPlane;
    }

    public void changeDirX(int x) {
        this.xDirPlane += x;
        if (this.xDirPlane < 0) {
            xDirPlane = 0;
        }
        if (xDirPlane > 435) {
            xDirPlane = 435;
        }
        System.out.println("x dir is : " + xDirPlane);
    }

}
