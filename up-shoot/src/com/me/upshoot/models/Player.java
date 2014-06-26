package com.me.upshoot.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.me.upshoot.view.WorldRenderer;

public class Player {

	public enum State{
		GROUND, AIR
	}
	
	Vector2 position = new Vector2();
	Vector2 velocity = new Vector2();
	Vector2 acceleration = new Vector2();
	State state = State.GROUND;
	float radius;
	
	public static final float JUMP_VELOCITY = 5f;
	public static final float GRAV_ACCELERATION = -400f;
	public static final float PLAYER_RADIUS = 10f;
	public static final float DAMP = 0.6f;
	
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
	
	public State getState(){
		return this.state;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public float getRadius(){
		return this.radius;
	}
	
	
	
	public void launch(int x, int y){
		if(this.getState().equals(State.GROUND)){
			Vector3 pos = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
			WorldRenderer.cam.unproject(pos);
			float xDiff = pos.x - this.getPosition().x;
			float yDiff = pos.y - this.getPosition().y;
			Gdx.app.log("upshoot", "xPosition: " + this.getPosition().x);
			Gdx.app.log("upshoot", "yPosition: " + this.getPosition().y);
			
			Gdx.app.log("upshoot", "pos.x: " + pos.x);
			Gdx.app.log("upshoot", "pos.y: " + pos.y);
			
			Gdx.app.log("upshoot", "xDiff: " + xDiff);
			Gdx.app.log("upshoot", "yDiff: " + yDiff);
			this.getVelocity().x = xDiff * Player.JUMP_VELOCITY;
			this.getVelocity().y = yDiff * Player.JUMP_VELOCITY;
			this.setState(State.AIR);
		}
	}
	
	public void update(float delta){
		//this.getPosition().x += (this.getVelocity().x * delta);
		//this.getPosition().y += (this.getVelocity().y * delta);
		position.add(velocity.tmp().mul(delta));
		
		this.getVelocity().x += (this.getAcceleration().x * delta);
		this.getVelocity().y += (this.getAcceleration().y * delta);
		
		this.getAcceleration().y = GRAV_ACCELERATION;
		//Keep me from falling through the ground.
		if(this.getPosition().y < 20){
			this.getPosition().y = 20;
			this.getVelocity().y *= -DAMP;
			this.setState(State.GROUND);
		}
		
		if(this.getPosition().y > 640){
			this.getPosition().y = 640;
			this.getVelocity().y *= -DAMP;
			this.setState(State.GROUND);
		}
		
		if(this.getPosition().x < 20){
			this.getPosition().x = 20;
			this.getVelocity().x *= -DAMP;
			this.setState(State.GROUND);
		}
		if(this.getPosition().x > 460){
			this.getPosition().x = 460;
			this.getVelocity().x *= -DAMP;
			this.setState(State.GROUND);
		}
	}
	
}
