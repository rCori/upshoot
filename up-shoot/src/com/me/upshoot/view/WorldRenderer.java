package com.me.upshoot.view;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.me.upshoot.models.World;

public class WorldRenderer {

	private static final float CAMERA_HEIGHT = 480f;
	private static final float CAMERA_WIDTH = 800f;
	
	private World world;
	private OrthographicCamera cam;
	
	private ShapeRenderer shapeRenderer;
	
	public WorldRenderer(World world){
		this.shapeRenderer = new ShapeRenderer();
		this.world = world;
		this.cam = new OrthographicCamera();
		this.cam.setToOrtho(false,CAMERA_WIDTH,CAMERA_HEIGHT);
		this.cam.update();
	}
	
	public void drawCircles(){
		/*
		for(Circle circle : world.getCircles()){
			shapeRenderer.begin(ShapeType.FilledCircle);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.circle(circle.x, circle.y, circle.radius);
			shapeRenderer.end();
		}
		*/
		//dummy
		//Do I need setProjectionMatrix?
		shapeRenderer.setProjectionMatrix(cam.combined);
		shapeRenderer.begin(ShapeType.FilledCircle);
		shapeRenderer.setColor(1, 0, 0, 1);
		shapeRenderer.filledCircle(100, 100, 100);
		shapeRenderer.end();
	}
	
	public void render(){
		drawCircles();
	}
	
	public void setSize(int width, int height){
		//Umm, like nothin
	}
	
	
	
}
