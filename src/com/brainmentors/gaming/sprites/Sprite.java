package com.brainmentors.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public abstract class Sprite {
	// abstract class can only be inherit and no object of the class can form
	public int speed ; // it is public so that we can use it in player file also
	public int x;
	public int y;
	public int w;
	public int h;
	public ImageIcon image;
	
	public void draw(Graphics pen) {
		pen.drawImage(image.getImage(),x,y,w,h,null);
	}
}
