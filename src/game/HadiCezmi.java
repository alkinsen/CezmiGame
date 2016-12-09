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
	public static final int BOARD_WIDTH = 500;
	public static final int BOARD_HEIGHT = 500;
	
	private Player player1;
	private Player player2;
	private Board board;
	
	private boolean runningMode=false;
	private boolean editMode=false;
	private Timer t;
	private EventListener el;
	
	private int cezmi1Left = 37;
	private int cezmi1Right = 39;
	private int cezmi2Left = 50;
	private int cezmi2Right = 53;
	
	private int tokatLeftKey = 60;
	private int tokatRightKey = 61;
	
	
	public HadiCezmi(int level, String playerName1, String playerName2) {
		super();
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);
		board = new Board(level);
		el = new EventListener(this);
		t= new Timer(20,el);
		
		
	}

	public void readXML(File file){
		XMLParser xmlParser = new XMLParser(file);

		//creating ball from xml
		ArrayList<HashMap<String, String>> ballList = xmlParser.createBallFromXml();
		System.out.println(ballList.get(0).toString());
		
		if (ballList.get(0).containsKey("x")  &&  ballList.get(0).containsKey("y")){
			System.out.println("giriyor mu?");
			board.changeBallPosition(Double.parseDouble(ballList.get(0).get("x")), Double.parseDouble(ballList.get(0).get("y")));
		}
		
		if (ballList.get(0).containsKey("vx")  &&  ballList.get(0).containsKey("vy")){
			board.changeBallVelocity(Double.parseDouble(ballList.get(0).get("vx")), Double.parseDouble(ballList.get(0).get("vy")));
		}
		
		//creating cezmi1 from xml
		ArrayList<HashMap<String, String>> cezmiList1 = xmlParser.createCezmi1FromXml();
		if (cezmiList1.get(0).containsKey("cezmiNumber") && cezmiList1.get(0).containsKey("x")){
			if(cezmiList1.get(0).containsKey("y")){
				board.changeCezmiPosition(Integer.parseInt(cezmiList1.get(0).get("cezmiNumber")), Integer.parseInt(cezmiList1.get(0).get("x")), Integer.parseInt(cezmiList1.get(0).get("y")));	
			}
			else{
				board.changeCezmiPosition(Integer.parseInt(cezmiList1.get(0).get("cezmiNumber")), Integer.parseInt(cezmiList1.get(0).get("x")));
			}	
		}
		
		if (cezmiList1.get(0).containsKey("cezmiNumber") && cezmiList1.get(0).containsKey("score")){
				player1.setName(cezmiList1.get(0).get("score"));
		}
		
		if (cezmiList1.get(0).containsKey("cezmiNumber") && cezmiList1.get(0).containsKey("leftKey")){
			cezmi1Left = Integer.getInteger(cezmiList1.get(0).get("leftKey"));
		}
		
		if (cezmiList1.get(0).containsKey("cezmiNumber") && cezmiList1.get(0).containsKey("rightKey")){
			cezmi1Right = Integer.getInteger(cezmiList1.get(0).get("rightKey"));
		}

		//creating cezmi2 from xml
		ArrayList<HashMap<String, String>> cezmiList2 = xmlParser.createCezmi2FromXml();
		if (cezmiList2.get(0).containsKey("cezmiNumber") && cezmiList2.get(0).containsKey("x")){
			if(cezmiList2.get(0).containsKey("y")){
				board.changeCezmiPosition(Integer.parseInt(cezmiList2.get(0).get("cezmiNumber")), Integer.parseInt(cezmiList2.get(0).get("x")), Integer.parseInt(cezmiList2.get(0).get("y")));	
			}
			else{
				board.changeCezmiPosition(Integer.parseInt(cezmiList2.get(0).get("cezmiNumber")), Integer.parseInt(cezmiList2.get(0).get("x")));
			}	
		}
		
		if (cezmiList2.get(0).containsKey("cezmiNumber") && cezmiList2.get(0).containsKey("score")){
			player2.setName(cezmiList2.get(0).get("score"));
	}
		
		if (cezmiList2.get(0).containsKey("cezmiNumber") && cezmiList2.get(0).containsKey("leftKey")){
			cezmi2Left = Integer.getInteger(cezmiList2.get(0).get("leftKey"));
		}
		
		if (cezmiList2.get(0).containsKey("cezmiNumber") && cezmiList2.get(0).containsKey("rightKey")){
			cezmi2Right = Integer.getInteger(cezmiList2.get(0).get("rightKey"));
		}
		
		//creating gizmo from xml
		ArrayList<HashMap<String, String>> gizmoList = xmlParser.createGizmoFromXml();
		for (int i=0; i< gizmoList.size(); i++){
			if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")){
				if(gizmoList.get(i).containsKey("orientation")){
					board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(0).get("x")), Integer.parseInt(gizmoList.get(0).get("y")), Integer.parseInt(gizmoList.get(0).get("orientation")));	
				}else {
					board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(0).get("x")), Integer.parseInt(gizmoList.get(0).get("y")));
				}
				
			}
			if(gizmoList.get(i).containsKey("orientation")){
				
			}
		}
		
		//creating level from xml
		ArrayList<HashMap<String, String>> levelList = xmlParser.createLevelFromXml();
			if (levelList.get(0).containsKey("level")){
				board.setLevel(Integer.parseInt(levelList.get(0).get("level")));
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
    	System.out.println("playing");
    	
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

	public int getCezmi1Left() {
		return cezmi1Left;
	}

	public void setCezmi1Left(int cezmi1Left) {
		this.cezmi1Left = cezmi1Left;
	}

	public int getCezmi1Right() {
		return cezmi1Right;
	}

	public void setCezmi1Right(int cezmi1Right) {
		this.cezmi1Right = cezmi1Right;
	}

	public int getCezmi2Left() {
		return cezmi2Left;
	}

	public void setCezmi2Left(int cezmi2Left) {
		this.cezmi2Left = cezmi2Left;
	}

	public int getCezmi2Right() {
		return cezmi2Right;
	}

	public void setCezmi2Right(int cezmi2Right) {
		this.cezmi2Right = cezmi2Right;
	}
	
	
	public int getTokatLeftKey() {
		return tokatLeftKey;
	}

	public void setTokatLeftKey(int tokatLeftKey) {
		this.tokatLeftKey = tokatLeftKey;
	}

	public int getTokatRightKey() {
		return tokatRightKey;
	}

	public void setTokatRightKey(int tokatRightKey) {
		this.tokatRightKey = tokatRightKey;
	}

	public void moveCezmi(int cezmiNum, String dir){
		
		board.moveCezmi(cezmiNum, dir);
		
	}
	
	public void rotateTokat(String dir){
		
		board.rotateTokat(dir);
		
	}
	
	public void move(){
		board.checkCollision();
	}
    
    
}  
    
    
    class EventListener implements KeyListener,ActionListener{
    	
    	private HadiCezmi hadiCezmi;
    	
    	public EventListener(HadiCezmi hadiCezmi){
    		this.hadiCezmi = hadiCezmi;
    	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			hadiCezmi.move();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			int keynum = e.getKeyCode();
			
			if(keynum == hadiCezmi.getCezmi1Left()){
				
				hadiCezmi.moveCezmi(1, "left");
				
			}else if(keynum == hadiCezmi.getCezmi1Right()){
				
				hadiCezmi.moveCezmi(1, "right");
				
			}else if(keynum == hadiCezmi.getCezmi2Left()){
				
				hadiCezmi.moveCezmi(2, "left");
				
			}else if(keynum == hadiCezmi.getCezmi2Right()){
				
				hadiCezmi.moveCezmi(2, "right");
				
			}else if(keynum == hadiCezmi.getTokatLeftKey()){
				
				hadiCezmi.rotateTokat("left");
				
			}else if(keynum == hadiCezmi.getTokatRightKey()){
				
				hadiCezmi.rotateTokat("right");
				
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
    	
    }
	




