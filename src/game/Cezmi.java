package game;

import java.awt.Color;
import java.util.Observable;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Cezmi extends Observable {

    private int radius;
    private double x;
    private double y;
    private Color color;
    private int vy = 10;
    private int vx = 10;
    private int cezmiLevel;


    public Cezmi(int xLoc, int yLoc, int level) {

        x = xLoc;
        y = yLoc;
        radius = 20;
        color = Color.green;
        cezmiLevel = level;

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newcolor) {
        color = newcolor;
    }

    @Override
    public String toString() {
        return "Cezmi [radius=" + radius + ", x=" + x + ", y=" + y + "]";
    }

    public void moveLeft() {
        if(cezmiLevel == 2 && x <= vx && y > 0 ){
            x = 0;
            y = y - vy;
        }else if(cezmiLevel == 2 && x == 500 & y < 500){
            y = y + vy;
        } else if(x <= 230 && x >= vx) {
            x = x - vx;
        } else if (x >= 270+vx) {
            x = x - vx;
        }
        setChanged();
        notifyObservers(this);
    
    }

    public void moveRight() {
        if(cezmiLevel == 2 && x >= 500-vx && y > 0 ){
            x = 500;
            y = y - vy;
        }else if(cezmiLevel == 2 && x == 0 & y < 500){
            y = y + vy;
        }else if (x + vx <= 230 ) {
            x = x + vx;
        } else if ( x >= 270 && x <= 500 - vx) {
            x = x + vx;
        }
        setChanged();
        notifyObservers(this);
    }

//    public void moveUp() {
//        if (cezmiLevel == 2) {
//            if (x == 0 || x == 500) {
//                if (!(y <= 0) && !(y >= 500)) {
//                    y = y - vy;
//                }
//            }
//        }
//        setChanged();
//        notifyObservers(this);
//    }
//
//    public void moveDown() {
//        if (cezmiLevel == 2) {
//            if (x == 0 || x == 500) {
//                if (!(y <= 0) && !(y >= 500)) {
//                    y = y + vy;
//                }
//            }
//        }
//        setChanged();
//        notifyObservers(this);
//    }
}