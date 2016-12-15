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
 * This abstract class is the super class of UiLeftTokat 
 * and UiRightTokat classes.
 * 
 * Ui Classes are the observers of original classes and 
 * handle paint method according to the updates.
 * 
 * Ui Classes have the same fields as original classes.
 */
public abstract class UiTokat extends UiGizmo  {
	protected int state;
	

}
