package game;

import java.awt.Color;

import physics.Angle;
import physics.Geometry;
import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class LeftTokat extends Tokat {


	public LeftTokat(int xLoc, int yLoc) {

		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.magenta;
		this.state = 0;
		this.width = 10;
		this.height = 40;

		points = new Vect[4];
		points[0] = new Vect(xLoc, yLoc);
		points[1] = new Vect(xLoc + width, yLoc);
		points[2] = new Vect(xLoc + width, yLoc + height);
		points[3] = new Vect(xLoc, yLoc + height);

		center = new Vect(points[1].x(),points[1].y());
	}

	public void rotate() {

	}

	public void rotate(boolean isPressed){

		boolean canGoUp = points[2].y()>center.y();
		boolean canGoDown = points[2].y()<(center.y()+height);

		if(canGoDown){
			state = 1;
		}else{
			state = 0;
		}

		Angle angle = new Angle(0);

		if(isPressed && canGoUp){
			angle = new Angle(-2 * Math.PI / 120);
		}else if (!isPressed && canGoDown){
			angle = new Angle(2 * Math.PI / 120);
		}
		for (int i = 0; i < points.length; i++) {
			points[i] = Geometry.rotateAround(points[i], center, angle);
		}
		setChanged();
		notifyObservers();


	}

	public Vect[] getPoints() {
		return points;
	}

	public void setPoints(Vect[] points) {
		this.points = points;
	}

	public Vect getCenter() {
		return center;
	}

	public void setCenter(Vect center) {
		this.center = center;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}



}
