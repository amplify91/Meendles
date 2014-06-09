package com.detour.meendles;

import java.util.Random;

import com.detour.meendles.genes.GeneBodyColor;
import com.detour.meendles.genes.GeneBodyShape;
import com.detour.meendles.genes.GeneDesignColor;
import com.detour.meendles.genes.GeneDesignShape;

public class Genome {
	
	Gene[][] mGenome = new Gene[2][GENOME_LENGTH];
	public static final Gene[][] mCompleteGenome = new Gene[][]{GeneBodyColor.ALLELES,GeneBodyShape.ALLELES,GeneDesignColor.ALLELES,GeneDesignShape.ALLELES}; //TODO needs generated
	private static boolean isInitialized = false;
	
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
		mGenome[0][gene.getLocation()] = gene;
		mGenome[1][gene.getLocation()] = gene;
	}
	
	public void setHeterozygousGene(Gene leftGene, Gene rightGene){
		mGenome[CHROMATID_LEFT][leftGene.getLocation()] = leftGene;
		mGenome[CHROMATID_RIGHT][rightGene.getLocation()] = rightGene;
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
	
	public void generateGenomeFromData(int[][] data){
		//uses an array of ints to represent which allele to put in each spot of the genome.
		for(int i=0;i<GENOME_LENGTH;i++){
			if(data[CHROMATID_LEFT][i]<mCompleteGenome[i].length && data[CHROMATID_RIGHT][i]<mCompleteGenome[i].length){
				mGenome[CHROMATID_LEFT][i] = mCompleteGenome[i][data[CHROMATID_LEFT][i]];
				mGenome[CHROMATID_RIGHT][i] = mCompleteGenome[i][data[CHROMATID_RIGHT][i]];
			}else{
				//error. data represents an allele that doesn't exist. number is wrong.
			}
		}
	}
	
	public int[][] getSaveData(){
		int[][] genome = new int[2][GENOME_LENGTH];
		for(int i = 0;i<genome[0].length;i++){
			genome[CHROMATID_LEFT][i] = mGenome[CHROMATID_LEFT][i].getAlleleNumber();
			genome[CHROMATID_RIGHT][i] = mGenome[CHROMATID_RIGHT][i].getAlleleNumber();
		}
		return genome;
	}
	
	private static void initializeGenome(Gene[][] genome){
		if(!isInitialized){
			for(int i = 0;i<genome.length;i++){
				for(int j = 0;j<genome[i].length;j++){
					genome[i][j].setLocation(i);
					genome[i][j].setAlleleNumber(j);
				}
			}
			isInitialized = true;
		}
	}
	
}
