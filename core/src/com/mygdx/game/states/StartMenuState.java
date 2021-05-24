package com.mygdx.game.states;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.game.GameMenu;
import com.mygdx.game.states.game.GameStateManager;
import com.mygdx.game.states.game.Settings;
import com.mygdx.game.states.graphics.lvl;
import com.mygdx.game.states.game.Profiles;

import static com.mygdx.game.Mindgames.prefs;
//import com.sun.xml.internal.ws.handler.HandlerException;

public class StartMenuState extends State {
    public static Music music;
    public static Texture background, playButton, buttonProfiles, title, buttonSettings;

    {
        music = Gdx.audio.newMusic(Gdx.files.internal("music/music.mp3"));
        playMusic();
    }

    public StartMenuState(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("StartMenuState");

    }

    @Override
    protected void handleInput() {
        if (Gdx.input.isTouched()) {
            int x =Gdx.input.getX();
            int y = Gdx.input.getY();
                    if(x<(4*(Mindgames.width /6) + playButton.getHeight()) && x>(3 * (Mindgames.width / 4) - playButton.getWidth()) ) {
                        if (y < (Mindgames.height / 2 + playButton.getHeight() / 2) && y > (Mindgames.height / 2 - playButton.getHeight() / 2)) {
                            gms.set(new GameMenu(gms));
                        }
                    }
                    if(x<(40*Mindgames.width /60 + buttonProfiles.getWidth()/2) && x>(40*Mindgames.width /60 - buttonProfiles.getWidth()/2)){
                         if(y < (4.5 * (Mindgames.height /16) + buttonProfiles.getHeight()/2) && y> (4.5 * (Mindgames.height /16) - buttonProfiles.getHeight()/2 )){
                            gms.set(new Profiles(gms));
                        }
                    }
                    if(x<(37*Mindgames.width /60 + buttonProfiles.getWidth()/2) && x>(39*Mindgames.width /60 - buttonProfiles.getWidth()/2)){
                        if(y < (15 * (Mindgames.height /20) + buttonProfiles.getHeight()/2) && y> (15 * (Mindgames.height /20) - buttonProfiles.getHeight()/2 )){
                            gms.set(new Settings(gms));
                        }
                    }
                    if(y> (Mindgames.height*0.8) && x<(Mindgames.width*0.05)){
                        Gdx.app.exit();
                    }

                }


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
        sb.draw(buttonProfiles, 45*(Mindgames.width /60) - (buttonProfiles.getWidth() /2), 12 * (Mindgames.height /16) - (buttonProfiles.getHeight() /2));
        sb.draw(buttonSettings, 35*(Mindgames.width /60) - (buttonProfiles.getWidth() /2), 5 * (Mindgames.height /20) - (buttonProfiles.getHeight() /2));
        sb.draw(title, Mindgames.width/40, 15*Mindgames.height/20);
        sb.end();
    }

    @Override
    public void dispose() {
        title.dispose();
        buttonProfiles.dispose();
        background.dispose();
        playButton.dispose();
        if(!music.isPlaying()){
            music.dispose();
        }
    }

    public static void playMusic() {
        if (prefs.getInteger("music", 1)==1 && !Mindgames.isPlaying) {
            StartMenuState.music.play();
            Mindgames.isPlaying = true;
        }else{
            StartMenuState.music.stop();
            Mindgames.isPlaying = false;
        }
    }
}