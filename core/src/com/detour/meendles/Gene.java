package com.detour.meendles;

public abstract class Gene {
	
	private int mLocation;
	private String mName;
	private String mAbbreviation;
	private String mDescription;
	
	private int mAlleleNumber;
	private float mDominance;
	
	public Gene(String name, String abbr, String descr){
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
	
	public int getLocation(){
		return mLocation;
	}
	
	public void setLocation(int location){
		mLocation = location;
	}
	
	public int getAlleleNumber(){
		return mAlleleNumber;
	}
	
	public void setAlleleNumber(int alleleNumber){
		mAlleleNumber = alleleNumber;
	}
	
	public float getDominanceFactor(){
		return mDominance;
	}
	
	public String getName(){
		return mName;
	}
	
	public String getAbbreviation(){
		return mAbbreviation;
	}
	
	public String getDescription(){
		return mDescription;
	}
	
}
