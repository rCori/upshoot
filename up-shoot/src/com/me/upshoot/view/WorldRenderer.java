package com.me.upshoot.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.me.upshoot.models.Block;
import com.me.upshoot.models.Player;
import com.me.upshoot.models.World;

public class WorldRenderer {

	
	public static final float CAMERA_HEIGHT = 640f;
	public static final float CAMERA_WIDTH = 480f;
	
	private World world;
	public static OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	private Player player;
	
	
	public WorldRenderer(World world, Player player){
		this.shapeRenderer = new ShapeRenderer();
		this.world = world;
		this.player = player;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.setToOrtho(false, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.update();
	}
	
	
	public void drawPlayer(){
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.begin(ShapeType.FilledCircle);
		shapeRenderer.filledCircle(player.getPosition().x, player.getPosition().y, player.getRadius());
		shapeRenderer.end();
	}
	
	public void drawPlayerHitBox(){
		Rectangle hitBox = player.getHitBox();
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.setColor(0, 0, 1, 1);
		shapeRenderer.begin(ShapeType.Rectangle);
		shapeRenderer.rect(hitBox.getX(), hitBox.getY(), hitBox.getWidth(), hitBox.getHeight());
		shapeRenderer.end();
	}
	
	public void drawBlocks(){
		for(Block block: world.getBlocks()){
			shapeRenderer.setProjectionMatrix(cam.combined);
			shapeRenderer.setColor(0, 1, 0, 1);
			shapeRenderer.begin(ShapeType.FilledRectangle);
			shapeRenderer.filledRect(block.getPosition().x, block.getPosition().y, block.getWidth(), block.getHeight());
			shapeRenderer.end();
		}
	}
	
	public void drawBlocksHitBoxes(){
		for(Block block: world.getBlocks()){
			Rectangle rect = block.getHitBox();
			shapeRenderer.setProjectionMatrix(cam.combined);
			shapeRenderer.setColor(0, 0, 1, 1);
			shapeRenderer.begin(ShapeType.Rectangle);
			shapeRenderer.rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
			shapeRenderer.end();
		}
	}
	
	public void render(){
		drawBlocks();
		drawPlayer();
		//drawPlayerHitBox();
		//drawBlocksHitBoxes();
	}
	
	public void setSize(int width, int height){
		//Umm, like nothin
	}
	
	
	
}
