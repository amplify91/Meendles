package com.detour.meendles.genes;

import com.badlogic.gdx.math.Vector3;
import com.detour.meendles.Gene;
import com.detour.meendles.Meendle;

public class GeneTailPrimaryColor extends Gene {
	
	private Vector3 color;
	
	public static final GeneTailPrimaryColor PLACEHOLDER = new GeneTailPrimaryColor(new Vector3(1f, 1f, 1f), "", "", "");
	
	public static final Gene[] ALLELES = new Gene[]{PLACEHOLDER};
	
	public GeneTailPrimaryColor(Vector3 color, String name, String abbr, String descr) {
		super(name, abbr, descr);
		this.color = color;
	}

	@Override
	public void build(Meendle meendle) {
		meendle.getData().tailColor1 = color;
	}

}
