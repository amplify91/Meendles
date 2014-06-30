package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneEyebrowsShape extends Gene {
	
	private String shape;
	
	public static final GeneEyebrowsShape PLACEHOLDER = new GeneEyebrowsShape("eyebrows_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneEyebrowsShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().eyebrowsShape = shape;
	}

}
