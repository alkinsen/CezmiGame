package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

import javax.swing.Timer;

import xml.XMLParser;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class HadiCezmi {
    public static final int FRAME_WIDTH = 600;
    public static final int FRAME_HEIGHT = 600;
    public static final int BOARD_WIDTH = 500;
    public static final int BOARD_HEIGHT = 500;
    //GLOBAL VARIABLES SHOULD BE HERE
	
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
		
		if (ballList.get(0).containsKey("x")  &&  ballList.get(0).containsKey("y")){
			board.changeBallPosition(Double.parseDouble(ballList.get(0).get("x"))*25, Double.parseDouble(ballList.get(0).get("y"))*25);
		}
		
		if (ballList.get(0).containsKey("vx")  &&  ballList.get(0).containsKey("vy")){
			board.changeBallVelocity(Double.parseDouble(ballList.get(0).get("vx")), Double.parseDouble(ballList.get(0).get("vy")));
		}
		
		//creating cezmi1 from xml
		ArrayList<HashMap<String, String>> cezmiList1 = xmlParser.createCezmi1FromXml();
		if (cezmiList1.get(0).containsKey("x")){
			if(cezmiList1.get(0).containsKey("y")){
				board.changeCezmiPosition(1, Double.parseDouble(cezmiList1.get(0).get("x"))*25, Double.parseDouble(cezmiList1.get(0).get("y"))*25);	
			}
			else{
				board.changeCezmiPosition(1, Double.parseDouble(cezmiList1.get(0).get("x"))*25);
			}	
		}
		
		if (cezmiList1.get(0).containsKey("score")){
				player1.setScore(Integer.parseInt(cezmiList1.get(0).get("score")));
		}

		//creating cezmi2 from xml
		ArrayList<HashMap<String, String>> cezmiList2 = xmlParser.createCezmi2FromXml();
		if (cezmiList2.get(0).containsKey("x")){
			if(cezmiList2.get(0).containsKey("y")){
				board.changeCezmiPosition(2, Double.parseDouble(cezmiList2.get(0).get("x"))*25, Double.parseDouble(cezmiList2.get(0).get("y"))*25);
			}
			else{
				board.changeCezmiPosition(2, Double.parseDouble(cezmiList2.get(0).get("x"))*25);
			}
		}
		
		if (cezmiList2.get(0).containsKey("score")){
			player2.setScore(Integer.parseInt(cezmiList2.get(0).get("score")));
	}
		
		//creating gizmo from xml
		ArrayList<HashMap<String, String>> gizmoList = xmlParser.createGizmoFromXml();
		for (int i=0; i< gizmoList.size(); i++){
			if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")){
				if(gizmoList.get(i).containsKey("orientation")){
					board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x"))*25, Integer.parseInt(gizmoList.get(i).get("y"))*25, Integer.parseInt(gizmoList.get(i).get("orientation")));	
				}else {
					board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x"))*25, Integer.parseInt(gizmoList.get(i).get("y"))*25);
				}
				
			}
			if(gizmoList.get(i).containsKey("orientation")){
				if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")){
					if(gizmoList.get(i).containsKey("orientation")){
						board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x"))*25, Integer.parseInt(gizmoList.get(i).get("y"))*25, Integer.parseInt(gizmoList.get(i).get("orientation")));	
					}else {
						board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x"))*25, Integer.parseInt(gizmoList.get(i).get("y"))*25);
					}
			}
		}
		}
		
		//creating level, friction and gravity from xml
		ArrayList<HashMap<String, String>> levelList = xmlParser.createBoardFromXml();
			if (levelList.get(0).containsKey("level")){
				board.setLevel(Integer.parseInt(levelList.get(0).get("level")));
			}
			if (levelList.get(0).containsKey("gravity")){
				board.setGravity(Double.parseDouble(levelList.get(0).get("gravity")));
			}
			if (levelList.get(0).containsKey("friction1")){
				board.setFriction(Double.parseDouble(levelList.get(0).get("friction1")));
			}
		
		//creating cezerye from xml
		ArrayList<HashMap<String, String>> cezeryeList = xmlParser.createCezeryeFromXml();
		for (int i=0; i< cezeryeList.size(); i++){
			if (cezeryeList.get(i).containsKey("type") && cezeryeList.get(i).containsKey("x") && cezeryeList.get(i).containsKey("y")){
				if(cezeryeList.get(i).containsKey("time")){
					//TIMER EKLENECEK!!!
					board.addGizmo(cezeryeList.get(i).get("type"), Integer.parseInt(cezeryeList.get(i).get("x"))*25, Integer.parseInt(cezeryeList.get(i).get("y"))*25);	
				}else {
					board.addGizmo(cezeryeList.get(i).get("type"), Integer.parseInt(cezeryeList.get(i).get("x"))*25, Integer.parseInt(cezeryeList.get(i).get("y"))*25);
				}
		}
	}
		//creating keys from xml
		ArrayList<HashMap<String, String>> keyList = xmlParser.createCezeryeFromXml();
		//DOLDURULACAK
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

    public boolean isRunningMode() {
        return runningMode;
    }

    public void setRunningMode(boolean runningMode) {
        this.runningMode = runningMode;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
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
			//System.out.println(hadiCezmi.getBoard().getBall());
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e);
			int keynum = e.getKeyCode();
            System.out.println(keynum);

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
	




