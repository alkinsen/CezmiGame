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
        this.color = Color.yellow;
        this.height = 20;
        this.width = 20;

        //initialize the corners
        points = new Vect[4];
        points[0] = new Vect(xLoc, yLoc);
        points[1] = new Vect(xLoc + width, yLoc);
        points[2] = new Vect(xLoc + width, yLoc + height);
        points[3] = new Vect(xLoc, yLoc + height);


        //initalize the center
        center = new Vect((double) xLoc + (double) width / 2, (double) yLoc + (double) height / 2);


    }

    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        points = new Vect[4];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x + width, y);
        points[2] = new Vect(x + width, y + height);
        points[3] = new Vect(x, y + height);
        center = new Vect((double) x + (double) width / 2, (double) y + (double) height / 2);
        setChanged();
        notifyObservers();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        points = new Vect[4];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x + width, y);
        points[2] = new Vect(x + width, y + height);
        points[3] = new Vect(x, y + height);
        center = new Vect((double) x + (double) width / 2, (double) y + (double) height / 2);
        setChanged();
        notifyObservers();
    }

    @Override
    public void reset() {
        this.width = 20;
        this.height = 20;
        points = new Vect[4];
        points[0] = new Vect(x, y);
        points[1] = new Vect(x + width, y);
        points[2] = new Vect(x + width, y + height);
        points[3] = new Vect(x, y + height);
        setChanged();
        notifyObservers();
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
