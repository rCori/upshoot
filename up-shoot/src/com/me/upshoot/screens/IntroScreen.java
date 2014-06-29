package com.me.upshoot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.me.upshoot.UpShoot;
import com.me.upshoot.view.WorldRenderer;

public class IntroScreen implements Screen {
	
	//Grab Preferences so we can see the last score
	Preferences prefs = Gdx.app.getPreferences("upShootPrefs");
	
	UpShoot upShoot;
	
	private SpriteBatch batch;
	private BitmapFont font;
	private int lastscore;
	private int highScore;
	private int width;
	private int height;
	private Vector3 temp;
	private OrthographicCamera tempCam;
	
	public IntroScreen(UpShoot upShoot){
		this.upShoot = upShoot;
		/*
		 * Gdx.graphics.getWidth()/getHeight() get width and height
		 * of the device in terms of it's resolution, not world space
		width = Gdx.graphics.getWidth();
		Gdx.app.log("upshoot", "Width is: " + width);
		height = Gdx.graphics.getHeight();
		Gdx.app.log("upshoot", "Height is: " + height);
		*/
		
		tempCam = new OrthographicCamera(480,640);
		tempCam.setToOrtho(false,480,640);
		tempCam.update();
		
		int width = 50;
		int height = 600;
		temp = new Vector3(width,height,0);
		tempCam.project(temp);
		Gdx.app.log("upshoot","temp.x is" + temp.x);
		Gdx.app.log("upshoot","temp.x is" + temp.x);
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.scale(2f);
		
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		font.draw(batch, "Your best score is "+ highScore, temp.x, temp.y);
		font.draw(batch, "Last Score was " + lastscore, temp.x, temp.y-100);
		font.draw(batch, "Tap screen to start", temp.x, temp.y-200);
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
		lastscore = prefs.getInteger("lastscore");
		highScore = prefs.getInteger("highScore");
		
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
