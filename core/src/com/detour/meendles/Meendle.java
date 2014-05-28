package com.detour.meendles;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Meendle extends Sprite{
	
	private Genome mGenome = null;
	Texture mBody = null;
	Texture mDesign = null;
	Texture mSelected = SELECTED;
	private boolean isSelected = false;
	public static final float WIDTH = 100;
	public static final float HEIGHT = 100;
	
	public static final Texture RED_CIRCLE = new Texture("redcircle.png");
	public static final Texture RED_TRIANGLE = new Texture("redtriangle.png");
	public static final Texture RED_SQUARE = new Texture("redsquare.png");
	public static final Texture YELLOW_CIRCLE = new Texture("yellowcircle.png");
	public static final Texture YELLOW_TRIANGLE = new Texture("yellowtriangle.png");
	public static final Texture YELLOW_SQUARE = new Texture("yellowsquare.png");
	public static final Texture BLUE_CIRCLE = new Texture("bluecircle.png");
	public static final Texture BLUE_TRIANGLE = new Texture("bluetriangle.png");
	public static final Texture BLUE_SQUARE = new Texture("bluesquare.png");
	public static final Texture SELECTED = new Texture("selected.png");
	public static final Texture UGLY = new Texture("ugly.png");
	
	public Meendle(float x, float y){
		mPosX = x;
		mPosY = y;
		if(mGenome!=null){
			createFromGenome(mGenome);
		}else{
			createRandom();
		}
	}
	
	public Meendle(float x, float y, Genome genome){
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
		if(isSelected){
			sb.draw(mSelected, mPosX-2, mPosY-2, WIDTH+4, HEIGHT+4);
		}
		sb.draw(mBody, mPosX, mPosY, WIDTH, HEIGHT);
		sb.draw(mDesign, mPosX+WIDTH/4f, mPosY+HEIGHT/4f, WIDTH/2f, HEIGHT/2f);
		
		/*for(BodyPart root: mBodyParts){
			if(root.isRoot()){
				root.draw();
			}
		}*/
	}
	
	public void createRandom(){
		mGenome = new Genome(Genome.generateRandomGenome());
		createFromGenome(mGenome);
	}
	
	public void createFromGenome(Genome genome){
		Gene[][] geno = genome.getGenome();
		Gene[] pheno = new Gene[Genome.GENOME_LENGTH];
		for(int i=0;i<Genome.GENOME_LENGTH;i++){
			Gene.setAlleleDominances(Genome.mCompleteGenome[i]);
			if(geno[Genome.CHROMATID_LEFT][i].getDominanceFactor()>=geno[Genome.CHROMATID_RIGHT][i].getDominanceFactor()){
				pheno[i] = geno[Genome.CHROMATID_LEFT][i];
			}else{
				pheno[i] = geno[Genome.CHROMATID_RIGHT][i];
			}
		}
		
		for(int i=0;i<Genome.GENOME_LENGTH;i++){
			System.out.print(((GeneTypeSingleTrait)geno[Genome.CHROMATID_LEFT][i]).mTrait);
			System.out.print(((GeneTypeSingleTrait)geno[Genome.CHROMATID_RIGHT][i]).mTrait);
			System.out.print(" ");
		}
		System.out.println();
		for(int i=0;i<pheno.length;i++){
			System.out.print(((GeneTypeSingleTrait)pheno[i]).mTrait + "  ");
		}
		System.out.println();
		
		if(((GeneTypeSingleTrait)pheno[0]).getTrait()==GeneBodyColor.RED){
			if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.CIRCLE){
				mBody = RED_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.TRIANGLE){
				mBody = RED_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.SQUARE){
				mBody = RED_SQUARE;
			}
		}else if(((GeneTypeSingleTrait)pheno[0]).getTrait()==GeneBodyColor.YELLOW){
			if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.CIRCLE){
				mBody = YELLOW_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.TRIANGLE){
				mBody = YELLOW_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.SQUARE){
				mBody = YELLOW_SQUARE;
			}
		}else if(((GeneTypeSingleTrait)pheno[0]).getTrait()==GeneBodyColor.BLUE){
			if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.CIRCLE){
				mBody = BLUE_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.TRIANGLE){
				mBody = BLUE_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[1]).getTrait()==GeneBodyShape.SQUARE){
				mBody = BLUE_SQUARE;
			}
		}
		
		if(((GeneTypeSingleTrait)pheno[2]).getTrait()==GeneDesignColor.RED){
			if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.CIRCLE){
				mDesign = RED_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.TRIANGLE){
				mDesign = RED_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.SQUARE){
				mDesign = RED_SQUARE;
			}
		}else if(((GeneTypeSingleTrait)pheno[2]).getTrait()==GeneDesignColor.YELLOW){
			if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.CIRCLE){
				mDesign = YELLOW_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.TRIANGLE){
				mDesign = YELLOW_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.SQUARE){
				mDesign = YELLOW_SQUARE;
			}
		}else if(((GeneTypeSingleTrait)pheno[2]).getTrait()==GeneDesignColor.BLUE){
			if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.CIRCLE){
				mDesign = BLUE_CIRCLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.TRIANGLE){
				mDesign = BLUE_TRIANGLE;
			}else if(((GeneTypeSingleTrait)pheno[3]).getTrait()==GeneDesignShape.SQUARE){
				mDesign = BLUE_SQUARE;
			}
		}
	}
	
	public Genome getGenome(){
		return mGenome;
	}
	
	public void setGenome(Genome genome){
		mGenome = genome;
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
