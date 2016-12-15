package ui.domain;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
/**
 * 
 * @author Pinar
 * 
 * This class is the super class of all Gizmo classes of
 * Ui type of classes.
 * 
 * Ui Classes are the observers of original classes and
 * handle paint method according to the updates.
 * 
 * Ui Classes have the same fields as original classes.
 * 
 */
public abstract class UiGizmo implements Observer {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    
    /**
     * Method for painting the Gizmos to Game Frame of 
     * the HadiCezmi Game.
     * 
     * @param g instance of Graphics.
     */

    public abstract void paint(Graphics g);
    
    public abstract void update(Observable o, Object arg);
    
}
