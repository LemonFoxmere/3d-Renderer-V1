package com.gdf4.game.main;

import javax.swing.JPanel;

import com.gdf4.framework.util.InputHandler;
import com.gdf4.game.state.LoadState;
import com.gdf4.game.state.State;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Dimension;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable {
	
	private int gameWidth;
	private int gameHeight;
	private Image image;
	
	private Thread gameThread;
	private volatile boolean running;
	private volatile State currentState;
	
	private InputHandler inputHandler;
	private long deltaMillis;
	
	public Game(int gameWidth, int gameHeight){
		//initial panel
		this.gameWidth = gameWidth;	//giving width
		this.gameHeight = gameHeight;	//giving height
		setPreferredSize(new Dimension(gameWidth, gameHeight));	//setting prefered sized
		setBackground(Color.BLACK);	//setting background color
		setFocusable(true);	//allowing user's input is true
		requestFocus();	//requesting for focus
		System.out.println("foucus succesfully requested");
		
		
	}
	
	//set the current state
	public void setCurrentState(State newState) {
		System.gc();	//garbage clean out to give the smoothest operation
		newState.init();	//initalize(load) state
		currentState = newState;	//set current state to new state
		inputHandler.setCurrentState(currentState);	//initialize input
	}
	
	//add notify initilize the current state to load state
	@Override
	public void addNotify() {
		super.addNotify();	//use JPanel's addnotify while using game's addnotify
		initInput();	//initiallize input
		setCurrentState(new LoadState());	//initilaize first state
		initGame();	//initilize game
	}

	//initialize input
	private void initInput() {
		inputHandler = new InputHandler();	//initiallize inputHandler
		addKeyListener(inputHandler);	//add a key listener
		addMouseListener(inputHandler);	//add a mouse listener
		addMouseMotionListener(inputHandler); //add a mouse motion listener
	}
	
	//initilize game
	private void initGame() {
		running = true;	//set running to true
		gameThread = new Thread(this, "Game Thread");	//create thread
		gameThread.start();	//start thread working
	}

	@Override
	public void run() {
		
		long updateDurationMillis = 0;	//initial update duration time is 0 mil sec
		long sleepDurationMillis = 0; 	//initial sleep duration time is 0 mil sec
		
		while(running) {
			//in running, out max time of refreshing is 17 mil sec, that means
			//if it takes 15 milsec of rendering and loading, there is going to be
			//2 milsec of sleeping, minimal time of sleep is 2 milsec
			
			long beforeUpdateRender = System.nanoTime();	//get before update render time
			deltaMillis = updateDurationMillis + sleepDurationMillis;	//set deltaMillis to updateD + sleepD
			
			updateAndRender(deltaMillis);	//update and render
			
			updateDurationMillis = (System.nanoTime() - beforeUpdateRender) / 1000000L;
			sleepDurationMillis = Math.max(2, updateDurationMillis);	//calc sleepDurationMillis
			
			//sleep for sleepDurationMillis
			try {
				Thread.sleep(sleepDurationMillis);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//end game when running become false
		System.exit(0);
	}

	private void updateAndRender(long deltaMillis) {
		currentState.update(deltaMillis / 1000f);	//update
		prepareGameImage();	//prepare the image
		currentState.render(image.getGraphics());	//render the image
		renderGameImage(getGraphics());
	}
	
	//render Game Image to use as repaint
	private void renderGameImage(Graphics g) {
		if(image != null) {
			g.drawImage(image, 0, 0, null);	//paint image is not null
		}
		g.dispose();	
	}
	
	//prepare image method
	private void prepareGameImage() {
		if(image == null) {	//if the image is a null
			//initialize the out of frame image
			image = createImage(gameWidth, gameHeight);
		}
		Graphics g = image.getGraphics();	//paint image onto out-of-frame image
		g.clearRect(0, 0, gameWidth, gameHeight);	//clear previous image on screen
	}
	
	//exit method
	public void exit() {
		running = false;	//set running to false when game stops
	}
	
	//paint component method, overided
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(image == null) {
			return;
		}
		g.drawImage(image, 0, 0, null);
	}
	
	//get FPS method
	public long getFps() {
		return deltaMillis;
	}
	
}
