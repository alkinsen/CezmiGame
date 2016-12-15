package ui.domain;

import game.TriangleTakoz;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiTriangleTakoz extends UiTakoz{
	
	protected int[] xPoints;
	protected int[] yPoints;
	
    public UiTriangleTakoz(TriangleTakoz triangleTakoz){
        triangleTakoz.addObserver(this);

        this.x = (int)Math.round(triangleTakoz.getX());
        this.y = (int)Math.round(triangleTakoz.getY());
        this.width = triangleTakoz.getWidth();
        this.color = triangleTakoz.getColor();
        
        xPoints = new int[3];
        yPoints = new int[3];
        for(int i=0; i<3; i++){
        	xPoints[i] =(int) triangleTakoz.getPoints()[i].x();
        	yPoints[i] =(int) triangleTakoz.getPoints()[i].y();
        }

    }

    public void paint(Graphics g) {
        Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillPolygon(xPoints, yPoints, 3);
        }
    }

    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, width+1);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("updated triangle takoz");
        TriangleTakoz temp = (TriangleTakoz) o;
        
        for(int i=0; i<3; i++){
        	xPoints[i] =(int) temp.getPoints()[i].x();
        	yPoints[i] =(int) temp.getPoints()[i].y();
        }
        this.color = temp.getColor();

    }
}
