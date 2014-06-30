package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneSkinType extends Gene{
	
	private String skinType;
	
	public static final GeneSkinType BASIC = new GeneSkinType("", "Basic", "", "");
	public static final GeneSkinType FUR = new GeneSkinType("_fur", "Fur", "", "");

	public static final Gene[] ALLELES = new Gene[]{BASIC};
	
	public GeneSkinType(String skinType, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.skinType = skinType;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().skinType = skinType;
	}

}
