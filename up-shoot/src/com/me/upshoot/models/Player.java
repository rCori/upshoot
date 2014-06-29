package com.me.upshoot.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.me.upshoot.view.WorldRenderer;

public class Player {

	public enum State{
		GROUND, AIR
	}
	
	Sound collideSound = Gdx.audio.newSound(Gdx.files.internal("data/mechanical-clonk-1.wav"));
	
	Vector2 position = new Vector2();
	Vector2 velocity = new Vector2();
	Vector2 acceleration = new Vector2();
	State state = State.GROUND;
	float radius;
	Rectangle hitBox = new Rectangle();
	
	public static final float JUMP_VELOCITY = 5f;
	public static final float GRAV_ACCELERATION = -400f;
	public static final float PLAYER_RADIUS = 10f;
	public static final float DAMP = 0.6f;
	
	public Player(Vector2 position){
		this.position = position;
		this.velocity.set(0f,0f);
		this.acceleration.set(0f,0f);
		this.radius = PLAYER_RADIUS;
		this.hitBox.set(this.position.x-this.radius, this.position.y-this.radius, this.radius*2, this.radius*2);
		
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
	
	public Rectangle getHitBox(){
		return this.hitBox;
	}
	
	public void launch(int x, int y){
		if(this.getState().equals(State.GROUND)){
			Vector3 pos = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
			WorldRenderer.cam.unproject(pos);
			float xDiff = pos.x - this.getPosition().x;
			float yDiff = pos.y - this.getPosition().y;

			this.getVelocity().x = xDiff * Player.JUMP_VELOCITY;
			this.getVelocity().y = yDiff * Player.JUMP_VELOCITY;
			this.setState(State.AIR);
		}
	}
	
	public void update(float delta){
		position.add(velocity.tmp().mul(delta));
		
		velocity.add(acceleration.tmp().mul(delta));
		
		this.getAcceleration().y = GRAV_ACCELERATION;
		hitBox.setX(position.x-radius);
		hitBox.setY(position.y-radius);
		//Keep me from falling through the ground.
		if(this.getPosition().y < 20){
			this.getPosition().y = 20;
			if(this.getVelocity().y < -150) collideSound.play();
			this.getVelocity().y *= -DAMP;
			this.setState(State.GROUND);
		}
		
		if(this.getPosition().y > 640){
			this.getPosition().y = 640;
			if(this.getVelocity().y > 150) collideSound.play();
			this.getVelocity().y *= -DAMP;
			this.setState(State.GROUND);
		}
		
		if(this.getPosition().x < 20){
			this.getPosition().x = 20;
			if(this.getVelocity().x < -150) collideSound.play();
			this.getVelocity().x *= -DAMP;
			this.setState(State.GROUND);
		}
		if(this.getPosition().x > 460){
			this.getPosition().x = 460;
			if(this.getVelocity().x > 150) collideSound.play();
			this.getVelocity().x *= -DAMP;
			this.setState(State.GROUND);
		}
	}
	
}
