package com.tadasoftware.agroinvestidor.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tadasoftware.agroinvestidor.Agroinvestidor;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1360;
		config.height = 760;
		new LwjglApplication(new Agroinvestidor(), config);
	}
}
