package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public abstract class Tokat extends Gizmo {

    //additional field
    protected int state;



    //getter setter for additional field
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tokat [state=" + state + ", x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
    }


}
