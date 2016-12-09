package ui;

import java.io.File;
import javax.swing.JFileChooser;


import xml.XMLFilter;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class StartFrameController {
	File file;
    public StartFrameController() {
    }

    public void doAction(String action) {
        switch (action) {
            case "playGame":
                //create from gizmoFactory
                break;
            case "Load":
            	loadGame();
            case "add/create/something":
                //do something
            
                break;
            default:
                //default action
                break;
        }
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
}
