package test;

import java.awt.*;
import java.awt.event.*;

import game.*;

import game.HadiCezmi;
import ui.GameFrame;
import ui.StartFrame;

import javax.swing.*;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
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