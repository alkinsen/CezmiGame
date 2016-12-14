package game;

import java.awt.Color;
import java.util.Observable;

import physics.Vect;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public abstract class Gizmo extends Observable {

    //These are the fields
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;
    protected int orientation;
    protected Vect[] points;
    protected Vect center;

    //methods
    public abstract void rotate();


    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        setChanged();
        notifyObservers();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        setChanged();
        notifyObservers();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        setChanged();
        notifyObservers();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        setChanged();
        notifyObservers();
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setChanged();
        notifyObservers();
    }


    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }


}
