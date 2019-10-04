package com.gdf4.game.model.ThreeD.Vertex;

import com.gdf4.framework.util.Calculate3DLoc;
import com.gdf4.game.state.MenuState;
import java.lang.Math;

public class VtxStandard{
	
	private int x, y, z;
	public int ScrX, ScrY;
	
	public VtxStandard(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
//		ScrX = Calculate3DLoc.xOn3D(MenuState.getPosX(), x, y, z, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.getVerticleRot());
//		ScrY = Calculate3DLoc.yOn3D(MenuState.getPosY(), x, y, z, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.getVerticleRot());
	}
	
	public void update() {
		float x = (float) -(this.x+(-Math.cos(Math.toRadians(MenuState.getHorizontalRot())))*(this.x*MenuState.dof/100)*this.y);
		float y = (float) -(this.y - Math.sin(Math.toRadians(MenuState.getHorizontalRot()))*(this.y*MenuState.dof/100)*this.x);
		float z = (float) (0.5*this.z);
		ScrX = (int) Calculate3DLoc.xOn3D(MenuState.getPosX(), x, y, z, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
		ScrY = (int) Calculate3DLoc.yOn3D(MenuState.getPosY(), x, y, z, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	public void setZ(int newZ) {
		this.x = newZ;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getZ() {
		return z;
	}
	public int getScrX(){
		return ScrX;
	}
	public int getScrY(){
		return ScrY;
	}

}
