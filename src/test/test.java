package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import game.*;

import game.HadiCezmi;
import ui.GameFrame;

import javax.swing.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HadiCezmi hadi = new HadiCezmi(1, "doruk", "yilmazcan");
		Board board = new Board(1);
		board.addGizmo("SquareTakoz", 50, 50);
		board.addGizmo("SquareTakoz", 300, 310);
		board.addGizmo("SquareTakoz", 350, 40);
		hadi.setBoard(board);
		GameFrame gameFrame = new GameFrame(hadi);
		gameFrame.pack();
		gameFrame.setVisible(true);

		final Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				gameFrame.repaint();
			}
		});
		timer.start();

	}

}
