package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.TriangleTakoz;
import physics.Vect;


public class TriangleTakozTest {

	@Test
	public void testRotate() {
		
		//This test is to check the rotate method of Triangle
		//Takoz. In here we check the equality of the expected points 
		//calculated by us according to expected effect of the rotate 
		//method and then we compare them with resulted points of the 
		//TriangleTakoz. We perform this test for several conditions. 
		
		//(0,0)
		TriangleTakoz testTriangle = new TriangleTakoz(0, 0);
		testTriangle.rotate();
		Vect[] testPoint = new Vect[3];
		testPoint[0] = new Vect(20, 0);
		testPoint[1] = new Vect(0, 0);
		testPoint[2] = new Vect(20, 20);
		assertEquals((int)testTriangle.points[0].x(), (int)testPoint[0].x());
		assertEquals((int)testTriangle.points[1].x(), (int)testPoint[1].x());
		assertEquals((int)testTriangle.points[2].x(), (int)testPoint[2].x());

		assertEquals((int)testTriangle.points[0].y(), (int)testPoint[0].y());
		assertEquals((int)testTriangle.points[1].y(), (int)testPoint[1].y());
		assertEquals((int)testTriangle.points[2].y(), (int)testPoint[2].y());

		//(0,355)
		TriangleTakoz testTriangle2 = new TriangleTakoz(0, 355);
		testTriangle2.rotate();
		Vect[] testPoint2 = new Vect[3];
		testPoint2[0] = new Vect(20, 355);
		testPoint2[1] = new Vect(0, 355);
		testPoint2[2] = new Vect(20, 375);
		assertEquals((int)testTriangle2.points[0].x(), (int)testPoint2[0].x());
		assertEquals((int)testTriangle2.points[1].x(), (int)testPoint2[1].x());
		assertEquals((int)testTriangle2.points[2].x(), (int)testPoint2[2].x());

		assertEquals((int)testTriangle2.points[0].y(), (int)testPoint2[0].y());
		assertEquals((int)testTriangle2.points[1].y(), (int)testPoint2[1].y());
		assertEquals((int)testTriangle2.points[2].y(), (int)testPoint2[2].y());

		//(475,0)
		TriangleTakoz testTriangle3 = new TriangleTakoz(475, 0);
		testTriangle3.rotate();
		Vect[] testPoint3 = new Vect[3];
		testPoint3[0] = new Vect(495, 0);
		testPoint3[1] = new Vect(475, 0);
		testPoint3[2] = new Vect(495, 20);
		assertEquals((int)testTriangle3.points[0].x(), (int)testPoint3[0].x());
		assertEquals((int)testTriangle3.points[1].x(), (int)testPoint3[1].x());
		assertEquals((int)testTriangle3.points[2].x(), (int)testPoint3[2].x());

		assertEquals((int)testTriangle3.points[0].y(), (int)testPoint3[0].y());
		assertEquals((int)testTriangle3.points[1].y(), (int)testPoint3[1].y());
		assertEquals((int)testTriangle3.points[2].y(), (int)testPoint3[2].y());

		//(475,355)
		TriangleTakoz testTriangle4 = new TriangleTakoz(475, 355);
		testTriangle4.rotate();
		Vect[] testPoint4 = new Vect[3];
		testPoint4[0] = new Vect(495, 355);
		testPoint4[1] = new Vect(475, 355);
		testPoint4[2] = new Vect(495, 375);
		assertEquals((int)testTriangle4.points[0].x(), (int)testPoint4[0].x());
		assertEquals((int)testTriangle4.points[1].x(), (int)testPoint4[1].x());
		assertEquals((int)testTriangle4.points[2].x(), (int)testPoint4[2].x());

		assertEquals((int)testTriangle4.points[0].y(), (int)testPoint4[0].y());
		assertEquals((int)testTriangle4.points[1].y(), (int)testPoint4[1].y());
		assertEquals((int)testTriangle4.points[2].y(), (int)testPoint4[2].y());

		//(125,125)
		TriangleTakoz testTriangle5 = new TriangleTakoz(125, 125);
		testTriangle5.rotate();
		Vect[] testPoint5 = new Vect[3];
		testPoint5[0] = new Vect(145, 125);
		testPoint5[1] = new Vect(125, 125);
		testPoint5[2] = new Vect(145, 145);
		assertEquals((int)testTriangle5.points[0].x(), (int)testPoint5[0].x());
		assertEquals((int)testTriangle5.points[1].x(), (int)testPoint5[1].x());
		assertEquals((int)testTriangle5.points[2].x(), (int)testPoint5[2].x());

		assertEquals((int)testTriangle5.points[0].y(), (int)testPoint5[0].y());
		assertEquals((int)testTriangle5.points[1].y(), (int)testPoint5[1].y());
		assertEquals((int)testTriangle5.points[2].y(), (int)testPoint5[2].y());

		//(375,125)
		TriangleTakoz testTriangle6 = new TriangleTakoz(375, 125);
		testTriangle6.rotate();
		Vect[] testPoint6 = new Vect[3];
		testPoint6[0] = new Vect(395, 125);
		testPoint6[1] = new Vect(375, 125);
		testPoint6[2] = new Vect(395, 145);
		assertEquals((int)testTriangle6.points[0].x(), (int)testPoint6[0].x());
		assertEquals((int)testTriangle6.points[1].x(), (int)testPoint6[1].x());
		assertEquals((int)testTriangle6.points[2].x(), (int)testPoint6[2].x());

		assertEquals((int)testTriangle6.points[0].y(), (int)testPoint6[0].y());
		assertEquals((int)testTriangle6.points[1].y(), (int)testPoint6[1].y());
		assertEquals((int)testTriangle6.points[2].y(), (int)testPoint6[2].y());
	}

}
