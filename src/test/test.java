package test;

import java.awt.event.*;

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

		gameFrame.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keynum = e.getKeyCode();
				System.out.println(keynum);

				if(keynum == hadi.getCezmi1Left()){

					hadi.moveCezmi(1, "left");

				}else if(keynum == hadi.getCezmi1Right()){

					hadi.moveCezmi(1, "right");

				}else if(keynum == hadi.getCezmi2Left()){

					hadi.moveCezmi(2, "left");

				}else if(keynum == hadi.getCezmi2Right()){

					hadi.moveCezmi(2, "right");

				}else if(keynum == hadi.getTokatLeftKey()){

					hadi.rotateTokat("left");

				}else if(keynum == hadi.getTokatRightKey()){

					hadi.rotateTokat("right");

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {


			}
		});


		final Timer timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent e) {
				gameFrame.repaint();
				gameFrame.requestFocus();
			}
		});
		timer.start();


	}

}
