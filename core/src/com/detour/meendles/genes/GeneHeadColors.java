package com.detour.meendles.genes;

import com.detour.meendles.Colors.Pallet;
import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHeadColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneHeadColors PLACEHOLDER = new GeneHeadColors(Pallet.BASIC, "", "", "");
	public static final GeneHeadColors RED = new GeneHeadColors(Pallet.MONO_RED, "", "", "");
	public static final GeneHeadColors BLUE = new GeneHeadColors(Pallet.MONO_BLUE, "", "", "");
	public static final GeneHeadColors GREEN = new GeneHeadColors(Pallet.MONO_GREEN, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneHeadColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().headColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().headColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().headColor3 = colors.getTertiaryColor().getColor();
	}

}
