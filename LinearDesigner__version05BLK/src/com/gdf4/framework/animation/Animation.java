package com.gdf4.framework.animation;

import java.awt.Graphics;

public class Animation {
	
	private Frame[] frames;	//make array Frame type
	private double[] frameEndTimes;	//make array frameEndTime, double type
	public int currentFrameIndex = 0;	//current frame index is 0
	
	private double totalDuration = 0;	//whole animation duration
	private double currentTime = 0;		//current time in animation duration, bound with currentFrameIndex
	
	public Animation (Frame... frames) {	//make a changable lengthed comtent array
		this.frames = frames;	//don't have to explain
		frameEndTimes = new double[frames.length];	//frameEndTimes array length is frame array length
		
		for (int i = 0; i < frames.length; i++) {
			Frame f = frames[i];	//let f be the tempoary frame saver
			totalDuration += f.getDuration();	//add current frame duration to total
			frameEndTimes[i] = totalDuration;	//current frame end time is unfinished total time
		}
	}
	
	
	//update, render, wrapAnimation, and another render methods are here
	public synchronized void update(float increment) {
		currentTime += increment;	//set current time
	}

	public synchronized void resetFrameIndex() {		
		currentFrameIndex = 0;
	}

	public synchronized void wrapAnimation() {
		currentFrameIndex = 0;
		currentTime %= totalDuration;	//equal to cT = cT % tD, it also give currentFrameIndex val
		currentTime = 0;
	}
	
	public synchronized void render(Graphics g, int x, int y) {
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, null);	
		
		if (currentTime >= totalDuration) {
			//wrapping is repeating animation, aka starting over
			wrapAnimation();	//wrap if current time is bigger than total time
		}
		
		while (currentTime >= frameEndTimes[currentFrameIndex]) {
			currentFrameIndex++;	//frame index update
		}
	}
	
	public synchronized void render(Graphics g, int x, int y, int width, int height) {
		g.drawImage(frames[currentFrameIndex].getImage(), x, y, width, height, null);
	
		if (currentTime >= totalDuration) {
			//wrapping is repeating animation, aka starting over
			wrapAnimation();	//wrap if current time is bigger than total time
		}
		
		while (currentTime >= frameEndTimes[currentFrameIndex]) {
			currentFrameIndex++;	//frame index update
		}
	}
}
