package com.me.upshoot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.me.upshoot.UpShoot;

public class IntroScreen implements Screen {
	
	UpShoot upShoot;
	
	private SpriteBatch batch;
	private BitmapFont font;
	
	
	public IntroScreen(UpShoot upShoot){
		this.upShoot = upShoot;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch = new SpriteBatch();
		font = new BitmapFont();
		batch.begin();
		font.draw(batch, "Tap screen to start", 400, 400);
		batch.end();
		if(Gdx.input.justTouched()){
			upShoot.setScreen(upShoot.playScreen);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
