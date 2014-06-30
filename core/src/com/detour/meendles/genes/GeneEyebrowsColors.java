package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneEyebrowsColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneEyebrowsColors PLACEHOLDER = new GeneEyebrowsColors(Pallet.BASIC, "", "", "");
	public static final GeneEyebrowsColors RED = new GeneEyebrowsColors(Pallet.MONO_RED, "", "", "");
	public static final GeneEyebrowsColors BLUE = new GeneEyebrowsColors(Pallet.MONO_BLUE, "", "", "");
	public static final GeneEyebrowsColors GREEN = new GeneEyebrowsColors(Pallet.MONO_GREEN, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneEyebrowsColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().eyebrowsColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().eyebrowsColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().eyebrowsColor3 = colors.getTertiaryColor().getColor();
	}

}
