package com.mygdx.game.states.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Mindgames;
import com.mygdx.game.states.State;

public class GameWait extends State {
    private int room;
    private Texture backgroundProfiles;

    public GameWait(GameStateManager gms, int room) {
        super(gms);
        this.room = room;
        backgroundProfiles = new Texture("backgroundsAndOther/BackgroundProfiles.png");

    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backgroundProfiles, 0, 0, Mindgames.width, Mindgames.height);
        sb.end();
        gms.set(new GameState(gms, room));

    }

    @Override
    public void dispose() {

    }
}
