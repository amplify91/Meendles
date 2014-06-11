package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneTailShape extends Gene {
	
	String shape;
	
	public static final GeneTailShape PLACEHOLDER = new GeneTailShape("tail_1", "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneTailShape(String shape, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.shape = shape;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().tailShape = shape;
	}

}
