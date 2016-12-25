package game;

import java.awt.Color;
import java.util.Observable;

import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */

/**
 * 
 * @author Pinar
 * This abstract class is the super class of 
 * all types of Gizmos.
 * 
 * Gizmo is an object on HadiCezmi Game.  
 * 
 * They are categorized according to their 
 * shape or properties such as constant 
 * rotation.
 * 
 * All shared fields are created here.
 * 
 * Indicates all types of shared methods.
 */
public abstract class Gizmo extends Observable {

    //These are the fields
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected double time;
    protected Color color;
    protected int orientation;
    protected int angle;
    public Vect[] points;
    protected Vect center;

    //methods
    /**
     * Rotates gizmos. 
     * 
     */
    public abstract void rotate();
    //@modifies: x and y Location of gizmos 
    //@effects: changes the state of the Gizmos.


    //getters and setters
    /**
     * Method for getting x Location of Gizmo
     * @return x Location of the Gizmo
     */
    public int getX() {
        return x;
    }
    /**
     * Method for setting a location to a Gizmo
     * @param x  x Location 
     */

    public void setX(int x) {
    	//@requires: x is between 0 and 25
    	//@modifies: x Location of a Gizmo
    	//@effects: x Location is changed.
    	
        this.x = x;
        setChanged();
        notifyObservers();
    }
    /**
     * Method for getting Y value of a Gizmo
     * @return y Location of a Gizmo
     */

    public int getY() {
        return y;
    }
    /**
     * Method for setting a location to a Gizmo
     * @param y  y Location 
     */

    public void setY(int y) {
    	//@requires: y is between 0 and 25
    	//@modifies: y Location of a Gizmo
    	//@effects: y Location is changed.
        this.y = y;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Method for getting a time to a Gizmo
     * @return time of a Gizmo
     */
    
    public double getTime() {
    	return time;
    }
    /**
     * Method for setting a time to a Gizmo
     * @param time time 
     */
    
    public void setTime(double time) {
    	//@requires: time is between 0 and 5
    	//@modifies: time of a Gizmo
    	//@effects: time is changed.
    	this.time = time;
    	setChanged();
    	notifyObservers();
    }
    /**
     * Method for getting the width of a Gizmo
     * @return width of a Gizmo
     */

    public int getWidth() {
        return width;
    }
    /**
     * Method for setting a width to a Gizmo
     * @param width new width
     */

    public void setWidth(int width) {
    	//@modifies: width of a Gizmo
    	//@effects: width is changed.
    	
        this.width = width;
        setChanged();
        notifyObservers();
    }
    /**
     * Method for getting height of a Gizmo
     * @return height of the Gizmo
     */

    public int getHeight() {
        return height;
    }
    /**
     * Method for setting a new height to a Gizmo 
     * @param height new height
     */

    public void setHeight(int height) {
    	//@modifies: height of a Gizmo
    	//@effects: height is changed.
        this.height = height;
        setChanged();
        notifyObservers();
    }
    /**
     * Method for getting the color of a Gizmo 
     * @return color of the Gizmo
     */

    public Color getColor() {
        return color;
    }
    /**
     * Method for setting a color to a Gizmo
     * @param color new Color
     */

    public void setColor(Color color) {
    	
    	//@modifies: color of a Gizmo
    	//@effects: color is changed.
        this.color = color;
        setChanged();
        notifyObservers();
    }
    
    /**
     * Method for getting the orientation of a Gizmo
     * orientation is used in rotation
     * @return orientation of the Gizmo
     */


    public int getOrientation() {
        return orientation;
    }
    /**
     * Method for setting an orientation to a Gizmo
     * Used in rotations
     * @param orientation new orientation
     */

    public void setOrientation(int orientation) {
   
    	//@modifies: orientation of a Gizmo
    	//@effects: orientation is changed.
        this.orientation = orientation;
    }
    
    /**
     * Method for getting the angle of a Gizmo
     * Used in rotations.
     * @return angle of the Gizmo
     */
    
    public int getAngle() {
    	return angle;
    }
    /**
     * Method for setting an angle to a Gizmo
     * Used in rotations
     * @param angle new angle
     */
    
    public void setAngle(int angle) {
    	
    	//@modifies: angle of a Gizmo
    	//@effects: angle is changed.
    	this.angle = angle;
    }
    /**
     * Method for getting each corner point of a Gizmo by a point vect.
     * These points are used in rotations, move.
     * @return point vector of the Gizmo.
     */
    public Vect[] getPoints() {
        return points;
    }
    /**
     * Method for setting the 4 corner points of a Gizmo.
     * @param points  of a Gizmo.
     */

    public void setPoints(Vect[] points) {
        this.points = points;
    }


}
