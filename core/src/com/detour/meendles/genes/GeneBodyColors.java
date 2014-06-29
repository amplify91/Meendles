package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneBodyColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneBodyColors PLACEHOLDER = new GeneBodyColors(Pallet.BASIC, "", "", "");
	public static final GeneBodyColors RED = new GeneBodyColors(Pallet.MONO_RED, "", "", "");
	public static final GeneBodyColors GREEN = new GeneBodyColors(Pallet.MONO_GREEN, "", "", "");
	public static final GeneBodyColors BLUE = new GeneBodyColors(Pallet.MONO_BLUE, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneBodyColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().bodyColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().bodyColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().bodyColor3 = colors.getTertiaryColor().getColor();
	}

}
