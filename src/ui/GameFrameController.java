package ui;

import javax.swing.JFrame;

import game.HadiCezmi;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class GameFrameController {


    public GameFrameController() {

    }
    
    public void doAction(String action, HadiCezmi hadiCezmi, JFrame frame) {
        switch (action) {
            case "Play":
            	hadiCezmi.play();
            	break;
            case "Pause":
            	hadiCezmi.pause();
            	break;
            case "Back":
                hadiCezmi.pause();
            	frame.setVisible(false);
                frame.dispose();
                hadiCezmi.reset();
            	new StartFrame(hadiCezmi);
            	break;
            case "Edit":
                hadiCezmi.pause();
            	frame.setVisible(false);
                frame.dispose();
            	new EditFrame(hadiCezmi);
            	break;
        }
    }

    /*public void doAction(HadiCezmi hadiCezmi, String action, String[] arg) {
        switch (action) {
            case "addLeftTokat":
                hadiCezmi.doAction("addLeftTokat");
                break;
            case "addRightTokat":
                hadiCezmi.doAction("addRightTakoz");
                break;
            case "addSquareTakoz":
                hadiCezmi.doAction("addSquareTakoz");
                break;
            case "addTriangularTakoz":
                hadiCezmi.doAction("addTriangularTakoz");
                break;
            case "addFirildak":
                hadiCezmi.doAction("addFirildak");
                break;
            case "deleteSquareTakoz":
                hadiCezmi.doAction("deleteSquareTakoz");
                break;
            case "deleteTriangularTakoz":
                hadiCezmi.doAction("deleteTriangularTakoz");
                break;
            case "deleteLeftTokat":
                hadiCezmi.doAction("deleteLeftTokat");
                break;
            case "deleteRightTokat":
                hadiCezmi.doAction("deleteRightTokat");
                break;
            case "deleteFirildak":
                hadiCezmi.doAction("deleteFirildak");
                break;
            default:
                //default action
                break;
        }

    }*/

}
