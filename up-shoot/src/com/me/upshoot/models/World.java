package com.me.upshoot.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.utils.Array;
import com.me.upshoot.view.WorldRenderer;

public class World {
	Array<Block> blocks = new Array<Block>();

	int timer = 250;
	
	Player player;
	
	public World(Player player){
		this.player = player;
	}
	
	public void update(float delta){
		addBlock(delta);
		for(Block block:blocks){
			block.update(delta);
			block.checkCollision(player);
		}
		removeBlock();
	}
	
	public void addBlock(float delta){
		//Generate a random probability
		timer -= delta;
		if(timer == 0){
			//Needs more randomization, will work on it
			int x =  (int)(Math.random() * WorldRenderer.CAMERA_WIDTH);
			Block block = new Block(40,40, x, (int) WorldRenderer.CAMERA_HEIGHT);
			timer = 250;
			blocks.add(block);
		}
	}
	
	public void removeBlock(){
		//Uhh sure
		if(blocks.size > 3){
			blocks.removeIndex(0);
		}
	}
	
	public Array<Block> getBlocks(){
		return this.blocks;
	}

}
