package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.Mindgames;

import javax.xml.bind.annotation.XmlInlineBinaryData;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Mindgames.width;
		config.height = Mindgames.height;
		config.title = Mindgames.title;
		new LwjglApplication(new Mindgames(), config);
	}
}
