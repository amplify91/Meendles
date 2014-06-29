package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;
import com.detour.meendles.Colors.Pallet;

public class GeneEyesColors extends Gene {
	
	private Pallet colors;
	
	public static final GeneEyesColors PLACEHOLDER = new GeneEyesColors(Pallet.BASIC, "", "", "");
	public static final GeneEyesColors RED = new GeneEyesColors(Pallet.MONO_RED, "", "", "");
	public static final GeneEyesColors BLUE = new GeneEyesColors(Pallet.MONO_BLUE, "", "", "");
	public static final GeneEyesColors GREEN = new GeneEyesColors(Pallet.MONO_GREEN, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER,BLUE,GREEN,RED};
	
	public GeneEyesColors(Pallet colors, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.colors = colors;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().eyesColor1 = colors.getPrimaryColor().getColor();
		meendle.getData().eyesColor2 = colors.getSecondaryColor().getColor();
		meendle.getData().eyesColor3 = colors.getTertiaryColor().getColor();
	}

}
