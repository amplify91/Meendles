package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneMouthColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneMouthColors PLACEHOLDER = new GeneMouthColors(Pallet.BASIC, "", "", "");
	public static final GeneMouthColors RED = new GeneMouthColors(Pallet.MONO_RED, "", "", "");
	public static final GeneMouthColors GREEN = new GeneMouthColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneMouthColors BLUE = new GeneMouthColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneMouthColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().mouthColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().mouthColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().mouthColor3 = colors.getTertiaryColor().getColor();
	}

}
