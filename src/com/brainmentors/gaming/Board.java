package com.brainmentors.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.brainmentors.gaming.sprites.Enemy;
import com.brainmentors.gaming.sprites.Player;

public class Board extends JPanel {
	Timer timer; // display and remove images with a delay
	BufferedImage backgroundImage;// To store the image in buffer in terms of bytes
	Player player;
	Enemy enemies[] = new Enemy[4];
	public Board() {
		setSize(1920,1080);
		loadBackgroundImage();
		player = new Player();
		loadEnemies();
		gameLoop();
		bindEvents();
		setFocusable(true);
		}
	
	private void gameOver(Graphics pen) {
		if(player.outOfScreen()) {
			pen.setFont(new Font("times",Font.BOLD,30));
			pen.setColor(Color.RED);
			pen.drawString("GAME WIN",900,500);
			timer.stop(); // To stop the Game
			return ;
		}
		for(Enemy enemy : enemies) {
			if(isCollide(enemy)) {
				pen.setFont(new Font("times",Font.BOLD,30));
				pen.setColor(Color.RED);
				pen.drawString("GAME OVER",900,500);
				timer.stop();
			}
		}
	}
	
	private boolean isCollide(Enemy enemy) {
		int xDistance = Math.abs(player.x - enemy.x);
		int yDistance = Math.abs(player.y - enemy.y);
		int maxH = Math.max(player.h, enemy.h);
		int maxW = Math.max(player.w, enemy.w);
		return xDistance <= maxW-120 && yDistance <= maxH-170 ;
		}
	
	private void bindEvents() {
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
					player.speed = 5 ;
					}
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					player.speed = -5 ;
				}
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				player.speed = 0 ;
				// TODO Auto-generated method stub
				
			}
			
			
		});
	}
	
	private void loadEnemies() {
		int x = 300;
		int gap = 350;
		int speed = 5;
		for(int i = 0 ; i<enemies.length ; i++) {
			enemies[i] = new Enemy(x,speed);
			x+=gap;
			speed+=1;
		}
	}
	
	private void gameLoop() {
		timer = new Timer(10/*time delay(in millisecond)*/, (e)->repaint());	
		timer.start();
	}
	private void loadBackgroundImage() {
		try {
			backgroundImage = ImageIO.read(Board.class.getResource("GameBackgroundImage.jpg"));
		} catch (IOException e) {
			System.out.println("Background Image Not Found.....");
			// System.exit(0); it means exit without any problem
			System.exit(1); // Some problem is there
			// TODO Auto-generated catch block
			e.printStackTrace(); // It tells where the problem comes 
		}
	}
	
	private void printEnemies(Graphics pen) {
		for(Enemy enemy : enemies) {
			enemy.draw(pen);
			enemy.move();
		}
	}
	
	@Override
	public void paintComponent(Graphics pen) {
		// all printing work will be done here
		super.paintComponent(pen); // clean up everything on board
		pen.drawImage(backgroundImage,0,0,1880,960,null);
		player.draw(pen);
		player.move();
		printEnemies(pen);
		gameOver(pen);
		}
}
