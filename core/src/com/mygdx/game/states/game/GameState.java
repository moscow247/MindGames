package com.mygdx.game.states.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.People;
import com.mygdx.game.states.State;
import com.mygdx.game.states.graphics.go.Go;
import com.mygdx.game.states.graphics.lvl;


public class GameState extends State {
    public static Texture texture;
    private People me = new People();
    public static Texture backgroundRoom;
    private int numberOfRoom;



    public GameState(GameStateManager gms, int numberOfRoom) {
        super(gms);
        this.numberOfRoom = numberOfRoom;
        lvl.whatsAboutGraphic("GameState");
        me.setImg(texture);
        me.setCurX((int)(Mindgames.width*0.2));
        me.setCurY(Mindgames.height/2);
        me.setSpeed(75);
    }


    public boolean touchUp (int x, int y, int pointer, int button) {
        return true;
    }

    @Override
    protected void handleInput() {
        Gdx.input.setInputProcessor(new InputAdapter() {

            public boolean touchDown(int x,int y,int pointer,int button) {
                    if (x > Mindgames.width / 4 && x < Mindgames.width / 2) {
                        Go.letsgo(me.getSpeed(), 0, numberOfRoom, me);
                    } else if (x < Mindgames.width / 4 && !((y > (int) (Mindgames.height * 0.12)) && (x < (Mindgames.width * 0.0214592275)))) {
                        Go.letsgo(-1 * me.getSpeed(), 0, numberOfRoom, me);
                    } else if (y > Mindgames.height / 2 && x > Mindgames.width / 2) {
                        Go.letsgo(0, -1 * me.getSpeed(), numberOfRoom, me);
                    } else if (y < Mindgames.height / 2 && x > Mindgames.width / 2) {
                        Go.letsgo(0, me.getSpeed(), numberOfRoom, me);
                    } else if (y > (Mindgames.height * 0.9) && x < (Mindgames.width * 0.022)) {
                        gms.set(new GameMenu(gms));
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
        sb.draw(backgroundRoom, 0, 0, Mindgames.width, Mindgames.height);
        sb.draw(texture, me.getCurX(), me.getCurY(), Mindgames.width/10, Mindgames.height/7);
        sb.end();

    }

    @Override
    public void dispose () {
        texture.dispose();
        backgroundRoom.dispose();
    }
}
