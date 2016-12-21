package game;

import static org.junit.Assert.*;

import org.junit.Test;

import physics.Vect;

public class BoardTest {

	@Test
	public void testMoveCezmi() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddGizmoStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateGizmo() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteGizmo() {
		
		Board testBoard = new Board(1);
		testBoard.addGizmo("Firildak", 10, 10);
		testBoard.deleteGizmo(10, 10);
		System.out.println(testBoard.getGizmoArrayList().get(0).getX());
		
		int[] testArray = new int[0];
	
		assertEquals(testBoard.getGizmoArrayList().size(), testArray.length) ;
		
	
		/*(0,0)
		TriangleTakoz testTriangle = new TriangleTakoz(0, 0);
		testTriangle.rotate();
		Vect[] testPoint = new Vect[3];
		testPoint[0] = new Vect(25, 0);
		testPoint[1] = new Vect(0, 0);
		testPoint[2] = new Vect(25, 25);
		assertEquals((int)testTriangle.points[0].x(), (int)testPoint[0].x());
		assertEquals((int)testTriangle.points[1].x(), (int)testPoint[1].x());
		assertEquals((int)testTriangle.points[2].x(), (int)testPoint[2].x());

		assertEquals((int)testTriangle.points[0].y(), (int)testPoint[0].y());
		assertEquals((int)testTriangle.points[1].y(), (int)testPoint[1].y());
		assertEquals((int)testTriangle.points[2].y(), (int)testPoint[2].y());*/
	}

	@Test
	public void testMoveGizmo() {
		fail("Not yet implemented");
	}

	@Test
	public void testRotateTokat() {
		fail("Not yet implemented");
	}

}
