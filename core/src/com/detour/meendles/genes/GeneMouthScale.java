package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneMouthScale extends Gene {
	
	private float scale;
	
	public static final GeneMouthScale DEFAULT = new GeneMouthScale(1f, "", "", "");
	public static final GeneMouthScale TINY = new GeneMouthScale(0.5f, "", "", "");
	public static final GeneMouthScale HUGE = new GeneMouthScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneMouthScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("mouth").setScale(scale);
	}

}
