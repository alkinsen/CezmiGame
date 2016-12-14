package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import javax.swing.*;

import game.HadiCezmi;
import xml.XMLFilter;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class StartFrameController {
	File file;
    public StartFrameController() {
    }

    public void doAction(String action, String[] args) {
        switch (action) {
            case "Play":
            	playGame(Integer.parseInt(args[0]), args[1], args[2]);
                break;
            case "Load":
            	loadGame();
            	break;
            case "Edit":
                editGame();
                break;
            default:
                break;
        }
    }
    
    public void playGame(int level, String playerName1, String playerName2 ){
    	HadiCezmi hadi = new HadiCezmi(level, playerName1, playerName2);
    	GameFrame gameFrame = new GameFrame(hadi);
    	gameFrame.pack();
    	gameFrame.setVisible(true);

        gameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

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
            public void keyReleased(KeyEvent e) {}
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

    
    public void loadGame(){
    	JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
    }
}
    public void editGame(){
    	
    }
}
