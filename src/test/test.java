package test;

import java.awt.event.*;

import game.*;

import game.HadiCezmi;
import ui.GameFrame;

import javax.swing.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final HadiCezmi hadi = new HadiCezmi(1, "doruk", "yilmazcan");
		//UI Test
		Board board = new Board(1);
		board.addGizmo("SquareTakoz", 50, 50);
		board.addGizmo("SquareTakoz", 300, 310);
		board.addGizmo("SquareTakoz", 350, 40);
		board.addGizmo("LeftTokat", 100, 100);
		board.addGizmo("Firildak", 200, 150);
		board.addGizmo("Cezerye", 150, 280);
		board.addGizmo("RightTokat", 240, 0);
		
		hadi.setBoard(board);
		final GameFrame gameFrame = new GameFrame(hadi);
		gameFrame.pack();
		gameFrame.setVisible(true);




	}

}