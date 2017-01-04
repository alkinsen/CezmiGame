package game;

import java.awt.Color;

import physics.Angle;
import physics.Geometry;
import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class TriangleTakoz extends Takoz {


    //constructor
    public TriangleTakoz(int xLoc, int yLoc, int orientation) {

        this.x = xLoc;
        this.y = yLoc;
        this.color = Color.red;
        this.width = 20;
        this.height = 20;
        this.orientation = orientation;
        

        //initialize the corners
        points = new Vect[3];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc, yLoc + height);
        points[2] = new Vect(xLoc + width, yLoc);

        //initialize the center

        center = new Vect((double) xLoc + (double) width / 2, (double) yLoc + (double) height / 2);
        
        if(orientation==90){
        	rotate();
        } else if(orientation==180){
        	rotate();
        	rotate();
        } else if(orientation==270){
        	rotate();
        	rotate();
        	rotate();
        }

    }
    public TriangleTakoz(int xLoc, int yLoc){
    	this.x = xLoc;
        this.y = yLoc;
        this.color = Color.red;
        this.width = 20;
        this.height = 20;
        

        //initialize the corners
        points = new Vect[3];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc, yLoc + height);
        points[2] = new Vect(xLoc + width, yLoc);

        //initialize the center

        center = new Vect((double) xLoc + (double) width / 2, (double) yLoc + (double) height / 2);
    	
    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);

        points = new Vect[3];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x, y + height);
        points[2] = new Vect(x + width, y);
        setChanged();
        notifyObservers();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        points = new Vect[3];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x, y + height);
        points[2] = new Vect(x + width, y);
        setChanged();
        notifyObservers();
    }

    @Override
    public void reset() {
        this.width = 20;
        this.height = 20;
        points = new Vect[3];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x, y + height);
        points[2] = new Vect(x + width, y);
        setChanged();
        notifyObservers();
    }

    //methods
    public void rotate() {

        Angle angle = new Angle(Math.PI / 2);
        for (int i = 0; i < points.length; i++) {
            points[i] = Geometry.rotateAround(points[i], center, angle);
        }
        setChanged();
        notifyObservers();

    }

    @Override
    public String toString() {
        return "TriangleTakoz [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
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
    public void setOrientation(int orientation) {
        this.orientation=orientation;
        if(orientation==90){
        	
        	rotate();
        } else if(orientation==180){
        	rotate();
        	rotate();
        } else if(orientation==270){
        	rotate();
        	rotate();
        	rotate();
        }
       
    }


}
