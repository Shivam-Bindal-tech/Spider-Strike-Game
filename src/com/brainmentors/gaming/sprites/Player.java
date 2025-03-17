package com.brainmentors.gaming.sprites;

//import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Player extends Sprite {
	 // Used for animation type images
	public Player(){
		w = 250;
		h = 250;
		x = 0;
		y = 530;
		image = new ImageIcon(Player.class.getResource("Player.gif"));
	}
	
	public void move() {
		x = x + speed;
	}
	
	public boolean outOfScreen() {
		return x>1550;
	}
	
}
