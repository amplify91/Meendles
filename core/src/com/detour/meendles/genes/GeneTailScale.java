package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneTailScale extends Gene {
	
	private float scale;
	
	public static final GeneTailScale DEFAULT = new GeneTailScale(1f, "", "", "");
	public static final GeneTailScale TINY = new GeneTailScale(0.5f, "", "", "");
	public static final GeneTailScale HUGE = new GeneTailScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneTailScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.mSkeleton.findBone("tail").setScale(scale);
	}

}
