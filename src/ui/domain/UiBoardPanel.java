package ui.domain;

import game.Ball;
import game.Gizmo;

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



    public UiBoardPanel(){
        super();
        uiGizmos = new ArrayList<UiGizmo>();
    }

    public void addUiBall(UiBall uiBall){
        this.uiBall = uiBall;
    }
    public void addUiCezmi1(UiCezmi uicezmi1){
        this.uiCezmi1 = uicezmi1;
    }
    public void addUiCezmi2(UiCezmi uicezmi2){
        this.uiCezmi2 = uicezmi2;
    }
    public void addUiGizmo(UiGizmo uigizmo){
        this.uiGizmos.add(uigizmo);
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
