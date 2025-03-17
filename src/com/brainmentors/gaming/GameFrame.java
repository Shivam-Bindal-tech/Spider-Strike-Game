package com.brainmentors.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
	
	public GameFrame(){
		Board board = new Board();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SPIDER STRIKE");
		setSize(1920,1080);
		setResizable(false);
		setLocationRelativeTo(null);
		add(board);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameFrame(); // Creating object
		
	}

}
