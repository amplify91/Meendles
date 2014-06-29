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
	public String eyesShape = "";
	public float eyesScale;
	public Vector3 eyesColor1;
	public Vector3 eyesColor2;
	public Vector3 eyesColor3;
	public String eyebrowsShape = "";
	public float eyebrowsScale;
	public Vector3 eyebrowsColor1;
	public Vector3 eyebrowsColor2;
	public Vector3 eyebrowsColor3;
	public String noseShape = "";
	public float noseScale;
	public Vector3 noseColor1;
	public Vector3 noseColor2;
	public Vector3 noseColor3;
	public String mouthShape = "";
	public float mouthScale;
	public Vector3 mouthColor1;
	public Vector3 mouthColor2;
	public Vector3 mouthColor3;
	public String hatShape = "";
	public float hatScale;
	public Vector3 hatColor1;
	public Vector3 hatColor2;
	public Vector3 hatColor3;
	public String earsShape = "";
	public float earsScale;
	public Vector3 earsColor1;
	public Vector3 earsColor2;
	public Vector3 earsColor3;
	public String hairShape = "";
	public float hairScale;
	public Vector3 hairColor1;
	public Vector3 hairColor2;
	public Vector3 hairColor3;
	public String facialHairShape = "";
	public float facialHairScale;
	public Vector3 facialHairColor1;
	public Vector3 facialHairColor2;
	public Vector3 facialHairColor3;
	public String armsShape = "";
	public float armsScale;
	public Vector3 armsColor1;
	public Vector3 armsColor2;
	public Vector3 armsColor3;
	public String handsShape = "";
	public float handsScale;
	public Vector3 handsColor1;
	public Vector3 handsColor2;
	public Vector3 handsColor3;
	public String legsShape = "";
	public float legsScale;
	public Vector3 legsColor1;
	public Vector3 legsColor2;
	public Vector3 legsColor3;
	public String feetShape = "";
	public float feetScale;
	public Vector3 feetColor1;
	public Vector3 feetColor2;
	public Vector3 feetColor3;
	public String wingsShape = "";
	public float wingsScale;
	public Vector3 wingsColor1;
	public Vector3 wingsColor2;
	public Vector3 wingsColor3;
	public String spinesShape = "";
	public float spinesScale;
	public Vector3 spinesColor1;
	public Vector3 spinesColor2;
	public Vector3 spinesColor3;
	public String posteriorShape = "";
	public float posteriorScale;
	public Vector3 posteriorColor1;
	public Vector3 posteriorColor2;
	public Vector3 posteriorColor3;
	public String markShape = "";
	public float markScale;
	public Vector3 markColor1;
	public Vector3 markColor2;
	public Vector3 markColor3;
	
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
