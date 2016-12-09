package ui.domain;

import game.TriangleTakoz;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiTriangleTakoz extends UiTakoz{
    public UiTriangleTakoz(TriangleTakoz triangleTakoz){
        triangleTakoz.addObserver(this);

        this.x = (int)Math.round(triangleTakoz.getX());
        this.y = (int)Math.round(triangleTakoz.getY());
        this.width = triangleTakoz.getWidth();
        this.color = triangleTakoz.getColor();

    }

    public void paint(Graphics g) {
        Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillPolygon(getXPoints(), getYPoints(), 3);
        }
    }

    private int[] getXPoints(){
        int[] xPoints = new int[3];
        xPoints[0] = this.x;
        xPoints[1] = this.x;
        xPoints[2] = this.width;
        return xPoints;
    }
    private int[] getYPoints(){
        int[] yPoints = new int[3];
        yPoints[0] = this.y;
        yPoints[1] = this.y+width;
        yPoints[2] = this.y;
        return yPoints;
    }
    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, width+1);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updated triangle takoz");
        TriangleTakoz temp = (TriangleTakoz) arg;

        this.x = (int)Math.round(temp.getX());
        this.y = (int)Math.round(temp.getY());
        this.color = temp.getColor();

    }
}
