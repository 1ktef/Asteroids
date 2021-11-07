package com.asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

public class Ship{

	private static double ACCELERATION = 0.005;
	private double accelX;
	private double accelY;
	public double velocityX = 0;
	public double velocityY = 0;
	//private double velocityY = 0;
	private double positionX = 960;
	private double positionY = 500;
	private double doubleX = 960;
	private double doubleY = 500;
	private double position;
	private int degrees = 0;
	private final int SIZE = 15;
	private final ImageIcon SHIP = new ImageIcon("com/images/Ship1.png");
	JPanel panel;
	volatile boolean thrusting;
	Image shipImage;
	int shipWidth;
	int shipHeight;

	public Ship(JPanel panel){
		this.panel = panel;
		shipImage = SHIP.getImage();
		shipWidth = shipImage.getWidth(panel);
		shipHeight = shipImage.getHeight(panel);
	}

	
	//AsteroidsPanel panel = new AsteroidsPanel();

	public void drawShip(Graphics2D twoD){
		move();
		doubleX = positionX;
		doubleY = positionY;
		
		AffineTransform at = twoD.getTransform();
		twoD.rotate(Math.toRadians(degrees), positionX, positionY);

		twoD.drawImage(shipImage, (int)(doubleX - 0.5*shipWidth), (int)(doubleY - 0.5*shipHeight), panel);
		
		twoD.setTransform(at);


		//bullets.draw(twoD);
		
	}

	public void move(){

		double acceleration = 0.0;


		if (thrusting) {
			acceleration = ACCELERATION;
		}


		velocityX += acceleration * Math.cos(Math.toRadians(degrees));
		velocityY += acceleration * Math.sin(Math.toRadians(degrees));		


		//System.out.println("velocityX=" + velocityX + " velocityY=" + velocityY);
		positionX += velocityX;
        positionY += velocityY;

        if (positionX <= -10) {
        	positionX = GameConfig.WINDOW_WIDTH + 10;
        }
        else if (positionX >= GameConfig.WINDOW_WIDTH + 10) {
        	positionX = 0;
        }

        if (positionY <= -10) {
        	positionY = GameConfig.WINDOW_HEIGHT + 10;
        }
        else if (positionY >= GameConfig.WINDOW_HEIGHT + 10) {
        	positionY = 0;
        }

       /*
        velocity += ACCELERATION;
        position += velocity + 0.5 * ACCELERATION;
        
        positionX += position * Math.cos(Math.toRadians(degrees));
        positionY += position * Math.sin(Math.toRadians(degrees));*/
    }

    public void thrust(boolean thrusting) {
    	this.thrusting = thrusting;
    }

	public void rotateShip(ShipDirection direction){
		if(direction == ShipDirection.LEFT){
			degrees-=10;
		} else{
			degrees+=10;
		}

	}
	public void fire(Bullets bullets){
		bullets.fireBullet((int)(positionX), (int)(positionY), degrees);
	}

	/*public void setInitValues(){
		triangleX += x*velocity;
		triangleY += y*velocity;
		bulletX += x*bVelocity;
		bulletY += y*bVelocity;
	}
	public void setRotValues(){
		accelX = Math.cos(Math.toDegrees(degrees))*ACCELERATION;
		accelY = Math.sin(Math.toDegrees(degrees))*ACCELERATION;
		AffineTransform at = twoD.getTransform();
		drawShip(twoD);
		twoD.setTransform(at);
		setRotValues();
	}*/
}