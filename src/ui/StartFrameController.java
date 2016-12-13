package ui;

import java.io.File;
import javax.swing.JFileChooser;

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
            	loadGame(Integer.parseInt(args[0]), args[1], args[2]);
            	break;
            case "Edit":
                editGame();
                break;
            default:
                break;
        }
    }
    
    public void playGame(int level, String playerName1, String playerName2){
    	HadiCezmi hadi = new HadiCezmi(level, playerName1, playerName2);
    	GameFrame gameFrame = new GameFrame(hadi);
    	gameFrame.pack();
    	gameFrame.setVisible(true);
    	
    }
    
    public void loadGame(int level, String playerName1, String playerName2){
    	JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			HadiCezmi hadi = new HadiCezmi(level, playerName1, playerName2);
			hadi.readXML(file);
	    	GameFrame gameFrame = new GameFrame(hadi);
	    	gameFrame.pack();
	    	gameFrame.setVisible(true);
			
    }
}
    public void editGame(){
    	
    }
}
