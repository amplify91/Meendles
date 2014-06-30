package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneHairColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneHairColors PLACEHOLDER = new GeneHairColors(Pallet.BASIC, "", "", "");
	public static final GeneHairColors RED = new GeneHairColors(Pallet.MONO_RED, "", "", "");
	public static final GeneHairColors GREEN = new GeneHairColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneHairColors BLUE = new GeneHairColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneHairColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().hairColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().hairColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().hairColor3 = colors.getTertiaryColor().getColor();
	}

}
