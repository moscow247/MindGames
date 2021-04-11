package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.game.GameStateManager;

public abstract class State {

    protected GameStateManager gms;


    public  State(GameStateManager gms){
        this.gms = gms;
    }

    protected abstract void handleInput();

    public abstract void update(float dt);

    public abstract void render(SpriteBatch sb);

    public abstract void dispose();

}
