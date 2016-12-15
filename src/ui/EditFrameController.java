package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import game.HadiCezmi;
import xml.XMLBuilder;

public class EditFrameController extends StartFrameController {
	
	public EditFrameController() {

    }

    public void doAction(HadiCezmi hadiCezmi, String action, EditableJButton[][] g) {
        switch (action) {
            case "play":
            	for(int i=0;i<25;i++){
            		for(int j=0; j<25;j++){
            			Color c=g[i][j].getBackground();
            			
            			if(c.equals(Color.yellow)){
            			hadiCezmi.getBoard().addGizmo("squareTakoz", i*25, j*25);
            			} else if (c.equals(Color.magenta)){
            				hadiCezmi.getBoard().addGizmo("tokat", i*25, j*25);
            			}else if(c.equals(Color.red)){
            				hadiCezmi.getBoard().addGizmo("triangularTakoz", i*25, j*25);
            			}else if(c.equals(Color.orange)){
            				hadiCezmi.getBoard().addGizmo("firildak", i*25, j*25);
            			}
            		}
            	}
            	for(int i=0;i<12;i++){   		
            			Color c=g[i][25].getBackground();
            			
            			if(c.equals(Color.green)){
            			hadiCezmi.getBoard().changeCezmiPosition(1, i*25);  
            			}
            	}
            	for(int i=13;i<25;i++){   		
                		Color c=g[i][25].getBackground();
                		if(c.equals(Color.green)){
                			hadiCezmi.getBoard().changeCezmiPosition(2, i*25);        
                		}
                }
                hadiCezmi.play();
                break;
            case "save":
            	//a
                break;
            
            default:
                //default action
                break;
        }

    }
    public void play(HadiCezmi hadiCezmi){
    	GameFrame gameFrame = new GameFrame(hadiCezmi);
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
                if (keynum == hadiCezmi.getCezmi1Left()) {
                    hadiCezmi.moveCezmi(1, "left");
                } else if (keynum == hadiCezmi.getCezmi1Right()) {
                    hadiCezmi.moveCezmi(1, "right");
                } else if (keynum == hadiCezmi.getCezmi2Left()) {
                    hadiCezmi.moveCezmi(2, "left");
                } else if (keynum == hadiCezmi.getCezmi2Right()) {
                    hadiCezmi.moveCezmi(2, "right");
                } else if (keynum == hadiCezmi.getTokatLeftKey()) {
                    hadiCezmi.rotateTokat("left");
                } else if (keynum == hadiCezmi.getTokatRightKey()) {
                    hadiCezmi.rotateTokat("right");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        final Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println(Thread.currentThread().getName());
                gameFrame.repaint();
                gameFrame.requestFocus();
            }
        });
        timer.start();
    }

}
