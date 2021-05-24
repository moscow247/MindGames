package com.mygdx.game.states.graphics;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.game.GameStateManager;
import com.mygdx.game.states.StartMenuState;
import com.mygdx.game.states.State;


public class StartAnimation  extends State {
    public static Texture logo;
    private float timer = 3f;


    public StartAnimation(GameStateManager gms) {
        super(gms);
        logo = new Texture("backgroundsAndOther/logo.png");
        Mindgames.isPlaying = false;
    }

    @Override
    protected void handleInput()  {
        gms.push(new StartMenuState(gms));
    }

    @Override
    public void update(float dt) {
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(logo, 0, 0, Mindgames.width, Mindgames.height);
        sb.end();

        timer-= Gdx.graphics.getRawDeltaTime();
        if(timer <= 0) gms.push(new StartMenuState(gms));
    }

    @Override
    public void dispose() {
        logo.dispose();
    }

}