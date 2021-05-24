package com.mygdx.game.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.StartMenuState;
import com.mygdx.game.states.State;
import com.mygdx.game.states.graphics.lvl;

import static com.mygdx.game.Mindgames.prefs;

public class Settings extends State {
    public static Texture background, sound, notSound, back;


    public Settings(GameStateManager gms) {
        super(gms);
        lvl.whatsAboutGraphic("Settings");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            int x =Gdx.input.getX();
            int y = Gdx.input.getY();
            if(x >(Mindgames.width/4) &&
                    x <(Mindgames.width/4+((float) (Mindgames.width*0.098118))) &&
                            y > (float) (1.85*Mindgames.height/5)&&
                    y < (float) (1.85*Mindgames.height/5)+((float) (Mindgames.height*0.18518))){
                prefs.putInteger("music", Math.abs(prefs.getInteger("music", 0)-1));
                prefs.flush();
                if (prefs.getInteger("music", 1)==1 && !StartMenuState.isPlaying) {
                    StartMenuState.music.play();
                    StartMenuState.isPlaying = true;
                }else{
                    StartMenuState.music.pause();
                    StartMenuState.isPlaying = false;
                }
            }
            if(x<100 && y<100){
                gms.set(new StartMenuState(gms));
            }
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, Mindgames.width, Mindgames.height);
        sb.draw(back, 0, Mindgames.height-100, 100, 100);
        if(prefs.getInteger("music", 1)==1){
            sb.draw(notSound, Mindgames.width/4, (float) (1.85*Mindgames.height/5), (float) (Mindgames.width*0.098118), (float) (Mindgames.height*0.18518));
        }else{
            sb.draw(sound, Mindgames.width/4, (float) (1.85*Mindgames.height/5), (float) (Mindgames.width*0.098118), (float) (Mindgames.height*0.18518));
        }
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        sound.dispose();
        notSound.dispose();
        back.dispose();
    }
}
