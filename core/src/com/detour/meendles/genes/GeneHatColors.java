package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneHatColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneHatColors PLACEHOLDER = new GeneHatColors(Pallet.BASIC, "", "", "");
	public static final GeneHatColors RED = new GeneHatColors(Pallet.MONO_RED, "", "", "");
	public static final GeneHatColors GREEN = new GeneHatColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneHatColors BLUE = new GeneHatColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneHatColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().hatColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().hatColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().hatColor3 = colors.getTertiaryColor().getColor();
	}

}
