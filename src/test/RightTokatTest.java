package test;

import static org.junit.Assert.*;

import game.RightTokat;
import org.junit.Test;

import physics.Vect;

public class RightTokatTest {

	@Test
	public void testRotateBoolean() {
		/*RightTokat testRight = new RightTokat(350,350);
		
		Vect[] testPoints = new Vect[4];
		
		testPoints[0] = new Vect (350,350);
		testPoints[1] = new Vect (360,350);
		testPoints[2] = new Vect (360,390);
		testPoints[3] = new Vect (350,390);		
		
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
		
		testPoints[0] = new Vect (350,350);
		testPoints[1] = new Vect (350,360);
		testPoints[2] = new Vect (310,360);
		testPoints[3] = new Vect (310,350);
		
		for(int i=0;i<30;i++){
			testRight.rotate(true);
		}
		assertEquals(Math.round(testRight.points[0].x()),(int) testPoints[0].x());
		assertEquals(Math.round(testRight.points[1].x()),(int) testPoints[1].x());
		assertEquals(Math.round(testRight.points[2].x()),(int) testPoints[2].x());
		assertEquals(Math.round(testRight.points[3].x()),(int) testPoints[3].x());
		assertEquals(Math.round(testRight.points[0].y()),(int) testPoints[0].y());
		assertEquals(Math.round(testRight.points[1].y()),(int) testPoints[1].y());
		assertEquals(Math.round(testRight.points[2].y()),(int) testPoints[2].y());
		assertEquals(Math.round(testRight.points[3].y()),(int) testPoints[3].y());
		
		testRight = new RightTokat(490,150);
		
		testPoints[0] = new Vect (490, 150);
		testPoints[1] = new Vect (490, 160);
		testPoints[2] = new Vect (450, 160);
		testPoints[3] = new Vect (450, 150);		
		
		// x< x+right tokat's height, boolean= true case 
		for(int i=0;i<30;i++){
			testRight.rotate(true);
		}
		assertEquals(Math.round(testRight.points[0].x()),(int) testPoints[0].x());
		assertEquals(Math.round(testRight.points[1].x()),(int) testPoints[1].x());
		assertEquals(Math.round(testRight.points[2].x()),(int) testPoints[2].x());
		assertEquals(Math.round(testRight.points[3].x()),(int) testPoints[3].x());
		assertEquals(Math.round(testRight.points[0].y()),(int) testPoints[0].y());
		assertEquals(Math.round(testRight.points[1].y()),(int) testPoints[1].y());
		assertEquals(Math.round(testRight.points[2].y()),(int) testPoints[2].y());
		assertEquals(Math.round(testRight.points[3].y()),(int) testPoints[3].y());
		
		
		//touches the border of right side player, true case
		
		testRight = new RightTokat (310,140);
		
		testPoints[0] = new Vect (310, 140);
		testPoints[1] = new Vect (310, 150);
		testPoints[2] = new Vect (270, 150);
		testPoints[3] = new Vect (270, 140);
		
		
		for(int i=0;i<30;i++){
			testRight.rotate(true);
		}
		
		assertEquals(Math.round(testRight.points[0].x()),(int) testPoints[0].x());
		assertEquals(Math.round(testRight.points[1].x()),(int) testPoints[1].x());
		assertEquals(Math.round(testRight.points[2].x()),(int) testPoints[2].x());
		assertEquals(Math.round(testRight.points[3].x()),(int) testPoints[3].x());
		assertEquals(Math.round(testRight.points[0].y()),(int) testPoints[0].y());
		assertEquals(Math.round(testRight.points[1].y()),(int) testPoints[1].y());
		assertEquals(Math.round(testRight.points[2].y()),(int) testPoints[2].y());
		assertEquals(Math.round(testRight.points[3].y()),(int) testPoints[3].y());
		*/
	}

}
