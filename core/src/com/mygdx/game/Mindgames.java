package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.game.GameStateManager;
import com.mygdx.game.states.graphics.StartAnimation;

public class Mindgames extends ApplicationAdapter {
	public static int width = 2057;
	public static int height = 1080;
	public static int wereHere=0;
	public static final String title = "Mind games";


	private GameStateManager gms;
	private SpriteBatch batch;




	@Override
	public void create () {
		Mindgames.width = Gdx.app.getGraphics().getWidth();
		Mindgames.height =  Gdx.app.getGraphics().getHeight();
		batch = new SpriteBatch();
		gms = new GameStateManager();

		Gdx.gl.glClearColor(.5f, .7f, .9f, 1);

		gms.push(new StartAnimation(gms));
//		gms.push(new StartMenuState(gms));

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		gms.update(Gdx.graphics.getDeltaTime());
		gms.render(batch);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
