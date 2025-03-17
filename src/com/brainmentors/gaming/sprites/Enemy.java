package com.brainmentors.gaming.sprites;

//import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Enemy extends Sprite {
	
	public Enemy(int x , int speed){
		w = 150;
		h = 150;
		this.speed = speed ;
		this.x = x; // U can also use super.x to represent that this x comes from parent class "Sprite"
		y = 0;
		image = new ImageIcon(Enemy.class.getResource("Spider.gif"));
	}
	
	public void move() {
		if(y > 900) {
			y = 0 ;
		}
		y = y + speed ;
	}
	
}
	
