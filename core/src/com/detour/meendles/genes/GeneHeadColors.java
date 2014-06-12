package com.detour.meendles.genes;

import com.detour.meendles.Colors.Pallet;
import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHeadColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneHeadColors PLACEHOLDER = new GeneHeadColors(Pallet.BASIC, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
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
