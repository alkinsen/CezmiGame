package test;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Firildak;
import physics.Vect;

public class FirildakTest {

	@Test
	public void testRotate() {
		//(0, 0)
		Firildak testFirildak = new Firildak(0, 0);

		for (int i = 0; i < 30; i++) {
			testFirildak.rotate();
		}

		Vect[] testPoint = new Vect[4];
		testPoint[0] = new Vect(20, 0);
		testPoint[1] = new Vect(20, 20);
		testPoint[2] = new Vect(0, 20);
		testPoint[3] = new Vect(0, 0);

		assertEquals((Math.round(testFirildak.points[0].x())), (int)testPoint[0].x());
		assertEquals((Math.round(testFirildak.points[1].x())), (int)testPoint[1].x());
		assertEquals((Math.round(testFirildak.points[2].x())), (int)testPoint[2].x());
		assertEquals((Math.round(testFirildak.points[3].x())), (int)testPoint[3].x());

		//(0, 355)

		Firildak testFirildak2 = new Firildak(0, 355);

		for (int i = 0; i < 60; i++) {
			testFirildak2.rotate();
		}

		Vect[] testPoint2 = new Vect[4];
		testPoint2[0] = new Vect(20, 375);
		testPoint2[1] = new Vect(0, 375);
		testPoint2[2] = new Vect(0, 355);
		testPoint2[3] = new Vect(20, 355);

		assertEquals((Math.round(testFirildak2.points[0].x())), (int)testPoint2[0].x());
		assertEquals((Math.round(testFirildak2.points[1].x())), (int)testPoint2[1].x());
		assertEquals((Math.round(testFirildak2.points[2].x())), (int)testPoint2[2].x());
		assertEquals((Math.round(testFirildak2.points[3].x())), (int)testPoint2[3].x());

		//(475, 0)

		Firildak testFirildak3 = new Firildak(475, 0);

		for (int i = 0; i < 90; i++) {
			testFirildak3.rotate();
		}

		Vect[] testPoint3 = new Vect[4];
		testPoint3[0] = new Vect(475, 20);
		testPoint3[1] = new Vect(475, 0);
		testPoint3[2] = new Vect(495, 20);
		testPoint3[3] = new Vect(495, 0);

		assertEquals((Math.round(testFirildak3.points[0].x())), (int)testPoint3[0].x());
		assertEquals((Math.round(testFirildak3.points[1].x())), (int)testPoint3[1].x());
		assertEquals((Math.round(testFirildak3.points[2].x())), (int)testPoint3[2].x());
		assertEquals((Math.round(testFirildak3.points[3].x())), (int)testPoint3[3].x());

		//(475, 355)

		Firildak testFirildak4 = new Firildak(475, 355);

		for (int i = 0; i < 120; i++) {
			testFirildak4.rotate();
		}

		Vect[] testPoint4 = new Vect[4];
		testPoint4[0] = new Vect(475, 355);
		testPoint4[1] = new Vect(495, 355);
		testPoint4[2] = new Vect(495, 375);
		testPoint4[3] = new Vect(475, 375);

		assertEquals((Math.round(testFirildak4.points[0].x())), (int)testPoint4[0].x());
		assertEquals((Math.round(testFirildak4.points[1].x())), (int)testPoint4[1].x());
		assertEquals((Math.round(testFirildak4.points[2].x())), (int)testPoint4[2].x());
		assertEquals((Math.round(testFirildak4.points[3].x())), (int)testPoint4[3].x());

		//(125, 125)

		Firildak testFirildak5 = new Firildak(125, 125);

		for (int i = 0; i < 30; i++) {
			testFirildak5.rotate();
		}

		Vect[] testPoint5 = new Vect[4];
		testPoint5[0] = new Vect(145, 125);
		testPoint5[1] = new Vect(145, 145);
		testPoint5[2] = new Vect(125, 145);
		testPoint5[3] = new Vect(125, 120);

		assertEquals((Math.round(testFirildak5.points[0].x())), (int)testPoint5[0].x());
		assertEquals((Math.round(testFirildak5.points[1].x())), (int)testPoint5[1].x());
		assertEquals((Math.round(testFirildak5.points[2].x())), (int)testPoint5[2].x());
		assertEquals((Math.round(testFirildak5.points[3].x())), (int)testPoint5[3].x());

		//(125, 125)

		Firildak testFirildak6 = new Firildak(375, 125);

		for (int i = 0; i < 30; i++) {
			testFirildak6.rotate();
		}

		Vect[] testPoint6 = new Vect[4];
		testPoint6[0] = new Vect(395, 125);
		testPoint6[1] = new Vect(395, 150);
		testPoint6[2] = new Vect(375, 150);
		testPoint6[3] = new Vect(375, 125);
		
		assertEquals((Math.round(testFirildak6.points[0].x())), (int)testPoint6[0].x());
		assertEquals((Math.round(testFirildak6.points[1].x())), (int)testPoint6[1].x());
		assertEquals((Math.round(testFirildak6.points[2].x())), (int)testPoint6[2].x());
		assertEquals((Math.round(testFirildak6.points[3].x())), (int)testPoint6[3].x());


	}

}
