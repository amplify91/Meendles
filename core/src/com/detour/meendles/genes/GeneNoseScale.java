package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneNoseScale extends Gene {
	
	private float scale;
	
	public static final GeneNoseScale DEFAULT = new GeneNoseScale(1f, "", "", "");
	public static final GeneNoseScale TINY = new GeneNoseScale(0.5f, "", "", "");
	public static final GeneNoseScale HUGE = new GeneNoseScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneNoseScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("nose").setScale(scale);
	}

}
