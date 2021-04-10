package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.graphics.go.Go;
import com.mygdx.game.states.graphics.lvl;

import static com.mygdx.game.states.StartMenuState.buttonProfiles;
import static com.mygdx.game.states.StartMenuState.playButton;

public class GameMenuState extends State {
    public static Texture background, buttonFirstLvl;


    public GameMenuState(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("GameMenuState");
    }

    @Override
    protected void handleInput()
    {
        Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean touchDown(int x,int y,int pointer,int button) {

                if(x>300 && x<450 && y>450 && y<600){
                    gms.push(new GameState(gms, 1));
                }else if(y> (Mindgames.height*0.9) && x<(Mindgames.width*0.022)){
                    gms.set(new StartMenuState(gms));
                }
                return false;
            }
        });
    }


    @Override
    public void dispose() {
        background.dispose();
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Mindgames.width, Mindgames.height );
        sb.draw(buttonFirstLvl, 300, 450);
        sb.end();
    }
}