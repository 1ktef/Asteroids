package com.asteroids;
 
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bullets{

	public static List<Bullet> bullets = new ArrayList<>();


	public void draw(Graphics2D twoD){
		for(Bullet bullet:bullets){
			bullet.drawBullet(twoD);
		}
		
	}
	public void fireBullet(int bulletX, int bulletY, double angle){
		bullets.add(new Bullet(bulletX, bulletY, angle));
	}
}