package game;

import java.awt.Color;

import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Cezerye extends Gizmo {


	public Cezerye(int xLoc, int yLoc){

		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.cyan;
		this.height = 20;
		this.width = 20;
        this.time = 0.0;
        
        points = new Vect[4];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc + width, yLoc);
        points[2] = new Vect(xLoc + width, yLoc + height);
        points[3] = new Vect(xLoc, yLoc + height);

	}
	
	public Vect[] getPoints() {
        return points;
    }

    public void setPoints(Vect[] points) {
        this.points = points;
    }

	public void rotate(){

	}

	@Override
	public String toString() {
		return "Cezerye [x=" + x + ", y=" + y + ", time=" + time + "]";
	}

}