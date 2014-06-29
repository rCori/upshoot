package com.me.upshoot.models;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Block {

	private int width;
	private int height;
	private int yVelocity;
	private Vector2 position;
	private Rectangle hitBox;
	
	public Block(int width, int height, int x, int y){
		this.width = width;
		this.height = height;
		this.position = new Vector2(x,y);
		this.hitBox = new Rectangle(this.position.x, this.position.y, this.width, this.height);
	}
	
	public void update(float delta){
		//Needs changing
		getPosition().y -=  1;
		hitBox.set(getPosition().x, getPosition().y, this.width, this.height);
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public Rectangle getHitBox(){
		return this.hitBox;
	}
	
	public boolean checkCollision(Player player){
		boolean collision = player.getHitBox().overlaps(this.hitBox);
		if(collision){
			return true;
		}
		else{
			return false;
		}
	}
}
