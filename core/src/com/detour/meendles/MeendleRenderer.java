package com.detour.meendles;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.Bone;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.Slot;
import com.esotericsoftware.spine.attachments.Attachment;
import com.esotericsoftware.spine.attachments.MeshAttachment;
import com.esotericsoftware.spine.attachments.RegionAttachment;
import com.esotericsoftware.spine.attachments.SkeletonAttachment;
import com.esotericsoftware.spine.attachments.SkinnedMeshAttachment;

public class MeendleRenderer extends SkeletonRenderer{
	
	private final static int RED = 0;
	private final static int BLUE = 1;
	private final static int GREEN = 2;
	
	private Meendle mMeendle;
	
	@SuppressWarnings("null")
	public void draw(PolygonSpriteBatch batch, Skeleton skeleton, ShaderProgram shader){
		
		boolean premultipliedAlpha = this.premultipliedAlpha;
		int srcFunc = premultipliedAlpha ? GL20.GL_ONE : GL20.GL_SRC_ALPHA;
		batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);

		boolean additive = false;

		float[] vertices = null;
		short[] triangles = null;
		Array<Slot> drawOrder = skeleton.getDrawOrder();
		for (int i = 0, n = drawOrder.size; i < n; i++) {
			Slot slot = drawOrder.get(i);
			setColors(slot.getData().getName(), shader, batch);
			Attachment attachment = slot.getAttachment();
			Texture texture = null;
			if (attachment instanceof RegionAttachment) {
				RegionAttachment region = (RegionAttachment)attachment;
				region.updateWorldVertices(slot, premultipliedAlpha);
				vertices = region.getWorldVertices();
				triangles = quadTriangles;
				texture = region.getRegion().getTexture();
				//setColors(region.getName(), shader, batch);

			} else if (attachment instanceof MeshAttachment) {
				MeshAttachment mesh = (MeshAttachment)attachment;
				mesh.updateWorldVertices(slot, true);
				vertices = mesh.getWorldVertices();
				triangles = mesh.getTriangles();
				texture = mesh.getRegion().getTexture();
				//setColors(mesh.getName(), shader, batch);

			} else if (attachment instanceof SkinnedMeshAttachment) {
				SkinnedMeshAttachment mesh = (SkinnedMeshAttachment)attachment;
				mesh.updateWorldVertices(slot, true);
				vertices = mesh.getWorldVertices();
				triangles = mesh.getTriangles();
				texture = mesh.getRegion().getTexture();
				//setColors(mesh.getName(), shader, batch);

			} else if (attachment instanceof SkeletonAttachment) {
				Skeleton attachmentSkeleton = ((SkeletonAttachment)attachment).getSkeleton();
				if (attachmentSkeleton == null) continue;
				Bone bone = slot.getBone();
				Bone rootBone = attachmentSkeleton.getRootBone();
				float oldScaleX = rootBone.getScaleX();
				float oldScaleY = rootBone.getScaleY();
				float oldRotation = rootBone.getRotation();
				attachmentSkeleton.setPosition(skeleton.getX() + bone.getWorldX(), skeleton.getY() + bone.getWorldY());
				rootBone.setScaleX(1 + bone.getWorldScaleX() - oldScaleX);
				rootBone.setScaleY(1 + bone.getWorldScaleY() - oldScaleY);
				rootBone.setRotation(oldRotation + bone.getWorldRotation());
				attachmentSkeleton.updateWorldTransform();

				draw(batch, attachmentSkeleton);

				attachmentSkeleton.setPosition(0, 0);
				rootBone.setScaleX(oldScaleX);
				rootBone.setScaleY(oldScaleY);
				rootBone.setRotation(oldRotation);
			}

			if (texture != null) {
				if (slot.data.getAdditiveBlending() != additive) {
					additive = !additive;
					if (additive)
						batch.setBlendFunction(srcFunc, GL20.GL_ONE);
					else
						batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
				}
				batch.draw(texture, vertices, 0, vertices.length, triangles, 0, triangles.length);//TODO
			}
		}
		
	}
	
	public void draw(Batch batch, Skeleton skeleton, ShaderProgram shader){
		
		boolean premultipliedAlpha = this.premultipliedAlpha;
		int srcFunc = premultipliedAlpha ? GL20.GL_ONE : GL20.GL_SRC_ALPHA;
		batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);

		boolean additive = false;

		Array<Slot> drawOrder = skeleton.getDrawOrder();
		for (int i = 0, n = drawOrder.size; i < n; i++) {
			Slot slot = drawOrder.get(i);
			setColors(slot.getData().getName(), shader, batch);
			Attachment attachment = slot.getAttachment();
			if (attachment instanceof RegionAttachment) {
				RegionAttachment regionAttachment = (RegionAttachment)attachment;
				regionAttachment.updateWorldVertices(slot, premultipliedAlpha);
				float[] vertices = regionAttachment.getWorldVertices();
				if (slot.data.getAdditiveBlending() != additive) {
					additive = !additive;
					if (additive)
						batch.setBlendFunction(srcFunc, GL20.GL_ONE);
					else
						batch.setBlendFunction(srcFunc, GL20.GL_ONE_MINUS_SRC_ALPHA);
				}
				//setColors(regionAttachment.getName(), shader, batch);
				batch.draw(regionAttachment.getRegion().getTexture(), vertices, 0, 20);//TODO
			} else if (attachment instanceof MeshAttachment || attachment instanceof SkinnedMeshAttachment) {
				throw new RuntimeException("PolygonSpriteBatch is required to render meshes.");
			} else if (attachment instanceof SkeletonAttachment) {
				Skeleton attachmentSkeleton = ((SkeletonAttachment)attachment).getSkeleton();
				if (attachmentSkeleton == null) continue;
				Bone bone = slot.getBone();
				Bone rootBone = attachmentSkeleton.getRootBone();
				float oldScaleX = rootBone.getScaleX();
				float oldScaleY = rootBone.getScaleY();
				float oldRotation = rootBone.getRotation();
				attachmentSkeleton.setPosition(skeleton.getX() + bone.getWorldX(), skeleton.getY() + bone.getWorldY());
				rootBone.setScaleX(1 + bone.getWorldScaleX() - oldScaleX);
				rootBone.setScaleY(1 + bone.getWorldScaleY() - oldScaleY);
				rootBone.setRotation(oldRotation + bone.getWorldRotation());
				attachmentSkeleton.updateWorldTransform();

				draw(batch, attachmentSkeleton);

				attachmentSkeleton.setX(0);
				attachmentSkeleton.setY(0);
				rootBone.setScaleX(oldScaleX);
				rootBone.setScaleY(oldScaleY);
				rootBone.setRotation(oldRotation);
			}
		}
	}
	
	private void setColors(String name, ShaderProgram shader, Batch batch){
		Vector3[] colors = mMeendle.getBodyPartColors(name);
		if(colors==null || !shader.isCompiled() || colors.length != 3){
			//error
		}else{
			batch.flush();//TODO hopefully don't have to do this. Watch that it is not changing colors of previous draw.
			shader.setAttributef("a_color1", colors[RED].x, colors[RED].y, colors[RED].z, 0f);
		    shader.setAttributef("a_color2", colors[BLUE].x, colors[BLUE].y, colors[BLUE].z, 0f);
		    shader.setAttributef("a_color3", colors[GREEN].x, colors[GREEN].y, colors[GREEN].z, 0f);
		}
	}
	
	public void setMeendle(Meendle meendle){
		mMeendle = meendle;
	}
	
}
