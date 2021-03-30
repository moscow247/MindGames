package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameScreen;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.State;
//import com.sun.xml.internal.ws.handler.HandlerException;

public class MenuState extends State {

    private Texture background;
    private Texture playButton;

    public MenuState(GameStateManager gms) {
        super(gms);
        background = new Texture("backgroundsAndOther/backgroundMain.jpg");
        playButton = new Texture("backgroundsAndOther/star.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            gms.set(new GameScreen(gms));
        }
    }



    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Mindgames.width, Mindgames.height);
        sb.draw(playButton, (Mindgames.width /2 ) - (playButton.getWidth() /2), (Mindgames.height /2) - (playButton.getHeight() /2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playButton.dispose();
    }
}