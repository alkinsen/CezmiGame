package game;

import java.awt.Color;

import physics.*;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Firildak extends SquareTakoz {

    protected int angularVelocity;

    public Firildak(int xLoc, int yLoc) {
        super(xLoc, yLoc);
        // TODO Auto-generated constructor stub
        color = Color.red;

        //initialize the corners
        points = new Vect[4];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc + width, yLoc);
        points[2] = new Vect(xLoc + width, yLoc + height);
        points[3] = new Vect(xLoc, yLoc + height);


        //initialize the center

        center = new Vect((double) xLoc + (double) width / 2, (double) yLoc + (double) height / 2);

    }

    public void rotate() {

        Angle angle = new Angle(2 * Math.PI / 100);
        for (int i = 0; i < points.length; i++) {
            points[i] = Geometry.rotateAround(points[i], center, angle);
        }
        System.out.println("firildak girdi");
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


    //getters and setters


}
