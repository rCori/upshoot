package com.me.upshoot.models;

import com.badlogic.gdx.math.Vector2;

public class Player {

	public enum State{
		GROUND, AIR
	}
	
	Vector2 position = new Vector2();
	Vector2 velocity = new Vector2();
	Vector2 acceleration = new Vector2();
	State state = State.GROUND;
	float radius;
	
	public static final float JUMP_ACCELERATION = 20f;
	public static final float GRAV_ACCELERATION = -10f;
	public static final float PLAYER_RADIUS = 10f;
	
	public Player(Vector2 position){
		this.position = position;
		this.velocity.set(0f,0f);
		this.acceleration.set(0f,0f);
		this.radius = PLAYER_RADIUS;
		
	}
	
	public Vector2 getPosition(){
		return this.position;
	}
	
	public Vector2 getVelocity(){
		return this.velocity;
	}
	
	public Vector2 getAcceleration(){
		return this.acceleration;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	
	
	public void launch(){
		
	}
	
	public void update(float delta){
		this.getPosition().x += (this.getVelocity().x * delta);
		this.getPosition().y += (this.getVelocity().y * delta);
		
		this.getVelocity().x += (this.getAcceleration().x * delta);
		this.getVelocity().y += (this.getAcceleration().y * delta);
		
		if(this.state == State.AIR){
			this.getAcceleration().y = GRAV_ACCELERATION;
		}
		
	}
	
}
