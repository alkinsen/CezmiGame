package game;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

import xml.XMLParser;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class HadiCezmi implements Observer{
    public static final int UNIT_LENGTH = 20;
    public static final int BOARD_WIDTH = UNIT_LENGTH*25;
    public static final int BOARD_HEIGHT = UNIT_LENGTH*25;
    public static final double TIME_COLLISION = .25;
    public static final double CORNER_RADIUS = 0;
    public static final int LEVEL_ONE = 1;
    public static final int LEVEL_TWO = 2;
    public static final int hadiCezmi_SquareTakoz=1;
    public static final int hadiCezmi_TriangleTakoz=2;
    public static final int hadiCezmi_Tokat=3;
    public static final int hadiCezmi_Cezmi=5;
    public static final int hadiCezmi_Firildak=4;
    public static final int hadiCezmi_Null=0;

    private Player player1;
    private Player player2;
    private int level;
    private Board board;

    private boolean runningMode = false;
    private boolean editMode = false;

    private int cezmi1Left = 65;
    private int cezmi1Right = 68;
    private int cezmi2Left = 37;
    private int cezmi2Right = 39;

    private int tokatLeftKey = 87;
    private int tokatRightKey = 38;
    
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    
    


    public HadiCezmi(int level, String playerName1, String playerName2) {
        super();
        this.level = level;
        player1 = new Player(playerName1);
        player2 = new Player(playerName2);
        board = new Board(level);
        board.addObserver(this);
    }

    public void readXML(File file) {
        XMLParser xmlParser = new XMLParser(file);

        //creating ball from xml
        ArrayList<HashMap<String, String>> ballList = xmlParser.createBallFromXml();

        if (ballList.get(0).containsKey("x") && ballList.get(0).containsKey("y")) {
            board.changeBallPosition(Double.parseDouble(ballList.get(0).get("x")) , Double.parseDouble(ballList.get(0).get("y")) );
        }

        if (ballList.get(0).containsKey("vx") && ballList.get(0).containsKey("vy")) {
            board.changeBallVelocity(Double.parseDouble(ballList.get(0).get("vx")), Double.parseDouble(ballList.get(0).get("vy")));
        }
        if(ballList.size() == 2){
            if (ballList.get(1).containsKey("x") && ballList.get(1).containsKey("y")) {
                board.changeBall2Position(Double.parseDouble(ballList.get(1).get("x")) , Double.parseDouble(ballList.get(1).get("y")) );
            }

            if (ballList.get(1).containsKey("vx") && ballList.get(1).containsKey("vy")) {
                board.changeBall2Velocity(Double.parseDouble(ballList.get(1).get("vx")), Double.parseDouble(ballList.get(1).get("vy")));
            }
        }

        //creating cezmi1 from xml
        ArrayList<HashMap<String, String>> cezmiList = xmlParser.createCezmi1FromXml();
        if (cezmiList.get(0).containsKey("x")) {
            if (cezmiList.get(0).containsKey("y")) {
                board.changeCezmiPosition(1, Double.parseDouble(cezmiList.get(0).get("x")) , Double.parseDouble(cezmiList.get(0).get("y")));
            } else {
                board.changeCezmiPosition(1, Double.parseDouble(cezmiList.get(0).get("x")));
            }
        }

        if (cezmiList.get(0).containsKey("score")) {
            player1.setScore(Integer.parseInt(cezmiList.get(0).get("score")));
        }

        //creating cezmi2 from xml
        ArrayList<HashMap<String, String>> cezmiList2 = xmlParser.createCezmi2FromXml();
        if (cezmiList2.get(0).containsKey("x")) {
            if (cezmiList2.get(0).containsKey("y")) {
                board.changeCezmiPosition(2, Double.parseDouble(cezmiList2.get(0).get("x")), Double.parseDouble(cezmiList2.get(0).get("y")) );
            } else {
                board.changeCezmiPosition(2, Double.parseDouble(cezmiList2.get(0).get("x")) );
            }
        }

        if (cezmiList.get(0).containsKey("score")) {
            player2.setScore(Integer.parseInt(cezmiList2.get(0).get("score")));
        }

        //creating gizmo from xml
        ArrayList<HashMap<String, String>> gizmoList = xmlParser.createGizmoFromXml();
        for (int i = 0; i < gizmoList.size(); i++) {
            if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")) {
                if (gizmoList.get(i).containsKey("orientation")) {
                    board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25, Integer.parseInt(gizmoList.get(i).get("orientation")));
                } else {
                    board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25);
                }

            }
            if (gizmoList.get(i).containsKey("orientation")) {
                if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")) {
                    if (gizmoList.get(i).containsKey("orientation")) {
                        board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25, Integer.parseInt(gizmoList.get(i).get("orientation")));
                    } else {
                        board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25);
                    }
                }
            }
            if (gizmoList.get(i).containsKey("angle")) {
                if (gizmoList.get(i).containsKey("type") && gizmoList.get(i).containsKey("x") && gizmoList.get(i).containsKey("y")) {
                    if (gizmoList.get(i).containsKey("angle")) {
                        board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25, Integer.parseInt(gizmoList.get(i).get("angle")));
                    } else {
                        board.addGizmo(gizmoList.get(i).get("type"), Integer.parseInt(gizmoList.get(i).get("x")) * 25, Integer.parseInt(gizmoList.get(i).get("y")) * 25);
                    }
                }
            }
            
        }

        //creating level, friction and gravity from xml
        ArrayList<HashMap<String, String>> levelList = xmlParser.createBoardFromXml();
        if (levelList.get(0).containsKey("level")) {
            board.setLevel(Integer.parseInt(levelList.get(0).get("level")));
        }
        if (levelList.get(0).containsKey("gravity")) {
            board.setGravity(Double.parseDouble(levelList.get(0).get("gravity")));
        }
        if (levelList.get(0).containsKey("friction1")) {
            board.setFriction(Double.parseDouble(levelList.get(0).get("friction1")));
        }

        //creating cezerye from xml
        ArrayList<HashMap<String, String>> cezeryeList = xmlParser.createCezeryeFromXml();
        for (int i = 0; i < cezeryeList.size(); i++) {
            if (cezeryeList.get(i).containsKey("type") && cezeryeList.get(i).containsKey("x") && cezeryeList.get(i).containsKey("y")) {
                if (cezeryeList.get(i).containsKey("time")) {
                    //TIMER EKLENECEK!!!
                    board.addGizmo(cezeryeList.get(i).get("type"), Integer.parseInt(cezeryeList.get(i).get("x")) * 25, Integer.parseInt(cezeryeList.get(i).get("y")) * 25);
                } else {
                    board.addGizmo(cezeryeList.get(i).get("type"), Integer.parseInt(cezeryeList.get(i).get("x")) * 25, Integer.parseInt(cezeryeList.get(i).get("y")) * 25);
                }
            }
        }
        //creating keys from xml
        ArrayList<HashMap<String, String>> keyList = xmlParser.createCezeryeFromXml();
        //DOLDURULACAK
    }


    public void play() {
        runningMode = true;
    }

    public void pause() {
        runningMode = false;
    }

    public void editMode() {
        editMode = true;
        runningMode = false;
    }

    public boolean isRunningMode() {
        return runningMode;
    }

    public void setRunningMode(boolean runningMode) {
        this.runningMode = runningMode;
    }

    
    public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
        board.setLevel(level);
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

    public void moveCezmi(int cezmiNum, String dir) {
        board.moveCezmi(cezmiNum, dir);
    }

    public void rotateTokat(String dir) {
        board.rotateTokat(dir);
    }

    public boolean isLeftPressed() {
		return leftPressed;
	}

	public void setLeftPressed(boolean leftPressed) {
		this.leftPressed = leftPressed;
	}

	public boolean isRightPressed() {
		return rightPressed;
	}

	public void setRightPressed(boolean rightPressed) {
		this.rightPressed = rightPressed;
	}

	public void move() {
        board.checkCollision(leftPressed,rightPressed);
    }

	@Override
	public void update(Observable o, Object arg) {
		Double[] score = (Double[]) arg;
		if(score[0] == 1){
			double num = player1.getScore();
			player1.setScore(num+score[1]);
		}else{
			double num = player2.getScore();
			player2.setScore(num+score[1]);
		}
		board.resetBallPositions();
        board.changeBallDiameters(player1.getScore(), player2.getScore());
        board.resetBallVelocities();
		System.out.println("Player1: "+player1.getScore()+ "Player2: "+player2.getScore());
        if(player1.getScore() >= 10 || player2.getScore() >= 10){
            this.setRunningMode(false);
        }
		
	}

	public void reset(){
        board = new Board(level);
        player1.setScore(0);
        player2.setScore(0);
        board.addObserver(this);
    }
	


}



