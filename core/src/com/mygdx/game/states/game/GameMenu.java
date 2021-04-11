package com.mygdx.game.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.StartMenuState;
import com.mygdx.game.states.State;
import com.mygdx.game.states.graphics.lvl;

import java.util.HashMap;
import java.util.Map;

public class GameMenu extends State {
    public static Texture background, buttonFirstLvl;
    protected static String[] namesAndNumbers = new String[]{"GameStateOne", "GameStateTwo", "GameStateThree"};


    public GameMenu(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("GameMenuState");
    }

    protected void whatIsRoom(){
    }

    @Override
    protected void handleInput()
    {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean touchDown(int x,int y,int pointer,int button) {

                if(x>(float) (Mindgames.width*0.13) && x<(float) (Mindgames.width*0.1931) && y>(float) (Mindgames.height*0.42) && y<(float) (Mindgames.height*0.55)){
                    gms.push(new GameState(gms, 0));
                }else if(y< (Mindgames.height*0.3) && x<(Mindgames.width*0.05)){
                    gms.set(new StartMenuState(gms));
                }else if(x>(float) (Mindgames.width*0.33) && x<(float) (Mindgames.width*0.3931) && y>(float) (Mindgames.height*0.42) && y<(float) (Mindgames.height*0.55)){
                    gms.push(new GameState(gms, 1));
                }
                return false;
            }
        });
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Mindgames.width, Mindgames.height );
        sb.draw(buttonFirstLvl, (float) (Mindgames.width*0.13), (float) (Mindgames.height*0.42));
        sb.draw(buttonFirstLvl, (float) (Mindgames.width*0.33), (float) (Mindgames.height*0.42));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        buttonFirstLvl.dispose();
    }
}