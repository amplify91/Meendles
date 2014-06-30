package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneEarsScale extends Gene {
	
	private float scale;
	
	public static final GeneEarsScale DEFAULT = new GeneEarsScale(1f, "", "", "");
	public static final GeneEarsScale TINY = new GeneEarsScale(0.5f, "", "", "");
	public static final GeneEarsScale HUGE = new GeneEarsScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneEarsScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("ears").setScale(scale);
	}

}
