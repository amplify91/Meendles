package com.detour.meendles;

import com.badlogic.gdx.math.Vector3;

public class MeendleData {
	Meendle meendle;
	//save data
	String name;
	int[][] genome;
	long lastUpdated;
	int health;
	int energy;
	int novaDust;
	float strengthEarned;
	float skillEarned;
	//gene data
	public String headShape = "";
	public float headScale;
	public Vector3 headColor1;
	public Vector3 headColor2;
	public Vector3 headColor3;
	public String bodyShape = "";
	public float bodyScale;
	public Vector3 bodyColor1;
	public Vector3 bodyColor2;
	public Vector3 bodyColor3;
	public String tailShape = "";
	public float tailScale;
	public Vector3 tailColor1;
	public Vector3 tailColor2;
	public Vector3 tailColor3;
	public String skinType = "";
	public String pattern = "";
	public int colorPallet;
	
	public MeendleData(Meendle meendle){
		this.meendle = meendle;
	}
	
	public MeendleData(MeendleData data){
		meendle = data.meendle;
		name = data.name;
		genome = data.genome;
		lastUpdated = data.lastUpdated;
		health = data.health;
		energy = data.energy;
		novaDust = data.novaDust;
		strengthEarned = data.strengthEarned;
		skillEarned = data.skillEarned;
	}
	
	public void save(){
		
	}
	
	public void load(){
		
	}
	
}
