package com.asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D.Double;

public class Bullet{

	private int bulletX, bulletY, radius;
	private double angle;
	private AsteroidsPanel panel = new AsteroidsPanel();
	private static final int VELOCITY = 8;


	public Bullet(int bulletX, int bulletY, double angle){
		this.bulletX = bulletX;
		this.bulletY = bulletY;
		this.angle = angle;
		radius = 4;
	}

	private void move(){
		
		bulletX += VELOCITY * Math.cos(Math.toRadians(angle));
        bulletY += VELOCITY * Math.sin(Math.toRadians(angle));
		
	}

	public void drawBullet(Graphics2D twoD){
		twoD.setPaint(Color.RED);
		twoD.fillOval(bulletX, bulletY, radius, radius);
		move();
	}
}