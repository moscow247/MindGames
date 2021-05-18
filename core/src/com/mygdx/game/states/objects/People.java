package com.mygdx.game.states.objects;

import com.badlogic.gdx.graphics.Texture;

public class People {
    private int curX;
    private int curY;
    private int speed;
    private Texture img;
    private boolean isBusy;

    public People(int curX, int curY, int speed, Texture img, boolean isBusy) {
        this.curX = curX;
        this.curY = curY;
        this.speed = speed;
        this.img = img;
        this.isBusy = isBusy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void setCurX(int curX) {
        this.curX = curX;
    }

    public void setCurY(int curY) {
        this.curY = curY;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public int getCurX() {
        return curX;
    }

    public int getCurY() {
        return curY;
    }

    public Texture getImg() {
        return img;
    }


}