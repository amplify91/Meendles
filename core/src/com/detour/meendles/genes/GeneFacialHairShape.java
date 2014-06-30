package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneFacialHairShape extends Gene {
	
	private String shape;
	
	public static final GeneFacialHairShape PLACEHOLDER = new GeneFacialHairShape("facialHair_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneFacialHairShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().facialHairShape = shape;
	}

}
