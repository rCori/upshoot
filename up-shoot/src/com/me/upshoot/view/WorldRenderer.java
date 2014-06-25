package com.me.upshoot.view;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.me.upshoot.models.World;

public class WorldRenderer {

	private World world;
	
	private ShapeRenderer shapeRenderer;
	
	public WorldRenderer(World world){
		this.world = world;
	}
	
	public void drawCircles(){
		for(Circle circle : world.getCircles()){
			shapeRenderer.begin(ShapeType.FilledCircle);
			shapeRenderer.setColor(1, 0, 0, 1);
			shapeRenderer.circle(circle.x, circle.y, circle.radius);
			shapeRenderer.end();
		}
	}
	
	public void render(){
		drawCircles();
	}
	
	
	
}
