package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.Timer;

import xml.XMLParser;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class HadiCezmi {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 800;
    //GLOBAL VARIABLES SHOULD BE HERE
	public static final int BOARD_WIDTH = 0;
	public static final int BOARD_HEIGHT = 0;
	
	private Player player1;
	private Player player2;
	private Board board;
	
	private boolean runningMode=false;
	private boolean editMode=false;
	private Timer t;
	private eventListener el=new eventListener();
	
	public HadiCezmi(int level, String playerName1, String playerName2) {
		super();
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);
		board = new Board(level);
		t= new Timer(20,el);
		
	}

	public void readXML(File file){
		XMLParser xmlParser = new XMLParser(file);
		
		//creating ball from xml
		ArrayList<HashMap<String, String>> ballList = xmlParser.createBallFromXml();
		if (ballList.get(0).containsKey("x")  &&  ballList.get(0).containsKey("y")){
			board.changeBallPosition(Integer.parseInt(ballList.get(0).get("x")), Integer.parseInt(ballList.get(0).get("y")));
		}
		else if (ballList.get(0).containsKey("vx")  &&  ballList.get(0).containsKey("vy")){
			board.changeBallVelocity(Integer.parseInt(ballList.get(0).get("vx")), Integer.parseInt(ballList.get(0).get("vy")));
		}
		
		//creating cezmi from xml
		ArrayList<HashMap<String, String>> cezmiList = xmlParser.createCezmiFromXml();
		if (cezmiList.get(0).containsKey("cezmiNumber") && cezmiList.get(0).containsKey("x") && cezmiList.get(0).containsKey("y")){
			board.changeCezmiPosition(Integer.parseInt(cezmiList.get(0).get("cezmiNumber")), Integer.parseInt(cezmiList.get(0).get("x")), Integer.parseInt(cezmiList.get(0).get("y")));
		}
		
		//creating gizmo from xml
		ArrayList<HashMap<String, String>> gizmoList = xmlParser.createGizmoFromXml();
		for (int i=0; i< gizmoList.size(); i++){
			if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")){
				board.changeCezmiPosition(Integer.parseInt(gizmoList.get(i).get("cezmiNumber")), Integer.parseInt(gizmoList.get(0).get("x")), Integer.parseInt(gizmoList.get(0).get("y")));
			}
		}	
	}
	
    

    public void doAction(String s, String[] arg){
    	int x=Integer.parseInt(arg[0]);
    	int y=Integer.parseInt(arg[1]);
    	if(editMode==true && runningMode==false){
    	switch(s){
    	
    	case "addLeftTokat":
    		board.addGizmo("leftTokat",x,y);
    		break;
    	case "addRightTokat":
    		board.addGizmo("rightTokat",x,y);
    		break;
    	case "addSquareTakoz":
    		board.addGizmo("squareTakoz", x,y);
    		break;
    	case "addTriangularTakoz":
    		board.addGizmo("triangularTakoz", x,y);
    		break;
    	case "addFirildak":
    		board.addGizmo("firildak", x, y);
    		break;
    	case "deleteSquareTakoz":
    		board.deleteGizmo(x, y);
    		break;
    	case "deleteTriangularTakoz":
    		board.deleteGizmo(x, y);
    		break;
    	case "deleteLeftTokat":
    		board.deleteGizmo(x, y);
    		break;
    	case "deleteRightTokat":
    		board.deleteGizmo(x, y);
    		break;
    	case "deleteFirildak":
    		board.deleteGizmo(x, y);
    		break;
    	default:
    		break;
    	}
    	}
    }
    
    public void doAction(String s){
    	switch(s){
    	case "play":
    		play();
    		break;
    	case "pause":
    		pause();
    		break;
    	case "editMode":
    		editMode();
    		break;
    		default:
    			break;
    	}
    	
    }
    public void play(){
    	runningMode=true;
    	t.start();
    	
    }
    
    public void pause(){
    	runningMode=false;
    	t.stop();
    }
    
    public void editMode(){
    	editMode=true;
    	runningMode=false;
    	t.stop();
    }
}  
    
    
    class eventListener implements KeyListener,ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
	




