package test;

import static org.junit.Assert.*;

import game.Cezmi;
import org.junit.Test;

public class CezmiTest {

	@Test
	public void testMoveLeft() {
		
		//MoveLeft test is to check the equality of the expected 
		//location of a Cezmi created by us, after moving left. We 
		//get the location of the Cezmi after moving left, and check 
		//by assertEquals method, with the value resulted by adding 
		//the initial location of the cezmi minus vx (and vy if in level 2.)
		Cezmi testCezmi = new Cezmi (150,500,1);
		
		//moving left randomly level 1
		testCezmi.moveLeft();
		assertEquals((int)testCezmi.getX(),140);
		
		// x=0 case, level 1
		
		testCezmi = new Cezmi (0,500,1);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),0);
		
		// x=230, level 1
		
		testCezmi = new Cezmi (230,500,1);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),220);
		
		// x=270, level 1
		
		testCezmi = new Cezmi (270,500,1);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),270);
		
		
		// x=500, level 1
		
		testCezmi = new Cezmi (500,500,1);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(), 490);
		
		//moving randomly, level 2
		testCezmi = new Cezmi (150, 500, 2);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(), 140);
		
		// x=0, level 2
		
		testCezmi = new Cezmi (0,500,2);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),0);
		assertEquals((int) testCezmi.getY(), 490);
		
		// x=230, level 2
		
		testCezmi = new Cezmi (230,500,2);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),220);
		assertEquals((int) testCezmi.getY(),500);
				
		// x=270, level 2
				
		testCezmi = new Cezmi (270,500,2);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),270);
		assertEquals((int) testCezmi.getY(),500);
		
		// x=500, level 2
		
		testCezmi = new Cezmi (500,500,2);
		testCezmi.moveLeft();
		assertEquals((int) testCezmi.getX(),490);
		assertEquals((int) testCezmi.getY(), 500);
		
		
		
	}

	@Test
	public void testMoveRight() {
		
		//MoveRight test is to check the equality of the expected 
		//location of a Cezmi created by us, after moving right. We 
		//get the location of the Cezmi after moving right, and check 
		//by assertEquals method, with the value resulted by adding 
		//the initial location of the cezmi plus vx (and vy if in level 2.)
		
		Cezmi testCezmi = new Cezmi (150,500,1);
		
		//moving right randomly level 1
		testCezmi.moveRight();
		assertEquals((int)testCezmi.getX(),160);
		
		// x=0 case, level 1
		
		testCezmi = new Cezmi (0,500,1);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),10);
		
		// x=230, level 1
		
		testCezmi = new Cezmi (230,500,1);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),230);
				
		// x=270, level 1
				
		testCezmi = new Cezmi (270,500,1);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),280);
		
		// x=500, level 1
		
		testCezmi = new Cezmi (500,500,1);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(), 500);
		
		//moving randomly, level 2
		testCezmi = new Cezmi (150, 500, 2);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(), 160);
		
		// x=0, level 2
		
		testCezmi = new Cezmi (0,500,2);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),10);
		assertEquals((int) testCezmi.getY(), 500);
		
		// x=230, level 2
		
		testCezmi = new Cezmi (230,500,2);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),230);
		assertEquals((int) testCezmi.getY(),500);
						
		// x=270, level 2
						
		testCezmi = new Cezmi (270,500,2);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),280);
		assertEquals((int) testCezmi.getY(),500);
		
		// x=500, level 2
		
		testCezmi = new Cezmi (500,500,2);
		testCezmi.moveRight();
		assertEquals((int) testCezmi.getX(),500);
		assertEquals((int) testCezmi.getY(), 490);
	}

}
