package com.detour.meendles;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.utils.TimeUtils;

public class GameMeendles extends Game {
	
	long mLastTime = 0;
	long mCurrentTime;
	float mDeltaTime;
	
	public static ScreenTitle mTitleScreen;
	
	private static final GameMeendles mGame = new GameMeendles();
	
	private GameMeendles(){
		
	}
	
	@Override
	public void create () {
		mTitleScreen = new ScreenTitle();
		setScreen(mTitleScreen);
	}

	@Override
	public void render () {
		
		mCurrentTime = TimeUtils.nanoTime();
		if(mLastTime==0){
			mLastTime = mCurrentTime-1;
		}
		mDeltaTime = ((float)(mCurrentTime - mLastTime))/1000000000f;
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		getScreen().render(mDeltaTime);
		
		mLastTime = mCurrentTime;
		
		/*Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		batch.begin();
		program.setAttributef("a_color1", 1f, 0f, 0f, 0f);
	    program.setAttributef("a_color2", 0f, 1f, 0f, 0f);
	    program.setAttributef("a_color3", 0f, 0f, 1f, 0f);
		batch.draw(breed, width/3f, height - (width/3f), width/3f, width/3f);
		mPet1.draw(batch);
		mPet2.draw(batch);
		mPet3.draw(batch);
		mPet4.draw(batch);
		mPet5.draw(batch);
		mPet6.draw(batch);
		batch.end();*/
	}
	
	public static GameMeendles getGame(){
		return mGame;
	}
	
}
