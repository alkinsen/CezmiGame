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
		//UI Test
		/*Board board = new Board(1);
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
		timer.start();*/

		//XML test
		hadi.readXML(new File("sample.xml"));
		System.out.println(hadi.getPlayer1());
		System.out.println(hadi.getPlayer2());
		System.out.println(hadi.getBoard().getBall());
		System.out.println(hadi.getBoard().getEngel());
		System.out.println(hadi.getBoard().getCezmi1());
		System.out.println(hadi.getBoard().getCezmi2());
		System.out.println(hadi.getBoard().getGizmoArrayList());
	}

}
