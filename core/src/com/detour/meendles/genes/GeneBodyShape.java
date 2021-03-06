package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneBodyShape extends Gene{
	
	private String shape;
	
	public static final GeneBodyShape PLACEHOLDER = new GeneBodyShape("body_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneBodyShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().bodyShape = shape;
	}
	
}
