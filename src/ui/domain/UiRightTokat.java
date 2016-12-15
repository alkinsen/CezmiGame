package ui.domain;

import game.LeftTokat;
import game.RightTokat;
import game.Tokat;

import java.awt.*;
import java.util.Observable;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiRightTokat extends UiTokat {
	
	protected int[] xPoints;
	protected int[] yPoints;
	
	
	public UiRightTokat(RightTokat r){
		r.addObserver(this);
		this.x=r.getX();
		this.y=r.getY();
		this.color=r.getColor();
		this.state=r.getState();
		this.width=r.getWidth();
		this.height=r.getHeight();
		
		xPoints = new int[4];
        yPoints = new int[4];
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) r.getPoints()[i].x();
        	yPoints[i] =(int) r.getPoints()[i].y();
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
    
        RightTokat temp = (RightTokat) o;
        
        for(int i=0; i<4; i++){
        	xPoints[i] =(int) temp.getPoints()[i].x();
        	yPoints[i] =(int) temp.getPoints()[i].y();
        }
        this.color = temp.getColor();

    }
}
