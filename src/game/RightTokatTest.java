package game;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.Vect;

public class RightTokatTest {

	@Test
	public void testRotateBoolean() {
		RightTokat testRight = new RightTokat(150,150);
		
		Vect[] testPoints = new Vect[4];
		
		testPoints[0] = new Vect (150,150);
		testPoints[1] = new Vect (160,150);
		testPoints[2] = new Vect (160,190);
		testPoints[3] = new Vect (150,190);		
		
		// not a corner point, boolean = false case
		
		testRight.rotate(false);
		assertEquals((int) testRight.points[0].x(),(int) testPoints[0].x());
		assertEquals((int) testRight.points[1].x(),(int) testPoints[1].x());
		assertEquals((int) testRight.points[2].x(),(int) testPoints[2].x());
		assertEquals((int) testRight.points[3].x(),(int) testPoints[3].x());
		assertEquals((int) testRight.points[0].y(),(int) testPoints[0].y());
		assertEquals((int) testRight.points[1].y(),(int) testPoints[1].y());
		assertEquals((int) testRight.points[2].y(),(int) testPoints[2].y());
		assertEquals((int) testRight.points[3].y(),(int) testPoints[3].y());
		
		// not a corner point, boolean =true case 
		
		testPoints[0] = new Vect (150,150);
		testPoints[1] = new Vect (160,150);
		testPoints[2] = new Vect (160,190);
		testPoints[3] = new Vect (150,190);
		
		testRight.rotate(true);
		assertEquals((int) testRight.points[0].x(),(int) testPoints[0].x());
		assertEquals((int) testRight.points[1].x(),(int) testPoints[1].x());
		assertEquals((int) testRight.points[2].x(),(int) testPoints[2].x());
		assertEquals((int) testRight.points[3].x(),(int) testPoints[3].x());
		assertEquals((int) testRight.points[0].y(),(int) testPoints[0].y());
		assertEquals((int) testRight.points[1].y(),(int) testPoints[1].y());
		assertEquals((int) testRight.points[2].y(),(int) testPoints[2].y());
		assertEquals((int) testRight.points[3].y(),(int) testPoints[3].y());
		
		testRight = new RightTokat(480,150);
		
//		testPoints[0] = new Vect (480, 150);
//		testPoints[1] = new Vect (490, 150);
//		testPoints[2] = new Vect (490, 190);
//		testPoints[3] = new Vect (480, 190);		
//		
//		// x< x+right tokat's height, boolean= true case 
//		
//		testRight.rotate(true);
//		assertEquals((int) testRight.points[0].x(),(int) testPoints[0].x());
//		assertEquals((int) testRight.points[1].x(),(int) testPoints[1].x());
//		assertEquals((int) testRight.points[2].x(),(int) testPoints[2].x());
//		assertEquals((int) testRight.points[3].x(),(int) testPoints[3].x());
//		assertEquals((int) testRight.points[0].y(),(int) testPoints[0].y());
//		assertEquals((int) testRight.points[1].y(),(int) testPoints[1].y());
//		assertEquals((int) testRight.points[2].y(),(int) testPoints[2].y());
//		assertEquals((int) testRight.points[3].y(),(int) testPoints[3].y());
		
	}

}
