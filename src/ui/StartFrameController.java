package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
<<<<<<< HEAD
import javax.swing.*;
=======
import javax.swing.JFileChooser;
import javax.swing.JFrame;
>>>>>>> master

import game.HadiCezmi;
import xml.XMLFilter;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class StartFrameController {
	File file;
    public StartFrameController() {
    }

    public void doAction(String action, JFrame frame) {
        switch (action) {
            case "Play":
            	playGame(frame);
                break;
            case "Load":
            	loadGame(frame);
            	break;
            case "Edit":
                editGame();
                break;
            default:
                break;
        }
    }
    
    public void playGame(JFrame frame){
    	HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
    	GameFrame gameFrame = new GameFrame(hadi);
    	gameFrame.pack();
    	gameFrame.setVisible(true);
    	frame.setVisible(false);

    }

    
    public void loadGame(JFrame frame){
    	JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
			hadi.readXML(file);
	    	GameFrame gameFrame = new GameFrame(hadi);
	    	gameFrame.pack();
	    	gameFrame.setVisible(true);
			frame.setVisible(false);
    }
}
    public void editGame(){
    	
    }
}
