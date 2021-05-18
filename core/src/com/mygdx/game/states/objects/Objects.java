package com.mygdx.game.states.objects;

import com.mygdx.game.Mindgames;

public class Objects {
    private String name;
    private int curX1,curY1,
            curX2,curY2;
    //    private Texture img;
    private String[][]whatIn;

    public Objects(int curX1, int curY1, int curX2, int curY2, String[][] whatIn) {
        this.curX1 = curX1;
        this.curY1 = curY1;
        this.curX2 = curX2;
        this.curY2 = curY2;
        //        this.img = img;
        this.whatIn = whatIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String[][] getWhatIn() {
        return whatIn;
    }

    public void setWhatIn(String[][] whatIn) {
        this.whatIn = whatIn;
    }

    public boolean isNear( People person, int nearly){
        return (Mindgames.height-person.getCurY()) < curY1 + nearly && (Mindgames.height-person.getCurY()) > curY2 - nearly
                && person.getCurX() > curX1 - nearly && person.getCurX() < curX2 + nearly;
    }
    public boolean isHere(int x, int y){
        return x<curX2 && x> curX1 && y< curY1 && y> curY2;
    }


}