package com.detour.meendles;

public class Sprite implements IFocusable{
	
	protected float mPosX;
	protected float mPosY;
	protected float mCameraOffsetX = 0;
	protected float mCameraOffsetY = 0;
	
	@Override
	public float getX() {
		return mPosX;
	}

	@Override
	public float getY() {
		return mPosY;
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
