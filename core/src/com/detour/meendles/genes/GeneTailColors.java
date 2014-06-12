package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneTailColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneTailColors PLACEHOLDER = new GeneTailColors(Pallet.BASIC, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneTailColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().tailColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().tailColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().tailColor3 = colors.getTertiaryColor().getColor();
	}

}
