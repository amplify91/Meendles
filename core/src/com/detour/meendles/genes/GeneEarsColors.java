package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneEarsColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneEarsColors PLACEHOLDER = new GeneEarsColors(Pallet.BASIC, "", "", "");
	public static final GeneEarsColors RED = new GeneEarsColors(Pallet.MONO_RED, "", "", "");
	public static final GeneEarsColors GREEN = new GeneEarsColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneEarsColors BLUE = new GeneEarsColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneEarsColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().earsColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().earsColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().earsColor3 = colors.getTertiaryColor().getColor();
	}

}
