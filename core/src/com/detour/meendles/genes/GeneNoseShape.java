package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneNoseShape extends Gene {
	
	private String shape;
	
	public static final GeneNoseShape PLACEHOLDER = new GeneNoseShape("nose_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneNoseShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().noseShape = shape;
	}

}
