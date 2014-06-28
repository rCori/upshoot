package com.me.upshoot.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import com.me.upshoot.UpShoot;
import com.me.upshoot.models.Player;
import com.me.upshoot.models.World;
import com.me.upshoot.view.WorldRenderer;

public class PlayScreen implements Screen {

	UpShoot upShoot;
	
	private WorldRenderer renderer;
	private World world;
	private Controls controls;
	private Player player;
	
	private int width, height;
	
	
	public PlayScreen(UpShoot upShoot){
		this.upShoot = upShoot;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		player.update(delta);
		world.update(delta);
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
		player = new Player(new Vector2(100f,100f));
		world = new World(player,upShoot);
		controls = new Controls(world, player);
		//Register our controls object as our input processor
		Gdx.input.setInputProcessor(controls);
		renderer = new WorldRenderer(world, player);
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
	

}
