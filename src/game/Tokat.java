package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
/**
 * 
 * @author Pinar
 * This abstract class is created as the super 
 * class of Tokat types.
 * 
 * There are 2 Tokat types, Left and Right Tokat.
 * 
 * Tokat is specialized for hitting, which is 
 * another name for 90 degrees rotation in clock 
 * or counterclockwise direction.
 * 
 * Extends Gizmo.
 * 
 * Contains state field for hitting method.
 * 
 */
public abstract class Tokat extends Gizmo {

    //additional field
    protected String state;
    
    /**
     * Method for getting the state of the Tokat.
     * 
     * State is used in hitting.
     * 
     * state can be up and down.
     * @return state of the Tokat
     */
    //getter setter for additional field
    public String getState() {
        return state;
    }
    
    /**
     * Method for setting a state of a Gizmo.
     * 
     * state is used when hitting. 
     *  
     * @param state Tokat's new state.
     */

    public void setState(String state) {
    	//@requires: state as "up" or "down".
    	// @modifies: state
    	//@effects: state is changed according to parameter.
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tokat [state=" + state + ", x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
    }


}
