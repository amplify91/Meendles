package com.detour.meendles;

public class GeneBodyColor extends GeneTypeSingleTrait{
	
	//Traits
	public static final int RED = 1;
	public static final int YELLOW = 2;
	public static final int BLUE = 3;
	//Alleles
	public static final GeneBodyColor BODY_COLOR_RED =
			new GeneBodyColor(RED, "Red", "R", "Red body color.");
	public static final GeneBodyColor BODY_COLOR_YELLOW =
			new GeneBodyColor(YELLOW, "Yellow", "Y", "Yellow body color.");
	public static final GeneBodyColor BODY_COLOR_BLUE =
			new GeneBodyColor(BLUE, "Blue", "B", "Blue body color.");
	
	public static final Gene[] ALLELES = new Gene[]{BODY_COLOR_BLUE,BODY_COLOR_YELLOW,BODY_COLOR_RED};
	
	public GeneBodyColor(int color, String name, String abbr, String descr){
		super(color, name, abbr, descr);
		//setAlleleDominances(new Gene[]{BODY_COLOR_BLUE, BODY_COLOR_YELLOW, BODY_COLOR_RED});
	}

}
