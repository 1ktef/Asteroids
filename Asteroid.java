package com.asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Ellipse2D;


public class Asteroid{
	double radius;
	double initX;
	double initY;
	double velocityX;
	double velocityY;
	double determiner;
	double multiplier;
	Image image;
	JPanel panel;
	double degrees;

	public Asteroid(AsteroidDirection direction, Image image, JPanel panel){
		radius = Math.max(20, Math.random()*50.0);
		determiner = Math.random();
		multiplier = Math.random()*2;
		this.panel = panel;
		this.image = image.getScaledInstance((int)radius, (int)radius, Image.SCALE_FAST);


		if(radius < 20.0){
			radius = 20.0;
		}
		if(direction == AsteroidDirection.TOP){
			initX = Math.random()*1600;
			initY = 0;
			velocityY = 0.5; 
		} else if(direction == AsteroidDirection.BOTTOM){
			initX = Math.random()*1600;
			initY = GameConfig.WINDOW_HEIGHT;
			velocityY = -0.5;
		} else if(direction == AsteroidDirection.LEFT){
			initX = 0;
			initY = Math.random()*1080;
			velocityX = 0.5;
		} else if(direction == AsteroidDirection.RIGHT){
			initX = GameConfig.WINDOW_WIDTH;
			initY = Math.random()*1080;
			velocityX = -0.5;
		}
	}


	public void draw(Graphics2D twoD){

		double width = image.getWidth(panel);
		double height = image.getHeight(panel);

		AffineTransform at = twoD.getTransform();
		twoD.rotate(Math.toRadians(degrees), initX, initY);

		twoD.drawImage(image, (int)(initX-0.5*width), (int)(initY-0.5*height), panel);

		twoD.setTransform(at);

				
		/*twoD.setPaint(Color.BLUE);
		twoD.fill(new Ellipse2D.Double(initX, initY, radius, radius));*/
		
		moveAsteroid();
	}
	public void moveAsteroid(){
		double delta = Math.random()*multiplier;
		double negDelta = Math.random()*(-multiplier);

		degrees += 1;		

		if(determiner <= 0.5){
			initX += velocityX + delta;
			initY += velocityY + delta;	
		} else if(determiner > 0.5){
			initX += velocityX + negDelta;
			initY += velocityY + negDelta;	
		}
		
	}
	
}