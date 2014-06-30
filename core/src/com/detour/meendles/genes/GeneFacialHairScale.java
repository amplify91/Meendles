package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneFacialHairScale extends Gene {
	
	private float scale;
	
	public static final GeneFacialHairScale DEFAULT = new GeneFacialHairScale(1f, "", "", "");
	public static final GeneFacialHairScale TINY = new GeneFacialHairScale(0.5f, "", "", "");
	public static final GeneFacialHairScale HUGE = new GeneFacialHairScale(1.5f, "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{DEFAULT, TINY, HUGE};
	
	public GeneFacialHairScale(float scale, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.scale = scale;
	}

	@Override
	public void build(Meendle meendle) {
		//meendle.mSkeleton.findBone("facialHair").setScale(scale); TODO
	}

}
