package com.me.upshoot.models;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;

public class World {
	
	Circle playerCircle;
	
	
	public Circle getPlayerCircle(){
		return this.playerCircle;
	}
	
	public void setPlayerCircle(float x, float y, float rad){
		playerCircle = new Circle(x,y,rad);
	}

}
