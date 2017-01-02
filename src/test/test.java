package test;

import java.awt.*;
import java.awt.event.*;

import game.*;

import game.HadiCezmi;
import physics.Circle;
import physics.Geometry;
import physics.LineSegment;
import physics.Vect;
import ui.GameFrame;
import ui.StartFrame;

import javax.sound.sampled.Line;
import javax.swing.*;

public class test {

	public static void main(String[] args) throws InterruptedException {

		HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
		new StartFrame(hadi);
		while (true){
			if(hadi.isRunningMode()) {
				hadi.move();
			}
			Thread.sleep(5);
		}
	}
}