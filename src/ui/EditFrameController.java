package ui;
import java.awt.Color;

import java.util.ArrayList;


import game.Gizmo;
import game.GizmoFactory;
import game.HadiCezmi;

public class EditFrameController extends StartFrameController {

    public EditFrameController() {

    }

    public void doAction(HadiCezmi hadiCezmi, String action, EditableJButton[][] g, int[][] matrix) {
        switch (action) {
            case "play":

            	ArrayList<Gizmo> newGizmoArrayList = new ArrayList <Gizmo>();
            	hadiCezmi.getBoard().setGizmoArrayList(newGizmoArrayList);

            	for(int i=0;i<25;i++){
            		for(int j=0; j<25;j++){
            			
            			Color c=g[i][j].getBackground();

            			int rotationAmount= matrix[i][j];

            			if(c.equals(Color.yellow)){
            			hadiCezmi.getBoard().addGizmo("SquareTakoz", i*20, j*20);
            			
            			} else if (c.equals(Color.magenta)){
            				if(i<12){
            					hadiCezmi.getBoard().addGizmo("LeftTokat", i*20, j*20);
            					for(int k=0;k<rotationAmount;k++){
                        			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
                        		}
            				} else if(i>12){
            					hadiCezmi.getBoard().addGizmo("RightTokat", i*20, j*20);
            					for(int k=0;k<rotationAmount;k++){
                        			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
                        			}
            				}
            			}else if(c.equals(Color.red)){
            				hadiCezmi.getBoard().addGizmo("TriangleTakoz", i*20, j*20);
            				
            				for(int k=0;k<rotationAmount;k++){
                    			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
                    			
                    			}
            				
            			}else if(c.equals(Color.blue)){
            				hadiCezmi.getBoard().addGizmo("Firildak", i*20, j*20);
            				for(int k=0;k<rotationAmount*30;k++){
                    			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
                    			}
            			}
            		}
            	}
            	for(int i=0;i<12;i++){   		
            			Color c=g[i][24].getBackground();
            			
            			if(c.equals(Color.green)){
            			hadiCezmi.getBoard().changeCezmiPosition(1, i*20);  
            			}
            	}
            	for(int i=13;i<25;i++){   		
                		Color c=g[i][24].getBackground();
                		if(c.equals(Color.green)){
                			hadiCezmi.getBoard().changeCezmiPosition(2, i*20);        
                		}
                }

				hadiCezmi.getBoard().addGizmo("Cezerye", 1000, 1000);
            	initializeBoard(hadiCezmi, g,matrix);

            	play(hadiCezmi);
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
    	
    	new GameFrame(hadiCezmi);
    }

    public void initializeBoard(HadiCezmi hadiCezmi, EditableJButton[][] g,int[][] matrix){
    	
		for(int i=0;i<25;i++){
			for(int j=0; j<25;j++){
				Color c=g[i][j].getBackground();
				int rotationAmount= matrix[i][j];
				
				
				if(c.equals(Color.yellow)){
					hadiCezmi.getBoard().addGizmo("SquareTakoz", i*20, j*20);
					for(int k=0;k<hadiCezmi.getBoard().getGizmoArrayList().size();k++){
						Gizmo gizmo=hadiCezmi.getBoard().getGizmoArrayList().get(k);
            			if(gizmo.getX()==(i*20) && gizmo.getY()==(j*20)){
            				int modeofrot=(rotationAmount)%4;
        					if(modeofrot==0){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(0);
        					}else if(modeofrot==1){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(90);
        					}else if(modeofrot==2){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(180);
        					}else if(modeofrot==3){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(270);
        					}
            				
            			}
            		}
					
					
//					for(int k=0;k<rotationAmount;k++){
//            			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
//            			}
					
				} else if (c.equals(Color.magenta)){
					if(i<12){
						hadiCezmi.getBoard().addGizmo("LeftTokat", i*20, j*20);
						for(int k=0;k<rotationAmount;k++){
	            			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
	            			
	            			}
					} else if(i>12){
						hadiCezmi.getBoard().addGizmo("RightTokat", i*20, j*20);
						for(int k=0;k<rotationAmount;k++){
	            			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
	            			}
					}
				}else if(c.equals(Color.red)){
					hadiCezmi.getBoard().addGizmo("TriangleTakoz", i*20, j*20);
					for(int k=0;k<hadiCezmi.getBoard().getGizmoArrayList().size();k++){
						Gizmo gizmo=hadiCezmi.getBoard().getGizmoArrayList().get(k);
            			if(gizmo.getX()==(i*20) && gizmo.getY()==(j*20)){
            				int modeofrot=(rotationAmount)%4;
        					if(modeofrot==0){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(0);
        					}else if(modeofrot==1){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(90);
        					}else if(modeofrot==2){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(180);
        					}else if(modeofrot==3){
        						hadiCezmi.getBoard().getGizmoArrayList().get(k).setOrientation(270);
        					}
            				
            			}
            		}
					
					
					
//					for(int k=0;k<rotationAmount;k++){
//            			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
//            		}
					
					
				}else if(c.equals(Color.blue)){
					hadiCezmi.getBoard().addGizmo("Firildak", i*20, j*20);
					for(int k=0;k<rotationAmount;k++){
            			hadiCezmi.getBoard().rotateGizmo(i*20, j*20);
            			}
				}
			}
		}
		for(int i=0;i<12;i++){
			Color c=g[i][24].getBackground();

			if(c.equals(Color.green)){
				hadiCezmi.getBoard().changeCezmiPosition(1, i*20);
			}
		}
		for(int i=13;i<25;i++){
			Color c=g[i][24].getBackground();
			if(c.equals(Color.green)){
				hadiCezmi.getBoard().changeCezmiPosition(2, i*20);
			}
		}

		hadiCezmi.getBoard().resetBallPositions();

	}
}