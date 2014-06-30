package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneEyebrowsScale extends Gene {
	
	private float scale;
	
	public static final GeneEyebrowsScale DEFAULT = new GeneEyebrowsScale(1f, "", "", "");
	public static final GeneEyebrowsScale TINY = new GeneEyebrowsScale(0.5f, "", "", "");
	public static final GeneEyebrowsScale HUGE = new GeneEyebrowsScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneEyebrowsScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("eyebrows").setScale(scale);
	}

}
