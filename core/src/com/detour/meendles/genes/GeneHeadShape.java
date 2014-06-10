package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHeadShape extends Gene{
	
	String shape;
	
	public static final GeneHeadShape PLACEHOLDER = new GeneHeadShape("head_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneHeadShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().headShape = shape;
		
	}

}
