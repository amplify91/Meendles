package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHairScale extends Gene {
	
	private float scale;
	
	public static final GeneHairScale DEFAULT = new GeneHairScale(1f, "", "", "");
	public static final GeneHairScale TINY = new GeneHairScale(0.5f, "", "", "");
	public static final GeneHairScale HUGE = new GeneHairScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneHairScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("hair").setScale(scale);
	}

}
