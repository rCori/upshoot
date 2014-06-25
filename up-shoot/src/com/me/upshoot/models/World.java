package com.me.upshoot.models;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;

public class World {
	
	Array<Circle> circles = new Array<Circle>();
	
	public World(){
		
	}
	public Array<Circle> getCircles(){
		return this.circles;
	}
	
	public void setCircle(float x, float y, float rad){
		Circle circle = new Circle(x,y,rad);
		this.circles.add(circle);
	}

}
