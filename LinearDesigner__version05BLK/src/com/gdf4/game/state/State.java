package com.gdf4.game.state;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import com.gdf4.game.main.GameMain;

public abstract class State {
	
	//initialize state currently in
	public abstract void init();

	//update current state
	public abstract void update(float delta);
	
	//render
	public abstract void render(Graphics g);
	
	//when mouse is clicked
	public abstract void onClick(MouseEvent e);
	
	//when key is pressed down
	public abstract void onKeyPress(KeyEvent e);
	
	//when key is released
	public abstract void onKeyRelease(KeyEvent e);
	
	//u get wt i mean. right?
	public abstract void onMousePress(MouseEvent e);
	public abstract void onMouseRelease(MouseEvent e);
	public abstract void mouseMove(MouseEvent e);
	
	
	//set current state to
	public void setCurrentState(State newState) {
		GameMain.sGame.setCurrentState(newState);	//uses game's setCurrentState
	}

	public abstract void onMouseEntered(MouseEvent e);
	public abstract void onMouseExited(MouseEvent e);

	
	
}
