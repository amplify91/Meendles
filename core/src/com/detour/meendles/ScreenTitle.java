package com.detour.meendles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;

public class ScreenTitle implements Screen{
	
	SpriteBatch batch;
	Texture breed;
	
	static int width;
	static int w;
	static int height;
	
	static Meendle mPet1;
	static Meendle mPet2;
	static Meendle mPet3;
	static Meendle mPet4;
	static Meendle mPet5;
	static Meendle mPet6;
	
	ShaderProgram program;
	
	public static Meendle[] mPets;
	
	Camera2D mCamera;
	//SpriteBatch mSpriteBatch = new SpriteBatch();
	
	boolean once = false;
	
	@Override
	public void render(float delta) {
		//mSpriteBatch.setProjectionMatrix(mCamera.getCamera().combined);
		
		if(!once){
			resume();
			once = true;
		}
		
		batch.begin();
		program.setAttributef("a_color1", 1f, 0f, 0f, 0f);
	    program.setAttributef("a_color2", 0f, 1f, 0f, 0f);
	    program.setAttributef("a_color3", 0f, 0f, 1f, 0f);
		batch.draw(breed, width/3f, height - (width/3f), width/3f, width/3f);
		mPet1.draw(batch);
		mPet2.draw(batch);
		mPet3.draw(batch);
		mPet4.draw(batch);
		mPet5.draw(batch);
		mPet6.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		mCamera = new Camera2D(width, height);
		mCamera.setScreenSizePixels(width, height);
		
	}

	@Override
	public void show() {
		Gdx.input.setInputProcessor(new Input());
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
		try {
			
			FileHandle vertex = Gdx.files.internal("shaders/vert.txt");
			FileHandle fragment = Gdx.files.internal("shaders/frag.txt");
		    //create our shader program -- be sure to pass SpriteBatch's default attributes!
		    program = new ShaderProgram(vertex, fragment);
		    

		    //Good idea to log any warnings if they exist
		    if (program.getLog().length()!=0)
		        System.out.println(program.getLog());

		    //create our sprite batch
		    batch = new SpriteBatch(1000, program);
		} catch (Exception e) { 
			System.out.println("Shader's fucked.");
		}
		
		breed = new Texture("breed.png");
		width = Gdx.graphics.getWidth();
		w = width/6;
		height = Gdx.graphics.getHeight();
		Gdx.input.setInputProcessor(new Input());
		init();
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
	
	private static void init(){
		
		//int h = height/6;
		
		mPet1 = new Meendle(0, 0);
		mPet2 = new Meendle(w, 0);
		mPet3 = new Meendle(w*2, 0);
		mPet4 = new Meendle(w*3, 0);
		mPet5 = new Meendle(w*4, 0);
		mPet6 = new Meendle(w*5, 0);
		mPets = new Meendle[]{mPet1,mPet2,mPet3,mPet4,mPet5,mPet6};
		
		
	}
	
	public static void breedNewGeneration(){
		
		Meendle mother=null;
		Meendle father=null;
		for(int i=0;i<mPets.length;i++){
			if(mPets[i].isSelected()){
				mother = mPets[i];
			}
		}
		for(int i=mPets.length-1;i>-1;i--){
			if(mPets[i].isSelected()){
				father = mPets[i];
			}
		}
		if(mother!=null && father!=null){
			mPet1 = new Meendle(0, 0, mother, father);
			mPet2 = new Meendle(w, 0, mother, father);
			mPet3 = new Meendle(w*2, 0, mother, father);
			mPet4 = new Meendle(w*3, 0, mother, father);
			mPet5 = new Meendle(w*4, 0, mother, father);
			mPet6 = new Meendle(w*5, 0, mother, father);
			mPets = new Meendle[]{mPet1,mPet2,mPet3,mPet4,mPet5,mPet6};
		}else{
			init();
		}
	}

}
