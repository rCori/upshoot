package com.me.upshoot.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.me.upshoot.UpShoot;
import com.me.upshoot.view.WorldRenderer;

public class World {
	Array<Block> blocks = new Array<Block>();

	int timer = 250;
	
	int score = 0;
	
	Player player;
	UpShoot upShoot;
	
	public World(Player player, UpShoot upShoot){
		this.player = player;
		this.upShoot = upShoot;
	}
	
	public void update(float delta){
		addBlock(delta);
		for(Block block:blocks){
			block.update(delta);
			if(block.checkCollision(player)){
				upShoot.setScreen(upShoot.introScreen);
			}
		}
		removeBlock();
	}
	
	public void addBlock(float delta){
		//Generate a random probability
		timer -= delta;
		if(timer == 0){
			//Needs more randomization, will work on it
			//Need to use unproject
			int x =  Gdx.graphics.getWidth() - 40;
			x*=Math.random();
			Vector3 temp = new Vector3(x,0,0);
			WorldRenderer.cam.unproject(temp);
			Block block = new Block(40,40, (int)temp.x, (int)temp.y);
			//Gdx.app.log("upshoot", "x value of block is: " + x);
			timer = 250;
			blocks.add(block);
		}
	}
	
	public void removeBlock(){
		//Uhh sure
		if(blocks.size > 3){
			blocks.removeIndex(0);
			score++;
		}
	}
	
	public Array<Block> getBlocks(){
		return this.blocks;
	}
	
	public int getScore(){
		return this.score;
	}

}
