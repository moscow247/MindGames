package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.graphics.go.Go;
import com.mygdx.game.states.graphics.lvl;


public class GameState extends State {
    public static Texture img;
    public static Texture backgroundRoom;
    private int numberOfRoom;
//    private int currentX=100;
//    private int currentY =100;

    public GameState(GameStateManager gms, int numberOfRoom) {
        super(gms);
        this.numberOfRoom = numberOfRoom;
        lvl.whatsAboutGraphic("GameState");
    }

    @Override
    protected void handleInput() {
                Gdx.input.setInputProcessor(new InputAdapter() {
            public boolean touchDown(int x,int y,int pointer,int button) {

                if (x > Mindgames.width / 4 && x < Mindgames.width /2) {
                    Go.letsgo(50, 0, numberOfRoom);
                }else if(x < Mindgames.width / 4  && !((y>(int) (Mindgames.height*0.12)) && (x<(Mindgames.width*0.0214592275)))){
                    Go.letsgo(-50, 0, numberOfRoom);
                }else if(y> Mindgames.height/2&& x>Mindgames.width/2){
                    Go.letsgo(0, -50, numberOfRoom);
                }else if(y<Mindgames.height/2 && x>Mindgames.width/2) {
                    Go.letsgo(0, 50, numberOfRoom);
                }else if(y> (Mindgames.height*0.9) && x<(Mindgames.width*0.022)){
                    gms.set(new GameMenuState(gms));
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
        sb.draw(img, Go.currentX, Go.currentY, Mindgames.width/10, Mindgames.height/7);
        sb.end();

    }

    @Override
    public void dispose () {
        img.dispose();
        backgroundRoom.dispose();
    }
}
