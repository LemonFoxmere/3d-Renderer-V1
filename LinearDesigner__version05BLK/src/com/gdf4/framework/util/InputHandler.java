package com.gdf4.framework.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.gdf4.game.state.State;

public class InputHandler implements KeyListener, MouseListener, MouseMotionListener {
	
	//current State varible
	private State currentState;

	//set state
	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentState.onKeyRelease(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		currentState.onClick(e); //tell the current state that mouse is clicked
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		//do nothing
	}
	

	@Override
	public void mouseEntered(MouseEvent e) {
		currentState.onMouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		currentState.onMouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		currentState.onMousePress(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		currentState.onMouseRelease(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		currentState.onKeyPress(e);
	}

	//mouse motions
	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		currentState.mouseMove(e);
	}	
}
