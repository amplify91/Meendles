package com.detour.meendles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;

public class BodyPart {
	
	Texture mShape = null;
	Texture mSkin = null;
	
	Meendle mMeendle = null;
	BodyPart mParent = null;
	private ArrayList<BodyPart> mChildren = null;
	private boolean isParent = false;
	private boolean isChild = false;
	private boolean isRoot = false;
	
	public BodyPart(Meendle meendle){
		mMeendle = meendle;
		isRoot = true;
	}
	
	public BodyPart(Meendle meendle, ArrayList<BodyPart> children){
		this(meendle);
		mChildren = children;
		isParent = true;
	}
	
	public BodyPart(BodyPart parent){
		mParent = parent;
		isChild = true;
		mParent.getChildren().add(this);
	}
	
	public BodyPart(BodyPart parent, ArrayList<BodyPart> children){
		this(parent);
		setChildren(children);
		isParent = true;
	}
	
	public void update(){
		if(isParent && mChildren!=null){
			for(BodyPart child: mChildren){
				child.update();
			}
		}
	}
	
	public void draw(){
		if(isParent && mChildren!=null){
			for(BodyPart child: mChildren){
				child.draw();
			}
		}
	}
	
	public boolean isChild(){
		return isChild;
	}
	
	public boolean isParent(){
		return isParent;
	}
	
	public boolean isRoot(){
		return isRoot;
	}
	
	public ArrayList<BodyPart> getChildren(){
		return mChildren;
	}
	
	private void setChildren(ArrayList<BodyPart> children){
		mChildren = children;
	}
	
}
