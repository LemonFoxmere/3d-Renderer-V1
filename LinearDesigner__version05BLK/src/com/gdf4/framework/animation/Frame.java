package com.gdf4.framework.animation;

import java.awt.Image;

public class Frame {
	private Image image;
	private double duration;
	
	//initallize frame
	public Frame(Image image, double duration) {
		this.image = image;
		this.duration = duration;
	}
	
	
	//getter methods here
	public Image getImage() {
		return image;
	}
	public double getDuration() {
		return duration;
	}
}
