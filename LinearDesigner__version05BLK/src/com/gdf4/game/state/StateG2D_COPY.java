package com.gdf4.game.state;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public final class StateG2D_COPY extends State {

	public StateG2D_COPY() {
	}

	@Override
	public void init() {
	}

	@Override
	public void update(float delta) {
	}

	@Override
	public void render(Graphics g) {
		//WARNING: DELET AT YOUR OWN RISK!
		Graphics2D g2d;		
		g2d = graphics2DConvert(g);
		
		/**************************************/
		//Start code here
		System.out.println("dummyText");
		
	}
	

	

	@Override
	public void onClick(MouseEvent e) {
	}

	@Override
	public void onKeyPress(KeyEvent e) {
	}

	@Override
	public void onKeyRelease(KeyEvent e) {
	}

	@Override
	public void onMousePress(MouseEvent e) {
	}

	@Override
	public void onMouseRelease(MouseEvent e) {
	}

	@Override
	public void mouseMove(MouseEvent e) {
	}

	//WARNING: DELET AT YOUR OWN RISK!
	private Graphics2D graphics2DConvert(Graphics g) {
		
		//init all graphics option
		Graphics2D g2D = (Graphics2D) g;
		return g2D;
	}

	@Override
	public void onMouseEntered(MouseEvent e) {
	}

	@Override
	public void onMouseExited(MouseEvent e) {
	}
}
