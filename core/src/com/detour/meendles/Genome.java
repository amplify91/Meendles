package com.detour.meendles;

import java.util.Random;

import com.detour.meendles.genes.GeneBodyColors;
import com.detour.meendles.genes.GeneBodyScale;
import com.detour.meendles.genes.GeneBodyShape;
import com.detour.meendles.genes.GeneEarsColors;
import com.detour.meendles.genes.GeneEarsScale;
import com.detour.meendles.genes.GeneEarsShape;
import com.detour.meendles.genes.GeneEyebrowsColors;
import com.detour.meendles.genes.GeneEyebrowsScale;
import com.detour.meendles.genes.GeneEyebrowsShape;
import com.detour.meendles.genes.GeneEyesColors;
import com.detour.meendles.genes.GeneEyesScale;
import com.detour.meendles.genes.GeneEyesShape;
import com.detour.meendles.genes.GeneFacialHairColors;
import com.detour.meendles.genes.GeneFacialHairScale;
import com.detour.meendles.genes.GeneFacialHairShape;
import com.detour.meendles.genes.GeneHairColors;
import com.detour.meendles.genes.GeneHairScale;
import com.detour.meendles.genes.GeneHairShape;
import com.detour.meendles.genes.GeneHatColors;
import com.detour.meendles.genes.GeneHatScale;
import com.detour.meendles.genes.GeneHatShape;
import com.detour.meendles.genes.GeneHeadColors;
import com.detour.meendles.genes.GeneHeadScale;
import com.detour.meendles.genes.GeneHeadShape;
import com.detour.meendles.genes.GeneMouthColors;
import com.detour.meendles.genes.GeneMouthScale;
import com.detour.meendles.genes.GeneMouthShape;
import com.detour.meendles.genes.GeneNoseColors;
import com.detour.meendles.genes.GeneNoseScale;
import com.detour.meendles.genes.GeneNoseShape;
import com.detour.meendles.genes.GenePattern;
import com.detour.meendles.genes.GeneSkinType;
import com.detour.meendles.genes.GeneTailColors;
import com.detour.meendles.genes.GeneTailScale;
import com.detour.meendles.genes.GeneTailShape;

public class Genome {
	
	private static boolean isInitialized = false;
	
	public static final Gene[][] mCompleteGenome = new Gene[][]{ //TODO possibly change these to enums?
		GeneHeadShape.ALLELES, GeneHeadScale.ALLELES, GeneHeadColors.ALLELES,
		GeneBodyShape.ALLELES, GeneBodyScale.ALLELES, GeneBodyColors.ALLELES,
		GeneTailShape.ALLELES, GeneTailScale.ALLELES, GeneTailColors.ALLELES,
		GenePattern.ALLELES, GeneSkinType.ALLELES,
		GeneEyesShape.ALLELES, GeneEyesScale.ALLELES, GeneEyesColors.ALLELES,
		GeneEyebrowsShape.ALLELES, GeneEyebrowsScale.ALLELES, GeneEyebrowsColors.ALLELES,
		GeneNoseShape.ALLELES, GeneNoseScale.ALLELES, GeneNoseColors.ALLELES,
		GeneMouthShape.ALLELES, GeneMouthScale.ALLELES, GeneMouthColors.ALLELES,
		GeneHatShape.ALLELES, GeneHatScale.ALLELES, GeneHatColors.ALLELES,
		GeneEarsShape.ALLELES, GeneEarsScale.ALLELES, GeneEarsColors.ALLELES,
		GeneHairShape.ALLELES, GeneHairScale.ALLELES, GeneHairColors.ALLELES,
		GeneFacialHairShape.ALLELES, GeneFacialHairScale.ALLELES, GeneFacialHairColors.ALLELES}; //TODO needs generated
	
	public static final int GENOME_LENGTH = mCompleteGenome.length;
	public static final int CHROMATID_RIGHT = 1; //father
	public static final int CHROMATID_LEFT = 0; //mother
	
	Gene[][] mGenome = new Gene[2][GENOME_LENGTH];
	
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
			for(int i = 0;i<GENOME_LENGTH;i++){
				float x = 1.0f / (float)genome[i].length;
				for(int j = 0;j<genome[i].length;j++){
					genome[i][j].setLocation(i);
					genome[i][j].setAlleleNumber(j);
					genome[i][j].setDominanceFactor((float)(j+1) * x);
				}
				
			}
			isInitialized = true;
		}
	}
	
}
