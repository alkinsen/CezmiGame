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
		final HadiCezmi hadi = new HadiCezmi(2, "doruk", "yilmazcan");
		new StartFrame(hadi);
		while (true){
			if(hadi.isRunningMode()) {
				hadi.move();
			}
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(5);
		}
	}
}