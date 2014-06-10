package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHeadScale extends Gene{
	
	private float scale;
	
	public static final GeneHeadScale DEFAULT = new GeneHeadScale(1f, "", "", "");
	public static final GeneHeadScale TINY = new GeneHeadScale(0.5f, "", "", "");
	public static final GeneHeadScale HUGE = new GeneHeadScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneHeadScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("head").setScale(scale);
	}

}
