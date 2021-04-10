package com.mygdx.game.states;

import com.badlogic.gdx.graphics.Texture;

public class People {
    protected int curX, curY;
    protected Texture img;
    protected boolean isBusy;


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