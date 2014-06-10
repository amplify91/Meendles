package com.detour.meendles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.esotericsoftware.spine.AnimationState;
import com.esotericsoftware.spine.AnimationStateData;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;

public class Meendle extends Sprite{
	
	private MeendleData mData;
	private static MeendleRenderer mRenderer = new MeendleRenderer();//TODO
	public Skeleton mSkeleton;
	private AnimationState mState;
	private static TextureAtlas mMeendlesTextureAtlas = new TextureAtlas(Gdx.files.internal("spine/skeleton.atlas"));
	
	private Genome mGenome = null;
	Texture mBody = null;
	Texture mDesign = null;
	//Texture mSelected = SELECTED;
	private boolean isSelected = false;
	public static final float WIDTH = Gdx.graphics.getWidth() / 8f;
	public static final float HEIGHT = WIDTH;
	
	public Meendle(){
		SkeletonJson json = new SkeletonJson(mMeendlesTextureAtlas); // This loads skeleton JSON data, which is stateless.
		json.setScale(0.6f); // Load the skeleton at 60% the size it was in Spine.
		SkeletonData skeletonData = json.readSkeletonData(Gdx.files.internal("spine/skeleton.json"));

		mSkeleton = new Skeleton(skeletonData); // Skeleton holds skeleton state (bone positions, slot attachments, etc).
		mSkeleton.updateWorldTransform();

		AnimationStateData stateData = new AnimationStateData(skeletonData); // Defines mixing (crossfading) between animations.
		//stateData.setMix("run", "jump", 0.2f);
		//stateData.setMix("jump", "run", 0.2f);

		mState = new AnimationState(stateData); // Holds the animation state for a skeleton (current animation, time, etc).
		//mState.setTimeScale(0.5f); // Slow all animations down to 50% speed.
		//mState.setAnimation(0, "run", true);
		//mState.addAnimation(0, "jump", false, 2); // Jump after 2 seconds.
		//mState.addAnimation(0, "run", true, 0); // Run after the jump.
		mData = new MeendleData(this);
	}
	
	public Meendle(float x, float y){
		this();
		mPosX = x;
		mPosY = y;
		create();
	}
	
	public Meendle(float x, float y, Genome genome){
		this();
		mPosX = x;
		mPosY = y;
		createFromGenome(genome);
	}
	
	public Meendle(float x, float y, Meendle mother, Meendle father){
		mPosX = x;
		mPosY = y;
		mGenome = new Genome(mother, father);
		createFromGenome(mGenome);
	}
	
	public void draw(SpriteBatch sb){
		
	}
	
	public void draw(SpriteBatch batch, ShaderProgram shader){
		mRenderer.setMeendle(this);
		mRenderer.draw(batch, mSkeleton, shader);
	}
	
	public void update(){
		mSkeleton.setPosition(mPosX, mPosY);
	}
	
	public Vector3[] getBodyPartColors(String name){
		switch(name){
		case "head": return new Vector3[]{mData.headColor1,mData.headColor2,mData.headColor3};
		case "body": return new Vector3[]{mData.bodyColor1,mData.bodyColor2,mData.bodyColor3};
		default: return new Vector3[]{mData.headColor1,mData.headColor2,mData.headColor3};
		}
		
	}
	
	public void create(){
		if(mGenome==null){
			mGenome = new Genome(Genome.generateRandomGenome());
		}
		createFromGenome(mGenome);
	}
	
	private void createFromGenome(Genome genome){
		Gene[][] geno = genome.getGenome();
		Gene[] pheno = new Gene[Genome.GENOME_LENGTH];
		for(int i=0;i<Genome.GENOME_LENGTH;i++){
			if(geno[Genome.CHROMATID_LEFT][i].getDominanceFactor()>=geno[Genome.CHROMATID_RIGHT][i].getDominanceFactor()){
				pheno[i] = geno[Genome.CHROMATID_LEFT][i];
			}else{
				pheno[i] = geno[Genome.CHROMATID_RIGHT][i];
			}
		}
		for(int i=0;i<Genome.GENOME_LENGTH;i++){
			pheno[i].build(this);
		}
		mSkeleton.setAttachment("head", mData.headShape+mData.pattern+mData.skinType);
		mSkeleton.setAttachment("body", mData.bodyShape+mData.pattern+mData.skinType);
		//mSkeleton.setAttachment("tail", mData.tailShape+mData.pattern+mData.skinType);
		mSkeleton.updateWorldTransform();
		createName();
	}
	
	private void createName(){
		//TODO
	}
	
	public MeendleData getData(){
		return mData;
	}
	
	public Genome getGenome(){
		return mGenome;
	}
	
	public void setGenome(Genome genome){
		mGenome = genome;
	}
	
	public Skeleton getSkeleton(){
		return mSkeleton;
	}
	
	public void setSkeleton(Skeleton skeleton){
		mSkeleton = skeleton;
	}
	
	public void toggleSelected(){
		if(isSelected){
			isSelected = false;
		}else{
			isSelected = true;
		}
	}
	
	public boolean isSelected(){
		return isSelected;
	}
	
}
