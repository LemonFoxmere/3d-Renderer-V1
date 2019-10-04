package com.gdf4.game.model.ThreeD.Line;

import com.gdf4.framework.util.Calculate3DLoc;
import com.gdf4.game.state.MenuState;

public class lineStandard {

	private int v1x, v1y, v2x, v2y, x1, y1, z1, x2, y2, z2;
	
	public lineStandard(int x1,int y1, int z1, int x2, int y2, int z2) {
		this.x1 = x1;
		this.y1 = y1;
		this.z1 = z1;
		this.x2 = x2;
		this.y2 = y2;
		this.z2 = z2;
	}

	public void update() {
		
		int x1 = (int) (this.x1 - Math.cos(Math.toRadians(MenuState.verticleRot))*((Math.cos(Math.toRadians(MenuState.getHorizontalRot())))*(this.x1*MenuState.dof/100)*this.y1));
		int y1 = (int) (this.y1 - Math.cos(Math.toRadians(MenuState.verticleRot))*(Math.sin(Math.toRadians(MenuState.getHorizontalRot()))*(this.y1*MenuState.dof/100)*this.x1));
		int x2 = (int) (this.x2 - Math.cos(Math.toRadians(MenuState.verticleRot))*((Math.cos(Math.toRadians(MenuState.getHorizontalRot())))*(this.x2*MenuState.dof/100)*this.y2));
		int y2 = (int) (this.y2 - Math.cos(Math.toRadians(MenuState.verticleRot))*(Math.sin(Math.toRadians(MenuState.getHorizontalRot()))*(this.y2*MenuState.dof/100)*this.x2));
		
		v1x = (int) Calculate3DLoc.xOn3D(MenuState.getPosX(), x1, y1, z1, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
		v1y = (int) Calculate3DLoc.yOn3D(MenuState.getPosY(), x1, y1, z1, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
		v2x = (int) Calculate3DLoc.xOn3D(MenuState.getPosX(), x2, y2, z2, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
		v2y = (int) Calculate3DLoc.yOn3D(MenuState.getPosY(), x2, y2, z2, MenuState.getOffSet(), MenuState.getHorizontalRot(), MenuState.verticleRot);
	}
	
	public int getV1x() {
		return v1x;
	}

	public void setV1x(int v1x) {
		this.v1x = v1x;
	}

	public int getV1y() {
		return v1y;
	}

	public void setV1y(int v1y) {
		this.v1y = v1y;
	}

	public int getV2x() {
		return v2x;
	}

	public void setV2x(int v2x) {
		this.v2x = v2x;
	}

	public int getV2y() {
		return v2y;
	}

	public void setV2y(int v2y) {
		this.v2y = v2y;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}

}
