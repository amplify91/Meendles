package com.detour.meendles;

public class Sprite implements IFocusable{
	
	protected float mX;
	protected float mY;
	protected float mCameraOffsetX = 0;
	protected float mCameraOffsetY = 0;
	
	@Override
	public float getX() {
		return mX;
	}

	@Override
	public float getY() {
		return mY;
	}

	@Override
	public float getCameraOffsetX() {
		return mCameraOffsetX;
	}

	@Override
	public float getCameraOffsetY() {
		return mCameraOffsetY;
	}

}
