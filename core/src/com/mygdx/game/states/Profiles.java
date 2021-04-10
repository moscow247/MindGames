package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.game.GameStateManager;

public class Profiles extends State{

    private Texture backgroundProfiles;

    public Profiles(GameStateManager gms) {
        super(gms);
        backgroundProfiles = new Texture("backgroundsAndOther/backgroundProfiles.png");
    }

    @Override
    protected void handleInput() {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean touchDown(int x,int y,int pointer,int button) {

                if (x > Mindgames.width / 4 && x < Mindgames.width /2) {
                    gms.set(new StartMenuState(gms));
                }
                return false;
            }
        });

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
    }
}
