package com.me.upshoot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.me.upshoot.models.World;
import com.me.upshoot.view.WorldRenderer;

public class PlayScreen implements Screen {

	private WorldRenderer renderer;
	private World world;
	private Controls controls;
	
	private int width, height;
	
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		renderer.setSize(width,height);
		//Retain new width and height
		this.width = width;
		this.height = height;
	}

	
	//Initializations get done here
	@Override
	public void show() {
		world = new World();
		controls = new Controls(world);
		//Register our controls object as our input processor
		Gdx.input.setInputProcessor(controls);
		demoWorld();
		renderer = new WorldRenderer(world);
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		
	}
	
	public void demoWorld(){
		world.setPlayerCircle(100,100,100);
	}

}
