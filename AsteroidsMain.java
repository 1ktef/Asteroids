package com.asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AsteroidsMain extends JFrame{
	public AsteroidsMain(){
		AsteroidsPanel panel = new AsteroidsPanel();
		add(panel);
		createSplash();

		setTitle("Asteroids");
		setSize(GameConfig.WINDOW_WIDTH, GameConfig.WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[]){
		AsteroidsMain main = new AsteroidsMain();
	}
	
	public void createSplash(){
		final SplashScreen splash = SplashScreen.getSplashScreen();
        if (splash == null) {
            System.out.println("SplashScreen.getSplashScreen() returned null");
            return;
        }
        Graphics2D g = splash.createGraphics();
        if (g == null) {
            System.out.println("g is null");
            return;
        }
        for(int i=0; i<100; i++) {
            //renderSplashFrame(g, i);
            splash.update();
            try {
                Thread.sleep(90);
            }
            catch(InterruptedException e) {
            }
        }
        splash.close();
	}
}