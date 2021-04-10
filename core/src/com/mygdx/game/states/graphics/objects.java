package com.mygdx.game.states.graphics;

import com.badlogic.gdx.graphics.Texture;

public class objects {

    private int curX1,curY1,
            curX2,curY2;
    private Texture img;
    private String[][] whatIn;


    public int getCurX1() {
        return curX1;
    }

    public void setCurX1(int curX1) {
        this.curX1 = curX1;
    }

    public int getCurY1() {
        return curY1;
    }

    public void setCurY1(int curY1) {
        this.curY1 = curY1;
    }

    public int getCurX2() {
        return curX2;
    }

    public void setCurX2(int curX2) {
        this.curX2 = curX2;
    }

    public int getCurY2() {
        return curY2;
    }

    public void setCurY2(int curY2) {
        this.curY2 = curY2;
    }

    public Texture getImg() {
        return img;
    }

    public void setImg(Texture img) {
        this.img = img;
    }

    public String[][] getWhatIn() {
        return whatIn;
    }

    public void setWhatIn(String[][] whatIn) {
        this.whatIn = whatIn;
    }
}
