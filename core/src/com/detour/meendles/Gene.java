package com.detour.meendles;

public class Gene {
	
	int mLocation;
	String mName;
	String mAbbreviation;
	String mDescription;
	
	float mDominance;
	
	public Gene(int location, String name, String abbr, String descr){
		mLocation = location;
		mName = name;
		mAbbreviation = abbr;
		mDescription = descr;
	}
	
	public static void setAlleleDominances(Gene[] alleles){
		//arrange least to most dominant
		float x = 1.0f / (float)alleles.length;
		for(int i=0;i<alleles.length;i++){
			alleles[i].mDominance = (float)(i+1) * x;
		}
		
	}
	
	public float getDominanceFactor(){
		return mDominance;
	}
	
}
