package com.asteroids;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class AsteroidGen{
	private List<Asteroid> asteroids = new ArrayList<>();
	private List<AsteroidDirection> direction = new ArrayList<>();
	Image asteroid;
	JPanel panel;

	public AsteroidGen(JPanel panel){

		asteroid = Transparency.makeColorTransparent(new ImageIcon("com/images/Asteroid.png").getImage(), Color.BLACK);
		asteroid = asteroid.getScaledInstance(80, 80, Image.SCALE_FAST);

		this.panel = panel;
		direction.add(AsteroidDirection.LEFT);
		direction.add(AsteroidDirection.RIGHT);
		direction.add(AsteroidDirection.TOP);
		direction.add(AsteroidDirection.BOTTOM);

	}

	public void generate(){
		java.util.Random rand = new java.util.Random();
		asteroids.add(new Asteroid(direction.get(rand.nextInt(4)), asteroid, panel));
	}

	public List<Asteroid> returnList(){
		return asteroids;
	}
}