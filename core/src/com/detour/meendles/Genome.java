package com.detour.meendles;

import java.util.Random;

public class Genome {
	
	Gene[][] mGenome = new Gene[2][GENOME_LENGTH];
	public static final Gene[][] mCompleteGenome = new Gene[][]{GeneBodyColor.ALLELES,GeneBodyShape.ALLELES,GeneDesignColor.ALLELES,GeneDesignShape.ALLELES}; //TODO needs generated
	private static boolean isInitialized = false;
	
	int mBodyColor;
	int mBodyShape;
	int mDesignColor;
	int mDesignShape;
	
	public static final int GENOME_LENGTH = mCompleteGenome.length;
	public static final int CHROMATID_RIGHT = 1; //father
	public static final int CHROMATID_LEFT = 0; //mother
	
	public Genome(Gene[][] genome){
		mGenome = genome;
		initializeGenome(mCompleteGenome);
	}
	
	public Genome(Meendle mother, Meendle father){
		initializeGenome(mCompleteGenome);
		generateFromParents(mother, father);
	}
	
	public Gene[][] getGenome(){
		return mGenome;
	}
	
	public void setHomozygousGene(Gene gene){
		mGenome[0][gene.mLocation] = gene;
		mGenome[1][gene.mLocation] = gene;
	}
	
	public void setHeterozygousGene(Gene leftGene, Gene rightGene){
		mGenome[CHROMATID_LEFT][leftGene.mLocation] = leftGene;
		mGenome[CHROMATID_RIGHT][rightGene.mLocation] = rightGene;
	}
	
	private Gene getRandomGene(int location){
		if(Math.random() < 0.5f){
			return mGenome[CHROMATID_LEFT][location];
		}else{
			return mGenome[CHROMATID_RIGHT][location];
		}
	}
	
	public static Gene[][] generateRandomGenome(){
		Gene[][] geno = new Gene[2][GENOME_LENGTH];
		Random r = new Random();
		for(int i=0;i<Genome.GENOME_LENGTH;i++){
			geno[CHROMATID_LEFT][i] = mCompleteGenome[i][r.nextInt(mCompleteGenome[i].length)];
			geno[CHROMATID_RIGHT][i] = mCompleteGenome[i][r.nextInt(mCompleteGenome[i].length)];
		}
		return geno;
	}
	
	private void generateFromParents(Meendle mother, Meendle father){
		for(int i=0;i<GENOME_LENGTH;i++){
			mGenome[CHROMATID_LEFT][i] = mother.getGenome().getRandomGene(i);
			mGenome[CHROMATID_RIGHT][i] = father.getGenome().getRandomGene(i);
		}
	}
	
	private static void initializeGenome(Gene[][] genome){
		if(!isInitialized){
			for(int i = 0;i<genome.length;i++){
				for(int j = 0;j<genome[i].length;j++){
					genome[i][j].setLocation(i);
				}
			}
			isInitialized = true;
		}
	}
	
}
