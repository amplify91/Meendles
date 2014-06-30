package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneNoseColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneNoseColors PLACEHOLDER = new GeneNoseColors(Pallet.BASIC, "", "", "");
	public static final GeneNoseColors RED = new GeneNoseColors(Pallet.MONO_RED, "", "", "");
	public static final GeneNoseColors GREEN = new GeneNoseColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneNoseColors BLUE = new GeneNoseColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneNoseColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().noseColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().noseColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().noseColor3 = colors.getTertiaryColor().getColor();
	}

}
