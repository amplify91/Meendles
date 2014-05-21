package com.detour.meendles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

public class Input implements InputProcessor{

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//System.out.println("touchUp at "+screenX + ", " + screenY);
		if(screenY>=Gdx.graphics.getHeight()-Meendle.HEIGHT){
			for(int i=0;i<GameMeendles.mPets.length;i++){
				if(screenX>GameMeendles.mPets[i].mPosX && screenX<GameMeendles.mPets[i].mPosX+Meendle.WIDTH){
					GameMeendles.mPets[i].toggleSelected();
					return true;
				}
			}
		}else if(screenY<=Gdx.graphics.getWidth()/3f && screenX>=Gdx.graphics.getWidth()/3f &&  screenX<=(Gdx.graphics.getWidth()/3f)*2){
			GameMeendles.breedNewGeneration();
		}
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
