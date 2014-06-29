package com.me.upshoot;

import com.me.upshoot.screens.IntroScreen;
import com.me.upshoot.screens.PlayScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class UpShoot extends Game {
	
	public IntroScreen introScreen;
	public PlayScreen playScreen;
	private Preferences prefs;
	
	@Override
	public void create() {
		//Erase the previous last score
		/*We don't want it to show a score
		 * from the last time the app was turned on
		 */
		prefs = Gdx.app.getPreferences("upShootPrefs");
		prefs.putInteger("lastscore",0);
		prefs.flush();
		introScreen = new IntroScreen(this);
		playScreen = new PlayScreen(this);
		setScreen(introScreen);
		
	}
	
}
