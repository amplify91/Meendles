package com.detour.meendles;

import com.badlogic.gdx.math.Vector3;

public enum Colors {
	
	BLACK(0.0f, 0.0f, 0.0f),
	WHITE(1.0f, 1.0f, 1.0f),
	RED(1.0f, 0.0f, 0.0f),
	GREEN(0.0f, 1.0f, 0.0f),
	BLUE(0.0f, 0.0f, 1.0f);
	
	public enum Pallet {
		
		BASIC(WHITE, WHITE, WHITE),
		MONO_RED(RED, RED, RED),
		MONO_GREEN(GREEN, GREEN, GREEN),
		MONO_BLUE(BLUE, BLUE, BLUE),
		RGB(RED, GREEN, BLUE);
		
		private Colors primaryColor;
		private Colors secondaryColor;
		private Colors tertiaryColor;
		
		private Pallet(Colors primary, Colors secondary, Colors tertiary){
			setPrimaryColor(primary);
			setSecondaryColor(secondary);
			setTertiaryColor(tertiary);
		}

		public Colors getPrimaryColor() {
			return primaryColor;
		}

		private void setPrimaryColor(Colors primary) {
			this.primaryColor = primary;
		}

		public Colors getSecondaryColor() {
			return secondaryColor;
		}

		private void setSecondaryColor(Colors secondary) {
			this.secondaryColor = secondary;
		}

		public Colors getTertiaryColor() {
			return tertiaryColor;
		}

		private void setTertiaryColor(Colors tertiary) {
			this.tertiaryColor = tertiary;
		}

	}
	
	private Vector3 color;
	
	private Colors(float r, float g, float b){
		setColor(new Vector3(r, g, b));
	}

	public Vector3 getColor() {
		return color;
	}

	private void setColor(Vector3 color) {
		this.color = color;
	}
	
}