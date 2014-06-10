package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GenePattern extends Gene{
	
	private String pattern;
	
	public static final GenePattern BASIC = new GenePattern("", "Basic", "", "");
	public static final GenePattern STRIPED = new GenePattern("_striped", "Striped", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{BASIC};
	
	public GenePattern(String pattern, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.pattern = pattern;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().pattern = pattern;
	}

}
