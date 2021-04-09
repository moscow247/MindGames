package com.mygdx.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public abstract class State {

    protected GameStateManager gms;


    public  State(GameStateManager gms){
        this.gms = gms;
    }



    protected abstract void handleInput();

    public abstract void dispose();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

    ;
}
