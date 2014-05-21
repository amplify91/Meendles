package com.detour.meendles;

public abstract class GeneTypeSingleTrait extends Gene{
	
	int mTrait;
	
	public GeneTypeSingleTrait(int trait, int location, String name, String abbr, String descr){
		super(location, name, abbr, descr);
		mTrait = trait;
	}
	
	public int getTrait(){
		return mTrait;
	}
	
}
