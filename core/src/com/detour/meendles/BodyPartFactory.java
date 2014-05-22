package com.detour.meendles;

import java.util.ArrayList;

public class BodyPartFactory {
	
	private static final BodyPartFactory mBodyPartFactory = new BodyPartFactory();
	
	private BodyPartFactory(){
		
	}
	
	public static BodyPartFactory getBodyPartFactory(){
		return mBodyPartFactory;
	}
	
	public BodyPart createRootBodyPart(Meendle meendle){
		BodyPart bp = new BodyPart(meendle);
		
		return bp;
	}
	
	public BodyPart createRootBodyPart(Meendle meendle, ArrayList<BodyPart> children){
		BodyPart bp = new BodyPart(meendle, children);
		
		return bp;
	}
	
}
