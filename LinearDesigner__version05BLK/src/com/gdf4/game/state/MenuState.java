package com.gdf4.game.state;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.util.ArrayList;

import com.gdf4.game.main.GameMain;
import com.gdf4.game.model.ThreeD.Line.lineStandard;
import com.gdf4.game.model.ThreeD.Vertex.VtxStandard;
import com.gdf4.game.model.ThreeD.Vertex.Var.CordContainer;

public class MenuState extends State {

	//norm var
	private int x;
	private int y;
	private Robot r;
	
	//3d variable
	public static double dof = 0.05; //depth of field
	public static int verticleRot = 0;
	private static int horizontalRot = 0;
	private static int offSet = 0;
	private static int posX = GameMain.GAME_WIDTH/2, posY = GameMain.GAME_HEIGHT/2;
	private ArrayList<CordContainer> vertexContainer;
	private ArrayList<VtxStandard> vertexArr;
	private ArrayList<lineStandard> lineArr;
	
	//3d vertex
	public VtxStandard v1;
	public VtxStandard v2;
	public VtxStandard v3;
	public VtxStandard v4;
	public VtxStandard v5;
	public VtxStandard v6;
	
	public lineStandard l1;
	public lineStandard l2;
	public lineStandard l3;
	public lineStandard l4;
	public lineStandard l5;
	public lineStandard l6;
	public lineStandard l7;
	public lineStandard l8;
	
	public lineStandard s1;
	public lineStandard s2;
	public lineStandard s3;
	public lineStandard s4;
	public lineStandard s5;
	public lineStandard s6;
	public lineStandard s7;
	public lineStandard s8;
	public lineStandard s9;
	public lineStandard s10;
	public lineStandard s11;
	public lineStandard s12;

	@Override
	public void init() {
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.mouseMove(200, 200);
		vertexContainer = new ArrayList<>();
		vertexArr = new ArrayList<>();
		lineArr = new ArrayList<>();
		
		//axis
		v1 = new VtxStandard(100, 0, 0);
		v2 = new VtxStandard(0, 100, 0);
		v3 = new VtxStandard(0, 0, -100);
		v4 = new VtxStandard(-100, 0, 0);
		v5 = new VtxStandard(0, -100, 0);
		v6 = new VtxStandard(0, 0, 100);
		
		//all vertex
		//line1
/*		v4c = new CordContainer(100, 0, 0);
		v4 = new VtxStandard(v4c.getX(), v4c.getY(), v4c.getZ());
		v5c = new CordContainer(0, 100, 0);
		v5 = new VtxStandard(v5c.getX(), v5c.getY(), v5c.getZ());*/
		
		l1 = new lineStandard(100, 100, 0, -100, 100, 0);
		l2 = new lineStandard(100, -100, 0, -100, -100, 0);
		l3 = new lineStandard(100, 100, 0, 100, -100, 0);
		l4 = new lineStandard(-100, 100, 0, -100, -100, 0);
		l5 = new lineStandard(100, 50, 0, -100, 50, 0);
		l6 = new lineStandard(100, -50, 0, -100, -50, 0);
		l7 = new lineStandard(50, 100, 0, 50, -100, 0);
		l8 = new lineStandard(-50, 100, 0, -50, -100, 0);

		//cube
		s1 = new lineStandard(-100, -100, -100, 100, -100, -100);
		s2 = new lineStandard(100, -100, -100, 100, 100, -100);
		s3 = new lineStandard(100, 100, -100, -100, 100, -100);
		s4 = new lineStandard(-100, 100, -100, -100, -100, -100);
		s5 = new lineStandard(-100, -100, 100, 100, -100, 100);
		s6 = new lineStandard(100, -100, 100, 100, 100, 100);
		s7 = new lineStandard(100, 100, 100, -100, 100, 100);
		s8 = new lineStandard(-100, 100, 100, -100, -100, 100);
		s9 = new lineStandard(-100, -100, -100, -100, -100, 100);
		s10 = new lineStandard(100, -100, -100, 100, -100, 100);
		s11 = new lineStandard(100, 100, -100, 100, 100, 100);
		s12 = new lineStandard(-100, 100, -100, -100, 100, 100);
		
		
		lineArr.add(l1);
		lineArr.add(l2);
		lineArr.add(l3);
		lineArr.add(l4);
		lineArr.add(l5);
		lineArr.add(l6);
		lineArr.add(l7);
		lineArr.add(l8);

		lineArr.add(s1);
		lineArr.add(s2);
		lineArr.add(s3);
		lineArr.add(s4);
		lineArr.add(s5);
		lineArr.add(s6);
		lineArr.add(s7);
		lineArr.add(s8);
		lineArr.add(s9);
		lineArr.add(s10);
		lineArr.add(s11);
		lineArr.add(s12);
		
		vertexArr.add(v1);
		vertexArr.add(v2);
		vertexArr.add(v3);
		vertexArr.add(v4);
		vertexArr.add(v5);
		vertexArr.add(v6);
		
		//init mouse pos in middle of screen
		System.out.println("center of sceen: " + 200 + ", " + 200);
	}

	@Override
	public void update(float delta) {
		
		//reset rotations
		if(verticleRot < 0) {
			verticleRot = 359;
		} if(verticleRot > 359) {
			verticleRot = 0;
		} if(horizontalRot < 0) {
			horizontalRot = 359;
		} if(horizontalRot > 359) {
			horizontalRot = 0;
		}
		
		
//		r.mouseMove(500, 500);
		
//		if(verticleRot > -90 && verticleRot < 90) {			
//			verticleRot = (int) (y - (0.5*posY));
//			horizontalRot = -x;
//		} else if(verticleRot == -90) {
//			verticleRot = -89;
//		} else if(verticleRot == 90) {
//			verticleRot = 89;			
//		}
		
		updateAllVertex();
		updateAllVertexCont();
		updateAllLine();
		
//		verticleRot++;
//		horizontalRot+=1;
	}

	private void updateAllLine() {
		for(lineStandard l : lineArr) {
			l.update();
		}
	}

	private void updateAllVertexCont() {
		for (int i = 0; i < vertexContainer.size(); i++) {
			CordContainer v = vertexContainer.get(i);
			v.reset(vertexArr.get(i).getX(), vertexArr.get(i).getY(), vertexArr.get(i).getZ());
		}
	}

	private void updateAllVertex() {
		for(VtxStandard v : vertexArr) {
			v.update();
		}
	}

	@Override
	public void render(Graphics g) {
		//DO NOT DELETE THIS LINE
		Graphics2D g2D = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_ANTIALIASING,
	             RenderingHints.VALUE_ANTIALIAS_ON);
	    g2D.setRenderingHints(rh);
		
		renderBg(g2D);
		renderAxis(g2D);
		renderVertex(g2D);
		renderLines(g2D);
		g2D.setColor(Color.WHITE);
		g2D.drawString("X: " + x , 10, 20);
		g2D.drawString("Y: " + y , 10, 40);
		g2D.drawString("posX: " + posX , 10, 60);
		g2D.drawString("posY: " + posY , 10, 80);
		g2D.drawString("verticle_Rot: (pitch)" + verticleRot , 10, 100);
		g2D.drawString("horizontal_Rot: (yaw)" + horizontalRot , 10, 120);
	}

	private void renderLines(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		for(lineStandard l : lineArr) {
			g2d.drawLine(l.getV1x(), l.getV1y(), l.getV2x(), l.getV2y());
		}
	}

	private void renderVertex(Graphics2D g2d) {
	}

	private void renderBg(Graphics2D g2D) {
		g2D.setColor(Color.GRAY);
		g2D.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
	}

	private void renderAxis(Graphics2D g2D) {
		//x1
		g2D.setColor(Color.RED);
		g2D.fillOval(v1.ScrX - 5, v1.ScrY - 5, 10, 10);
		g2D.drawLine(v1.getScrX(), v1.getScrY(), posX, posY);
		//y1
		g2D.setColor(Color.GREEN);
		g2D.fillOval(v2.ScrX - 5, v2.ScrY - 5, 10, 10);
		g2D.drawLine(v2.getScrX(), v2.getScrY(), posX, posY);
		//z1
		g2D.setColor(Color.BLUE);
		g2D.fillOval(v3.ScrX - 5, v3.ScrY - 5, 10, 10);
		g2D.drawLine(v3.getScrX(), v3.getScrY(), posX, posY);
		//x2
		g2D.setColor(Color.RED);
		g2D.fillOval(v4.ScrX - 5, v4.ScrY - 5, 10, 10);
		g2D.drawLine(v4.getScrX(), v4.getScrY(), posX, posY);
		//y2
		g2D.setColor(Color.GREEN);
		g2D.fillOval(v5.ScrX - 5, v5.ScrY - 5, 10, 10);
		g2D.drawLine(v5.getScrX(), v5.getScrY(), posX, posY);
		//z2
		g2D.setColor(Color.BLUE);
		g2D.fillOval(v6.ScrX - 5, v6.ScrY - 5, 10, 10);
		g2D.drawLine(v6.getScrX(), v6.getScrY(), posX, posY);
	}

	@Override
	public void onClick(MouseEvent e) {
	}

	@Override
	public void onKeyPress(KeyEvent e) {
		int key = e.getKeyCode();
		
		//rotating figure
		switch(key) {
		case KeyEvent.VK_LEFT:
			horizontalRot-=2;
			break;
		case KeyEvent.VK_RIGHT:
			horizontalRot+=2;
			break;
		case KeyEvent.VK_DOWN:
			verticleRot-=2;
			break;
		case KeyEvent.VK_UP:
			verticleRot+=2;
			break;
		}
		
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		
		if(key == KeyEvent.VK_5) {
			if(dof == 0) {				
				dof = 0.15;
			} else{
				dof = 0;
			}
		}
		
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
	
	@Override
	public void onMouseEntered(MouseEvent e) {
	}

	@Override
	public void onMouseExited(MouseEvent e) {
	}
	
	//setter&getter
	public static int getVerticleRot() {
		return verticleRot;
	}

	public static int getHorizontalRot() {
		return horizontalRot;
	}

	public static int getOffSet() {
		return offSet;
	}
	
	public static int getPosX() {
		return posX;
	}

	public static int getPosY() {
		return posY;
	}



}
