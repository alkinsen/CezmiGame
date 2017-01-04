package game;

import ui.domain.UiBoardPanel;
import ui.domain.UiSquareTakoz;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class GizmoFactory {
    private static GizmoFactory instance;

    private GizmoFactory() {
    }

    public static GizmoFactory getInstance() {
        if (instance == null) instance = new GizmoFactory();
        return instance;
    }

    public Gizmo getGizmo(String type, int xLoc, int yLoc) {
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

    public Gizmo getGizmo(String type, int xLoc, int yLoc, int orientation) {
        Gizmo g;
        switch (type) {
            case "Firildak":
                g = new Firildak(xLoc, yLoc);
                g.setOrientation(orientation);
                return g;
            case "SquareTakoz":
                g = new SquareTakoz(xLoc, yLoc);
                g.setOrientation(orientation);
                return g;
            case "TriangleTakoz":
                g = new TriangleTakoz(xLoc, yLoc, orientation);
//                g.setOrientation(orientation);
                return g;
            case "LeftTokat":
                g = new LeftTokat(xLoc, yLoc);
                g.setOrientation(orientation);
                return g;
            case "RightTokat":
                g = new RightTokat(xLoc, yLoc);
                g.setOrientation(orientation);
                return g;
            case "Cezerye":
                g = new Cezerye(xLoc, yLoc);
                g.setOrientation(orientation);
                return g;

            default:
                return null;
        }
    }
}