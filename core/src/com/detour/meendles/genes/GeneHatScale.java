package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneHatScale extends Gene {
	
	private float scale;
	
	public static final GeneHatScale DEFAULT = new GeneHatScale(1f, "", "", "");
	public static final GeneHatScale TINY = new GeneHatScale(0.5f, "", "", "");
	public static final GeneHatScale HUGE = new GeneHatScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneHatScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("hat").setScale(scale);
	}

}
