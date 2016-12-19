package ui.domain;

import java.awt.*;
import java.util.Observable;

import game.Firildak;
import game.LeftTokat;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiLeftTokat extends UiTokat {
	
	protected int[] xPoints;
	protected int[] yPoints;
	
	
	public UiLeftTokat (LeftTokat l){
		l.addObserver(this);
		this.x=l.getX();
		this.y=l.getY();
		this.color=l.getColor();
		this.state=l.getState();
		this.width=l.getWidth();
		this.height=l.getHeight();
		
		xPoints = new int[4];
        yPoints = new int[4];
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) l.getPoints()[i].x();
        	yPoints[i] =(int) l.getPoints()[i].y();
        }
		
	}
	
	
    @Override
    public void paint(Graphics g) {
    	Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillPolygon(xPoints, yPoints, 4);
        }
    }


    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, height+1);
    }

    

    @Override
    public void update(Observable o, Object arg) {
    	
        LeftTokat temp = (LeftTokat) o;
        
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) temp.getPoints()[i].x();
        	yPoints[i] =(int) temp.getPoints()[i].y();
        }
        this.color = temp.getColor();

    }
}
