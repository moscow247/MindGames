package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.states.game.GameStateManager;
import com.mygdx.game.states.graphics.StartAnimation;


public class Mindgames extends ApplicationAdapter {
	public static int width;
	public static int height;
	public static int wereHere=0;
	public static int isMusic = 0;
	public static final String title = "Mind games";
	public static Preferences prefs;
	public static boolean isPlaying = false;


	private GameStateManager gms;
	private SpriteBatch batch;





	@Override
	public void create () {
		prefs = Gdx.app.getPreferences("My Preferences");
		prefs.putInteger("music", 1);
		prefs.flush();
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
