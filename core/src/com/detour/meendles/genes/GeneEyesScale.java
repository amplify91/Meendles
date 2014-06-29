package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneEyesScale extends Gene {
	
	private float scale;
	
	public static final GeneEyesScale DEFAULT = new GeneEyesScale(1f, "", "", "");
	public static final GeneEyesScale TINY = new GeneEyesScale(0.5f, "", "", "");
	public static final GeneEyesScale HUGE = new GeneEyesScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneEyesScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("eyes").setScale(scale);
	}

}
