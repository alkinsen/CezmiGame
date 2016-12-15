package ui.domain;

import game.Gizmo;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */

/**
 * 
 * @author Pinar
 * This class is the super class of UiSquare and 
 * UiTriangular Takoz classes.
 * 
 *  Ui Classes are the observers of original classes and
 *  handle paint method according to the updates.
 *  
 *  Ui Classes have the same fields as original classes.
 *  
 */
public abstract class UiTakoz extends UiGizmo {
	
	
	public abstract void update(Observable o, Object arg);

}
