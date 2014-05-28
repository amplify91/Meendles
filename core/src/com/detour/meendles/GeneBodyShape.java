package com.detour.meendles;

public class GeneBodyShape extends GeneTypeSingleTrait{
	
	//Traits
	public static final int CIRCLE = 1;
	public static final int TRIANGLE = 2;
	public static final int SQUARE = 3;
	//Alleles
	public static final GeneBodyShape BODY_SHAPE_CIRCLE =
			new GeneBodyShape(CIRCLE, "Circle", "0", "Circular body shape.");
	public static final GeneBodyShape BODY_SHAPE_TRIANGLE =
			new GeneBodyShape(TRIANGLE, "Triangle", "3", "Trianglular body shape.");
	public static final GeneBodyShape BODY_SHAPE_SQUARE =
			new GeneBodyShape(SQUARE, "Square", "4", "Square body shape.");
	
	public static final Gene[] ALLELES = new Gene[]{BODY_SHAPE_TRIANGLE,BODY_SHAPE_SQUARE,BODY_SHAPE_CIRCLE};
	
	public GeneBodyShape(int shape, String name, String abbr, String descr){
		super(shape, name, abbr, descr);
		//setAlleleDominances(new Gene[]{BODY_SHAPE_TRIANGLE,BODY_SHAPE_SQUARE,BODY_SHAPE_CIRCLE});
	}

}
