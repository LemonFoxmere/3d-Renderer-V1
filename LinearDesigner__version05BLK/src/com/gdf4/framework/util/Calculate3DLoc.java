package com.gdf4.framework.util;

import java.lang.Math;

public class Calculate3DLoc {
	
	//functions:
	//Xx=-cos(ofs)*cos(hRot)+sin(ofs)*sin(hRot)*sin(vRot)
	//Xy=-cos(ofs)*sin(hRot)*sin(vRot)-sin(ofs)*cos(hRot)
	//Yx=cos(ofs)*sin(hRot)+sin(ofs)*cos(hRot)*sin(vRot)
	//Yy=cos(ofs)*cos(hRot)*sin(vRot)+sin(ofs)*sin(hRot)
	//Zx=sin(ofs)*cos(vRot)
	//Zy=-cos(ofs)*cos(vRot)
	
	//z * Math.cos(Math.toRadians(ofs)) * Math.cos(Math.toRadians(vRot))
	
	public static float xOn3D (float posX, float x, float y, float z, float ofs, float hRot, float vRot) {
		return (float) (-((x * Math.cos(Math.toRadians(ofs)) * Math.cos(Math.toRadians(hRot)) - Math.sin(Math.toRadians(ofs)) * Math.sin(Math.toRadians(hRot)) * Math.sin(Math.toRadians(vRot))) + 
				(y * -Math.cos(Math.toRadians(ofs)) * Math.sin(Math.toRadians(hRot)) - Math.sin(Math.toRadians(ofs)) * Math.cos(Math.toRadians(hRot)) * Math.sin(Math.toRadians(vRot))) + 
				(z * -Math.sin(Math.toRadians(ofs)) * Math.cos(Math.toRadians(vRot)))) + posX);
	}
	
	public static float yOn3D (float posY, float x, float y, float z, float ofs, float hRot, float vRot) {
		return (float) (-((x * Math.cos(Math.toRadians(ofs)) * Math.sin(Math.toRadians(hRot)) *Math.sin(Math.toRadians(vRot))) + Math.sin(Math.toRadians(ofs) * Math.cos(Math.toRadians(hRot))) + 
				(y * Math.cos(Math.toRadians(ofs)) * Math.cos(Math.toRadians(hRot)) * Math.sin(Math.toRadians(vRot)) - Math.sin(Math.toRadians(ofs)) * Math.sin(Math.toRadians(hRot))) + 
				(z * Math.cos(Math.toRadians(ofs)) * Math.cos(Math.toRadians(vRot)))) + posY);
	}

}
