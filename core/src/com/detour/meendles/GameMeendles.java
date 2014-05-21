package com.detour.meendles;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameMeendles extends ApplicationAdapter {
	SpriteBatch batch;
	Texture breed;
	
	static int width;
	static int w;
	static int height;
	
	static Meendle mPet1;
	static Meendle mPet2;
	static Meendle mPet3;
	static Meendle mPet4;
	static Meendle mPet5;
	static Meendle mPet6;
	
	public static Meendle[] mPets;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		breed = new Texture("breed.png");
		width = Gdx.graphics.getWidth();
		w = width/6;
		height = Gdx.graphics.getHeight();
		Gdx.input.setInputProcessor(new Input());
		init();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(breed, width/3f, height - (width/3f), width/3f, width/3f);
		mPet1.draw(batch);
		mPet2.draw(batch);
		mPet3.draw(batch);
		mPet4.draw(batch);
		mPet5.draw(batch);
		mPet6.draw(batch);
		batch.end();
	}
	
	private static void init(){
		
		//int h = height/6;
		
		mPet1 = new Meendle(0, 0);
		mPet2 = new Meendle(w, 0);
		mPet3 = new Meendle(w*2, 0);
		mPet4 = new Meendle(w*3, 0);
		mPet5 = new Meendle(w*4, 0);
		mPet6 = new Meendle(w*5, 0);
		mPets = new Meendle[]{mPet1,mPet2,mPet3,mPet4,mPet5,mPet6};
		
		
	}
	
	public static void breedNewGeneration(){
		
		Meendle mother=null;
		Meendle father=null;
		for(int i=0;i<mPets.length;i++){
			if(mPets[i].isSelected()){
				mother = mPets[i];
			}
		}
		for(int i=mPets.length-1;i>-1;i--){
			if(mPets[i].isSelected()){
				father = mPets[i];
			}
		}
		if(mother!=null && father!=null){
			mPet1 = new Meendle(0, 0, mother, father);
			mPet2 = new Meendle(w, 0, mother, father);
			mPet3 = new Meendle(w*2, 0, mother, father);
			mPet4 = new Meendle(w*3, 0, mother, father);
			mPet5 = new Meendle(w*4, 0, mother, father);
			mPet6 = new Meendle(w*5, 0, mother, father);
			mPets = new Meendle[]{mPet1,mPet2,mPet3,mPet4,mPet5,mPet6};
		}else{
			init();
		}
	}
	
}
