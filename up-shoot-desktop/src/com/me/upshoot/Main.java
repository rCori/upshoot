package com.me.upshoot;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "up-shoot";
		cfg.width = 480;
		cfg.height = 640;
		
		new LwjglApplication(new UpShoot(), cfg);
	}
}
