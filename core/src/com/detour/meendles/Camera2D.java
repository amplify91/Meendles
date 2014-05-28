package com.detour.meendles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Camera2D {
	
	private OrthographicCamera mCamera;
	private float mScreenWidth;
	private float mScreenHeight;
	private float mScreenWidthPixels;
	private float mScreenHeightPixels;
	private float mViewRatio;
	private float mZoom;
	
	public Camera2D(float viewportWidth, float viewportHeight){
		reset(viewportWidth, viewportHeight);
	}
	
	public void follow(IFocusable focus) {
		mCamera.position.set(focus.getX()-focus.getCameraOffsetX(), focus.getY()-focus.getCameraOffsetY(), 0);
		mCamera.update();
	}
	
	public void reset(){
		reset(mScreenWidth, mScreenHeight);
	}
	
	public void reset(float viewportWidth, float viewportHeight){
		mScreenWidth = viewportWidth;
		mScreenHeight = viewportHeight;
		mViewRatio = mScreenWidth/mScreenHeight;
		mCamera = new OrthographicCamera(mScreenWidth, mScreenHeight);
		mCamera.position.set(mScreenWidth/2f, mScreenHeight/2f, 0);
		mCamera.update();
		
		//maybe unnecessary OpenGL stuff
		Gdx.gl.glEnable(GL20.GL_DEPTH_TEST);
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClearDepthf(1.0f);
		Gdx.gl.glDepthFunc(GL20.GL_LEQUAL);
		Gdx.gl.glDepthMask(true);
		Gdx.gl.glDisable(GL20.GL_DITHER);
		//Gdx.gl.glEnable(GL20.GL_CULL_FACE);
		Gdx.gl.glCullFace(GL20.GL_BACK);
		
		Gdx.gl.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MIN_FILTER, GL20.GL_LINEAR);
		Gdx.gl.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_MAG_FILTER, GL20.GL_LINEAR);
		Gdx.gl.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_S, GL20.GL_CLAMP_TO_EDGE);
		Gdx.gl.glTexParameterf(GL20.GL_TEXTURE_2D, GL20.GL_TEXTURE_WRAP_T, GL20.GL_CLAMP_TO_EDGE);
	}
	
	public OrthographicCamera getCamera(){
		return mCamera;
	}
	
	public float getHeight(){
		return mScreenHeight;
	}
	
	public float getWidth(){
		return mScreenWidth;
	}
	
	public float getHeightPixels(){
		return mScreenHeightPixels;
	}
	
	public float getWidthPixels(){
		return mScreenWidthPixels;
	}
	
	public void setScreenSizePixels(int width, int height){
		mScreenWidthPixels = width;
		mScreenHeightPixels = height;
	}
	
	public Vector2 translatePixelToWorldCoordinates(int x, int y){
		Vector3 vec = new Vector3(x,y,0);
		mCamera.unproject(vec);
		Vector2 returnVector = new Vector2(vec.x, vec.y);
		return returnVector;
	}
	
}