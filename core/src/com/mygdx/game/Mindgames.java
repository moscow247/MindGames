package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.StartMenuState;

public class Mindgames extends ApplicationAdapter {
	public static final int width = 2330;
	public static final int height = 1080;
	public static final String title = "Mind games";


	private GameStateManager gms;
	private SpriteBatch batch;




	@Override
	public void create () {

		batch = new SpriteBatch();
		gms = new GameStateManager();

		Gdx.gl.glClearColor(.5f, .7f, .9f, 1);

		gms.push(new StartMenuState(gms));
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		gms.update(Gdx.graphics.getDeltaTime());
		gms.render(batch);
	}

	@Override
	public void dispose () {

	}
}
