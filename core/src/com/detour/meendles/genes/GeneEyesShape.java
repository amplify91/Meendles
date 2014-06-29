package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneEyesShape extends Gene {
	
	private String shape;
	
	public static final GeneEyesShape PLACEHOLDER = new GeneEyesShape("eyes_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneEyesShape(String shapeName, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shapeName;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().eyesShape = shape;
	}

}
