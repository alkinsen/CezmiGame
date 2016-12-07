package game;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class GizmoFactory {
    private GizmoFactory instance;

    private GizmoFactory(){}

    public GizmoFactory getInstance(){
        if(instance == null) instance = new GizmoFactory();
        return instance;
    }

    public Gizmo getGizmo(String type){
        switch (type) {
            case "LeftTokat":
                return new LeftTokat();
            default:
                return null;
        }
    }
}
