package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneFacialHairColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneFacialHairColors PLACEHOLDER = new GeneFacialHairColors(Pallet.BASIC, "", "", "");
	public static final GeneFacialHairColors RED = new GeneFacialHairColors(Pallet.MONO_RED, "", "", "");
	public static final GeneFacialHairColors GREEN = new GeneFacialHairColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneFacialHairColors BLUE = new GeneFacialHairColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneFacialHairColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().facialHairColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().facialHairColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().facialHairColor3 = colors.getTertiaryColor().getColor();
	}

}
