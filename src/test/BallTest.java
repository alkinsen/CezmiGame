package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Ball;

public class BallTest {

	@Test
	public void testMove() {
		
		//this test is to control move() method of Ball object. In here 
		//we create a Ball with a random velocity. Then we get the 
		//velocity of the Ball. And we add vy and vy to the velocity 
		//and check the equality of the x and y components of the 
		//Ball after move method. 
		
		Ball testBall = new Ball(); 
		double testX = testBall.getX();
		double testY = testBall.getY();
		testBall.move();
		double testVX = 1;
		double testVY = 1;
		double testXNewLocation = testX + testVX;
		double testYNewLocation = testY + testVY;

		assertEquals((int)testBall.getX(), (int)testXNewLocation);
		assertEquals((int)testBall.getY(), (int)testYNewLocation);
		
		Ball testBall2 = new Ball(); 
		double test2X = testBall2.getX();
		double test2Y = testBall2.getY();
		testBall2.move();
		double test2VX = 1;
		double test2VY = 1;
		double test2XNewLocation = test2X + test2VX;
		double test2YNewLocation = test2Y + test2VY;

		assertEquals((int)testBall2.getX(), (int)test2XNewLocation);
		assertEquals((int)testBall2.getY(), (int)test2YNewLocation);
		
	}

}
