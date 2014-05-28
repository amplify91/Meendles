package com.detour.meendles;

public class GeneDesignShape extends GeneTypeSingleTrait{
	
	//Traits
	public static final int CIRCLE = 1;
	public static final int TRIANGLE = 2;
	public static final int SQUARE = 3;
	//Alleles
	public static final GeneDesignShape DESIGN_SHAPE_CIRCLE =
			new GeneDesignShape(CIRCLE, "Circle", "0", "Circular design shape.");
	public static final GeneDesignShape DESIGN_SHAPE_TRIANGLE =
			new GeneDesignShape(TRIANGLE, "Triangle", "3", "Trianglular design shape.");
	public static final GeneDesignShape DESIGN_SHAPE_SQUARE =
			new GeneDesignShape(SQUARE, "Square", "4", "Square design shape.");
	
	public static final Gene[] ALLELES = new Gene[]{DESIGN_SHAPE_CIRCLE,DESIGN_SHAPE_TRIANGLE,DESIGN_SHAPE_SQUARE};
	
	public GeneDesignShape(int shape, String name, String abbr, String descr){
		super(shape, name, abbr, descr);
		//setAlleleDominances(new Gene[]{DESIGN_SHAPE_CIRCLE,DESIGN_SHAPE_TRIANGLE,DESIGN_SHAPE_SQUARE});
	}
	
}
