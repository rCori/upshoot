package com.me.upshoot.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.me.upshoot.models.Player;
import com.me.upshoot.models.World;

public class WorldRenderer {

	private static final float CAMERA_HEIGHT = 800f;
	private static final float CAMERA_WIDTH = 480f;
	
	private World world;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private Player player;
	
	
	public WorldRenderer(World world, Player player){
		this.shapeRenderer = new ShapeRenderer();
		this.world = world;
		this.player = player;
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false,CAMERA_WIDTH,CAMERA_HEIGHT);
		this.cam.update();
	}
	
	
	public void drawPlayer(){
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.begin(ShapeType.FilledCircle);
		shapeRenderer.filledCircle(player.getPosition().x, player.getPosition().y, player.getRadius());
		shapeRenderer.end();
	}
	
	public void render(){
		//drawPlayerCircle();
		drawPlayer();
	}
	
	public void setSize(int width, int height){
		//Umm, like nothin
	}
	
	
	
}
