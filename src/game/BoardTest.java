package game;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.Vect;

public class BoardTest {

	@Test
	public void testMoveCezmi() {
		
		// level 1 Board 
		Board testBoard= new Board(1);
		
		//cezmi1 move left 
		testBoard.changeCezmiPosition(1, 48);
		int testCondition= 38;
		testBoard.moveCezmi(1, "left");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition);
		
		// cezmi1 move right
		testBoard.changeCezmiPosition(1, 48);
		testCondition= 58;
		testBoard.moveCezmi(1, "right");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition);
		
		//cezmi2 move left 
		testBoard.changeCezmiPosition(2, 366);
		testCondition= 356;
		testBoard.moveCezmi(2, "left");
		assertEquals((int)testBoard.getCezmi2().getX(),testCondition);
		
		//cezmi2 move right 
		testBoard.changeCezmiPosition(2, 366);
		testCondition= 376;
		testBoard.moveCezmi(2, "right");
		assertEquals((int)testBoard.getCezmi2().getX(),testCondition);
		
		
		//level 2 Board
		testBoard= new Board(2);
		//cezmi1 move left , random location
		
		testBoard.changeCezmiPosition(1, 48);
		testCondition= 38;
		testBoard.moveCezmi(1, "left");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition);
		
		//cezmi1 move left , x=0
		testBoard.changeCezmiPosition(1, 0);
		int testCondition1= 0;
		int testCondition2= 490;
		testBoard.moveCezmi(1, "left");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition1);
		assertEquals((int)testBoard.getCezmi1().getY(),testCondition2);
				
		// cezmi1 move right, random location
		testBoard.changeCezmiPosition(1, 48);
		testCondition= 58;
		testBoard.moveCezmi(1, "right");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition);
				
		//cezmi2 move left, random location
		testBoard.changeCezmiPosition(2, 366);
		testCondition= 356;
		testBoard.moveCezmi(2, "left");
		assertEquals((int)testBoard.getCezmi2().getX(),testCondition);
				
		//cezmi2 move right, random location
		
		testBoard.changeCezmiPosition(2, 366);
		testCondition= 376;
		testBoard.moveCezmi(2, "right");
		assertEquals((int)testBoard.getCezmi2().getX(),testCondition);
		
		// cezmi 2 move right x=500
		testBoard.changeCezmiPosition(1, 500);
		testCondition1= 500;
		testCondition2= 490;
		testBoard.moveCezmi(2, "right");
		assertEquals((int)testBoard.getCezmi1().getX(),testCondition1);
		assertEquals((int)testBoard.getCezmi1().getY(),testCondition2);
		
		
	}

	@Test
	public void testMoveGizmo() {
		
		//level 1 board 
		Board testBoard = new Board (1);
		int xLoc=105;
		int yLoc=126;
		
		// add square takoz, to player 1 side 
		testBoard.addGizmo("SquareTakoz", 65, 78);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(68, 80, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		Gizmo testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add triangle takoz, player 1
		
		testBoard.addGizmo("Firildak", 65, 78);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(68, 80, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add firildak, player 1
		
		testBoard.addGizmo("SquareTakoz", 65, 78);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(68, 80, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		//add left tokat, player 1
		
		testBoard.addGizmo("LeftTokat", 65, 78);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(68, 80, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add right tokat, player 1
		
		testBoard.addGizmo("RightTokat", 65, 78);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(68, 80, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		//new x and y locations to check for player 2
		
		xLoc=305;
		yLoc=326;
		
		// add square takoz, player 2
		
		testBoard.addGizmo("SquareTakoz", 365, 378);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(368, 380, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		//add triangle takoz, player2
		
		testBoard.addGizmo("TriangleTakoz", 365, 378);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(368, 380, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add firildak, player 2
		
		testBoard.addGizmo("Firildak", 365, 378);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(368, 380, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add left tokat, player 2
		testBoard.addGizmo("LeftTokat", 365, 378);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(368, 380, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
		// add right tokat, player 2
		
		testBoard.addGizmo("RightTokat", 365, 378);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		testBoard.moveGizmo(368, 380, xLoc, yLoc);
		
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		System.out.println(testBoard.getGizmoArrayList().get(0).getY());
		
		testGizmo = testBoard.getGizmoArrayList().get(0);
		assertEquals(xLoc, testGizmo.getX());
		assertEquals(xLoc, testGizmo.getY());
		
	}

//	@Test
//	public void testRotateTokat() {
//		
//		//level 1 
//		Board testBoard = new Board(1);
//		
//		//left tokat 
//		testBoard.addGizmo("LeftTokat", 105, 130);
//		Gizmo testLeft = testBoard.getGizmoArrayList().get(0);
//		Vect[] leftVect = testLeft.getPoints();
//		System.out.println(leftVect[0].x());
//		System.out.println(leftVect[1].x());
//		System.out.println(leftVect[2].x());
//		System.out.println(leftVect[3].x());
//		
//		System.out.println("");
//		for(int i=0;i<30;i++){
//		testBoard.rotate(true);
//		}
//		testLeft = testBoard.getGizmoArrayList().get(0);
//		leftVect = testLeft.getPoints();
//		System.out.println(leftVect[0].x());
//		System.out.println(leftVect[1].x());
//		System.out.println(leftVect[2].x());
//		System.out.println(leftVect[3].x());
//		Vect[] testVect = new Vect[4];
//		testVect[0] = new Vect (115,140);
//		testVect[1] = new Vect (115,130);
//		testVect[2] = new Vect (155,130);
//		testVect[3] = new Vect (155,140);
//		
//		assertEquals((int)Math.round(leftVect[0].x()),(int)testVect[0].x());
//		assertEquals((int)Math.round(leftVect[1].x()),(int)testVect[1].x());
//		assertEquals((int)Math.round(leftVect[2].x()),(int)testVect[2].x());
//		assertEquals((int)Math.round(leftVect[3].x()),(int)testVect[3].x());
//		
//		assertEquals((int)Math.round(leftVect[0].y()),(int)testVect[0].y());
//		assertEquals((int)Math.round(leftVect[1].y()),(int)testVect[1].y());
//		assertEquals((int)Math.round(leftVect[2].y()),(int)testVect[2].y());
//		assertEquals((int)Math.round(leftVect[3].y()),(int)testVect[3].y());
//		
//		//right tokat 
//		testBoard.addGizmo("RightTokat", 105, 130);
//		Gizmo testRight = testBoard.getGizmoArrayList().get(0);
//		Vect[] rightVect = testRight.getPoints();
//		System.out.println(rightVect[0].x());
//		System.out.println(rightVect[1].x());
//		System.out.println(rightVect[2].x());
//		System.out.println(rightVect[3].x());
//				
//		System.out.println("");
//		for(int i=0;i<30;i++){
//		testBoard.rotateTokat("right");
//		}
//		testRight = testBoard.getGizmoArrayList().get(0);
//		rightVect = testRight.getPoints();
//		System.out.println(rightVect[0].x());
//		System.out.println(rightVect[1].x());
//		System.out.println(rightVect[2].x());
//		System.out.println(rightVect[3].x());
//		Vect[] testVect2 = new Vect[4];
//		testVect2[0] = new Vect (115,140);
//		testVect2[1] = new Vect (115,130);
//		testVect2[2] = new Vect (155,130);
//		testVect2[3] = new Vect (155,140);
//				
//		assertEquals((int)Math.round(rightVect[0].x()),(int)testVect2[0].x());
//		assertEquals((int)Math.round(rightVect[1].x()),(int)testVect2[1].x());
//		assertEquals((int)Math.round(rightVect[2].x()),(int)testVect2[2].x());
//		assertEquals((int)Math.round(rightVect[3].x()),(int)testVect2[3].x());
//				
//		assertEquals((int)Math.round(rightVect[0].y()),(int)testVect2[0].y());
//		assertEquals((int)Math.round(rightVect[1].y()),(int)testVect2[1].y());
//		assertEquals((int)Math.round(rightVect[2].y()),(int)testVect2[2].y());
//		assertEquals((int)Math.round(rightVect[3].y()),(int)testVect2[3].y());
//		
//	}

}
