package com.mygdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.graphics.lvl;
//import com.sun.xml.internal.ws.handler.HandlerException;

public class StartMenuState extends State {

    public static Texture background, playButton, buttonProfiles, title;

    public StartMenuState(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("StartMenuState");
    }

    @Override
    protected void handleInput() {
            Gdx.input.setInputProcessor(new InputAdapter() {
                public boolean touchDown(int x,int y,int pointer,int button) {
                    if(x<(4*(Mindgames.width /6) + playButton.getHeight()) && x>(3 * (Mindgames.width / 4) - playButton.getWidth()) ) {
                        if(y<(Mindgames.height/2 + playButton.getHeight()/2) && y>(Mindgames.height/2-playButton.getHeight()/2)){
                            gms.set(new GameState(gms, 1));
                        }
                    }

                    if(x<(47*Mindgames.width /60 + buttonProfiles.getWidth()/2) && x>(47*Mindgames.width /60 - buttonProfiles.getWidth()/2)){
                         if(y < (3 * (Mindgames.height /16) + buttonProfiles.getHeight()/2) && y> (3 * (Mindgames.height /16) - buttonProfiles.getHeight()/2 )){
                            gms.set(new Profiles(gms));
                        }
                    }
                    return false;
                }
            });

    }

//



    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Mindgames.width, Mindgames.height);
        sb.draw(playButton, 4*(Mindgames.width /6) - (playButton.getWidth() /2), (Mindgames.height /2) - (playButton.getHeight() /2));
        sb.draw(buttonProfiles, 47*(Mindgames.width /60) - (buttonProfiles.getWidth() /2), 13 * (Mindgames.height /16) - (buttonProfiles.getHeight() /2));
        sb.draw(title, Mindgames.width/40, 15*Mindgames.height/20);
        sb.end();
    }

    @Override
    public void dispose() {
        title.dispose();
        buttonProfiles.dispose();
        background.dispose();
        playButton.dispose();

    }
}