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
	
	public abstract void build(Meendle meendle);
	
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
	
	public void setDominanceFactor(float dominance){
		mDominance = dominance;
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
