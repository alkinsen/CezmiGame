package ui.domain;

import game.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiBoardPanel extends JPanel{
    UiBall uiBall;
    ArrayList<UiGizmo> uiGizmos;
    UiCezmi uiCezmi1;
    UiCezmi uiCezmi2;



    public UiBoardPanel(HadiCezmi hadiCezmi){
        super();
        uiGizmos = new ArrayList<UiGizmo>();
        addUiCezmi1(hadiCezmi.getBoard().getCezmi1());
        addUiCezmi2(hadiCezmi.getBoard().getCezmi2());
        addUiBall(hadiCezmi.getBoard().getBall());
        addUiGizmo(hadiCezmi.getBoard().getGizmoArrayList());
    }

    public void addUiBall(Ball ball){
        this.uiBall = new UiBall(ball);
    }
    public void addUiCezmi1(Cezmi cezmi1){
        this.uiCezmi1 = new UiCezmi(cezmi1);
    }
    public void addUiCezmi2(Cezmi cezmi2){
        this.uiCezmi2 = new UiCezmi(cezmi2);
    }

    public void addUiGizmo(ArrayList<Gizmo> gizmos) {
        for (Gizmo gizmo : gizmos) {
            if (gizmo instanceof SquareTakoz) {
                SquareTakoz squareTakoz = (SquareTakoz) gizmo;
                this.uiGizmos.add(new UiSquareTakoz(squareTakoz));
            } else if (gizmo instanceof TriangleTakoz) {
                TriangleTakoz triangleTakoz = (TriangleTakoz) gizmo;
                this.uiGizmos.add(new UiTriangleTakoz(triangleTakoz));
            }
        }
    }


    public void paint(Graphics g){
        super.paint(g);
        if(uiBall != null) uiBall.paint(g);
        if(uiCezmi1 != null) uiCezmi1.paint(g);
        if(uiCezmi2 != null) uiCezmi2.paint(g);
        if(uiGizmos != null) {
            for(UiGizmo uiGizmo: uiGizmos){
                uiGizmo.paint(g);
            }
        }
    }
}
