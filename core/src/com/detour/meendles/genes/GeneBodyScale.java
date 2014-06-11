package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneBodyScale extends Gene{
	
	private float scale;
	
	public static final GeneBodyScale DEFAULT = new GeneBodyScale(1f, "", "", "");
	public static final GeneBodyScale TINY = new GeneBodyScale(0.5f, "", "", "");
	public static final GeneBodyScale HUGE = new GeneBodyScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneBodyScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("bodyParent").setScale(scale);
	}
	
}
