package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHairShape extends Gene {
	
	private String shape;
	
	public static final GeneHatShape PLACEHOLDER = new GeneHatShape("hair_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneHairShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().hatShape = shape;
	}

}
