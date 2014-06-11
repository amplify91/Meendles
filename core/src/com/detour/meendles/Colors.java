package com.detour.meendles;

import com.badlogic.gdx.math.Vector3;

public enum Colors {
	
	BLACK(0.0f, 0.0f, 0.0f),
	WHITE(1.0f, 1.0f, 1.0f);
	
	public enum Pallets {
		
		BASIC(new Colors[]{WHITE},
				new Colors[]{WHITE},
				new Colors[]{WHITE});
		
		private Colors[] primaryColors;
		private Colors[] secondaryColors;
		private Colors[] tertiaryColors;
		
		private Pallets(Colors[] primaries,
				Colors[] secondaries,
				Colors[] tertiaries){
			setPrimaryColors(primaries);
			setSecondaryColors(secondaries);
			setTertiaryColors(tertiaries);
		}

		public Colors[] getPrimaryColors() {
			return primaryColors;
		}

		private void setPrimaryColors(Colors[] primaries) {
			this.primaryColors = primaries;
		}

		public Colors[] getSecondaryColors() {
			return secondaryColors;
		}

		private void setSecondaryColors(Colors[] secondaryColors) {
			this.secondaryColors = secondaryColors;
		}

		public Colors[] getTertiaryColors() {
			return tertiaryColors;
		}

		private void setTertiaryColors(Colors[] tertiaryColors) {
			this.tertiaryColors = tertiaryColors;
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