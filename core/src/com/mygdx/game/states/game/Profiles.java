package com.mygdx.game.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.StartMenuState;
import com.mygdx.game.states.State;
import com.mygdx.game.states.game.GameStateManager;
import com.mygdx.game.states.graphics.lvl;

public class Profiles extends State {

    public static Texture backgroundProfiles, back;

    public Profiles(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("Profiles");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            int x =Gdx.input.getX();
            int y = Gdx.input.getY();
            if(x<100 && y<100){
                    gms.set(new StartMenuState(gms));
                }
            }

    }

    @Override
    public void dispose() {
        backgroundProfiles.dispose();
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundProfiles, 0, 0, Mindgames.width, Mindgames.height);
        sb.end();
//        gms.set(new GameState(gms, 1));

    }


}
