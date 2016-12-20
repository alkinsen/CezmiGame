package game;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.Vect;

public class LeftTokatTest {

	@Test
	public void testRotateBoolean() {
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
		
		testLeft.rotate(true);
		assertEquals((int) testLeft.points[0].x(),(int) testPoints[0].x());
		assertEquals((int) testLeft.points[1].x(),(int) testPoints[1].x());
		assertEquals((int) testLeft.points[2].x(),(int) testPoints[2].x());
		assertEquals((int) testLeft.points[3].x(),(int) testPoints[3].x());
		assertEquals((int) testLeft.points[0].y(),(int) testPoints[0].y());
		assertEquals((int) testLeft.points[1].y(),(int) testPoints[1].y());
		assertEquals((int) testLeft.points[2].y(),(int) testPoints[2].y());
		assertEquals((int) testLeft.points[3].y(),(int) testPoints[3].y());
		
//		testLeft = new LeftTokat(0,0);
//		
//		testPoints[0] = new Vect (0,0);
//		testPoints[1] = new Vect (10,0);
//		testPoints[2] = new Vect (10,40);
//		testPoints[3] = new Vect (0,40);		
//		
//		// x< left tokat's height, boolean= true case 
//		
//		testLeft.rotate(true);
//		assertEquals((int) testLeft.points[0].x(),(int) testPoints[0].x());
//		assertEquals((int) testLeft.points[1].x(),(int) testPoints[1].x());
//		assertEquals((int) testLeft.points[2].x(),(int) testPoints[2].x());
//		assertEquals((int) testLeft.points[3].x(),(int) testPoints[3].x());
//		assertEquals((int) testLeft.points[0].y(),(int) testPoints[0].y());
//		assertEquals((int) testLeft.points[1].y(),(int) testPoints[1].y());
//		assertEquals((int) testLeft.points[2].y(),(int) testPoints[2].y());
//		assertEquals((int) testLeft.points[3].y(),(int) testPoints[3].y());
		
		
	}

}
