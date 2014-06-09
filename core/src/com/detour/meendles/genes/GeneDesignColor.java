package com.detour.meendles.genes;

import com.detour.meendles.Gene;
import com.detour.meendles.GeneTypeSingleTrait;

public class GeneDesignColor extends GeneTypeSingleTrait{
	
	//Traits
	public static final int RED = 1;
	public static final int YELLOW = 2;
	public static final int BLUE = 3;
	//Alleles
	public static final GeneDesignColor DESIGN_COLOR_RED =
			new GeneDesignColor(RED, "Red", "R", "Red design color.");
	public static final GeneDesignColor DESIGN_COLOR_YELLOW =
			new GeneDesignColor(YELLOW, "Yellow", "Y", "Yellow design color.");
	public static final GeneDesignColor DESIGN_COLOR_BLUE =
			new GeneDesignColor(BLUE, "Blue", "B", "Blue design color.");
	
	public static final Gene[] ALLELES = new Gene[]{DESIGN_COLOR_RED,DESIGN_COLOR_BLUE,DESIGN_COLOR_YELLOW};
	
	public GeneDesignColor(int color, String name, String abbr, String descr){
		super(color, name, abbr, descr);
		//setAlleleDominances(new Gene[]{DESIGN_COLOR_RED, DESIGN_COLOR_BLUE, DESIGN_COLOR_YELLOW});
	}

}
