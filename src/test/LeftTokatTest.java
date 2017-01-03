package test;

import static org.junit.Assert.*;

import game.LeftTokat;
import org.junit.Test;

import physics.Vect;

public class LeftTokatTest {

	@Test
	public void testRotateBoolean() {

		//This test is generated for checking the rotation of 
		//LeftTokat. Rotation is done for hitting. In here we create a 
		//LeftTokat and then check rotation in several conditions, 
		//with boolean false, true and in several locations. At the end 
		//we check by assertEquals the equality of expected points 
		//after rotation with the points of the LeftTokat after rotation.
		
		
		LeftTokat testLeft = new LeftTokat(150,150);

		
		Vect[] testPoints = new Vect[4];
		
		testPoints[0] = new Vect (150,150);
		testPoints[1] = new Vect (160,150);
		testPoints[2] = new Vect (160,190);
		testPoints[3] = new Vect (150,190);
		
		
		// not a corner point, boolean = false case
		
		testLeft.rotate(false);
		assertEquals((int) testLeft.points[0].x(),(int) testPoints[0].x());
		assertEquals((int) testLeft.points[1].x(),(int) testPoints[1].x());
		assertEquals((int) testLeft.points[2].x(),(int) testPoints[2].x());
		assertEquals((int) testLeft.points[3].x(),(int) testPoints[3].x());
		assertEquals((int) testLeft.points[0].y(),(int) testPoints[0].y());
		assertEquals((int) testLeft.points[1].y(),(int) testPoints[1].y());
		assertEquals((int) testLeft.points[2].y(),(int) testPoints[2].y());
		assertEquals((int) testLeft.points[3].y(),(int) testPoints[3].y());
		
		// not a corner point, boolean =true case 
		
		testPoints[0] = new Vect (160,160);
		testPoints[1] = new Vect (160,150);
		testPoints[2] = new Vect (200,150);
		testPoints[3] = new Vect (200,160);
		
		for(int i=0;i< 30;i++){
		testLeft.rotate(true);
		}
		
		assertEquals(Math.round(testLeft.points[0].x()),(int) testPoints[0].x());
		assertEquals(Math.round(testLeft.points[1].x()),(int) testPoints[1].x());
		assertEquals(Math.round(testLeft.points[2].x()),(int) testPoints[2].x());
		assertEquals(Math.round(testLeft.points[3].x()),(int) testPoints[3].x());
		assertEquals(Math.round(testLeft.points[0].y()),(int) testPoints[0].y());
		assertEquals(Math.round(testLeft.points[1].y()),(int) testPoints[1].y());
		assertEquals(Math.round(testLeft.points[2].y()),(int) testPoints[2].y());
		assertEquals(Math.round(testLeft.points[3].y()),(int) testPoints[3].y());
		
		testLeft = new LeftTokat(0,0);
		
		testPoints[0] = new Vect (10,10);
		testPoints[1] = new Vect (10,0);
		testPoints[2] = new Vect (50,0);
		testPoints[3] = new Vect (50,10);		
//		
		//touches border of the frame, true case 
		for(int i=0;i< 30;i++){
			testLeft.rotate(true);
		}
		assertEquals(Math.round(testLeft.points[0].x()),(int) testPoints[0].x());
		assertEquals(Math.round(testLeft.points[1].x()),(int) testPoints[1].x());
		assertEquals(Math.round(testLeft.points[2].x()),(int) testPoints[2].x());
		assertEquals(Math.round(testLeft.points[3].x()),(int) testPoints[3].x());
		assertEquals(Math.round(testLeft.points[0].y()),(int) testPoints[0].y());
		assertEquals(Math.round(testLeft.points[1].y()),(int) testPoints[1].y());
		assertEquals(Math.round(testLeft.points[2].y()),(int) testPoints[2].y());
		assertEquals(Math.round(testLeft.points[3].y()),(int) testPoints[3].y());
		
		
		

	}

}
