package game;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class GizmoFactory {
	private static GizmoFactory instance;

	private GizmoFactory(){}

	public static GizmoFactory getInstance(){
		if(instance == null) instance = new GizmoFactory();
		return instance;
	}

	public Gizmo getGizmo(String type, int xLoc, int yLoc){
		switch (type) {
		case "Firildak":
			return new Firildak(xLoc, yLoc);
		case "SquareTakoz":
			return new SquareTakoz(xLoc, yLoc);
		case "TriangleTakoz":
			return new TriangleTakoz(xLoc, yLoc);
		case "LeftTokat":
			return new LeftTokat(xLoc, yLoc);
		case "RightTokat":
			return new RightTokat(xLoc, yLoc);
		case "Cezerye":
			return new Cezerye(xLoc, yLoc);

		default:
			return null;
		}
	}
}