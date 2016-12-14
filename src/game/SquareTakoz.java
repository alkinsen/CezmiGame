package game;

import java.awt.Color;

import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class SquareTakoz extends Takoz {


    //constructor
    public SquareTakoz(int xLoc, int yLoc) {

        this.x = xLoc;
        this.y = yLoc;
        this.color = Color.darkGray;
        this.height = 25;
        this.width = 25;

        //initialize the corners
        points = new Vect[4];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc + width, yLoc);
        points[2] = new Vect(xLoc + width, yLoc + height);
        points[3] = new Vect(xLoc, yLoc + height);


        //initalize the center
        center = new Vect((double) xLoc + (double) width / 2, (double) yLoc + (double) height / 2);


    }

    //methods
    public void rotate() {

    }

    @Override
    public String toString() {
        return "SquareTakoz [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
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


}
