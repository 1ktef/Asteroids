package com.asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.ArrayList;

public class AsteroidsPanel extends JPanel implements ActionListener, KeyListener{
	int triangleX = 960;
	int triangleY = 500;
	double velocity = 0.0;
	double x = 0;
	double y = 0;
	int tick = 0;
	static boolean keyIsPressed = false;


	int bulletX = triangleX;
	int bulletY = triangleY;
	static int bVelocity;
	int degrees;
	final int TRIANGLE_SIZE = 30;
	Ship ship = new Ship(this);
	AsteroidGen generator = new AsteroidGen(this);
	Bullets bullets = new Bullets();

	//List<Bullet> bullets = new ArrayList<>();


	public AsteroidsPanel(){
		setFocusable(true);
		addKeyListener(this);
		setBackground(Color.BLACK);

		Timer timer = new Timer(10, this);
		timer.start();
	}

	public void draw(Graphics2D twoD){
		//ship.setInitValues();
		//ship.setRotValues();
		//bullet.bulletForLoop(twoD);
				
		bullets.draw(twoD);


		ship.drawShip(twoD);
		
		for(Asteroid asteroid : generator.returnList()){
			asteroid.draw(twoD);
		}


		count(twoD);		
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		draw(g2D);
	}
	
	
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			ship.rotateShip(ShipDirection.LEFT);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			ship.rotateShip(ShipDirection.RIGHT);
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.thrust(true);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			ship.fire(bullets);
		}
	}
	public void keyTyped(KeyEvent e){

	}
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT){
			
		}
		if(e.getKeyCode() == KeyEvent.VK_UP){
			ship.thrust(false);
		}
	}


	public void rotateDrawShip(Graphics2D twoD){
		twoD.rotate(Math.toRadians(degrees), triangleX, triangleY);		
		//ship.drawShip(twoD, triangleX, triangleY, TRIANGLE_SIZE);
	}

	public void count(Graphics2D twoD){
		tick++;
		
		if(tick%100 == 0){
			generator.generate();
		}
	}
	
	
	public void actionPerformed(ActionEvent e){
		repaint();
	}

}