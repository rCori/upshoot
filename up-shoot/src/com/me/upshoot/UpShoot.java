package com.me.upshoot;

import com.me.upshoot.screens.IntroScreen;
import com.me.upshoot.screens.PlayScreen;
import com.badlogic.gdx.Game;

public class UpShoot extends Game {
	
	public IntroScreen introScreen;
	public PlayScreen playScreen;
	
	@Override
	public void create() {
		introScreen = new IntroScreen(this);
		playScreen = new PlayScreen(this);
		setScreen(introScreen);
		
	}
	
}
