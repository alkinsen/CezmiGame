package ui.domain;

import game.Firildak;
import game.SquareTakoz;
import game.TriangleTakoz;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiFirildak extends UiSquareTakoz implements Observer {
	protected int angularVelocity;
	protected int[] xPoints;
	protected int[] yPoints;

    public UiFirildak(Firildak sq) {
        super(sq);
        sq.addObserver(this);
        
        xPoints = new int[4];
        yPoints = new int[4];
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) sq.getPoints()[i].x();
        	yPoints[i] =(int) sq.getPoints()[i].y();
        }
        
        
    }
    public void paint(Graphics g) {
    	Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillPolygon(xPoints, yPoints, 4);
        }
    }


    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, width+1);
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
    	
    	System.out.println("updated firildak");
        Firildak temp = (Firildak) o;
        
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) temp.getPoints()[i].x();
        	yPoints[i] =(int) temp.getPoints()[i].y();
        }
        this.color = temp.getColor();
    	

    }

}