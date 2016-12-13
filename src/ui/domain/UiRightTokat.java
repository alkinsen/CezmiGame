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
	
	
	public UiRightTokat(RightTokat r){
		r.addObserver(this);
		this.x=r.getX();
		this.y=r.getY();
		this.color=r.getColor();
		this.state=r.getState();
		this.width=r.getWidth();
		this.height=r.getHeight();
		
	}
	
    @Override
    public void paint(Graphics g) {
    	Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillRect(x, y, width, height);
        }
    }


    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, height+1);
    }

    

    @Override
    public void update(Observable o, Object arg) {
    	
    	System.out.println("righttokat update");
    	RightTokat rt=(RightTokat) arg;
    	 this.x = (int)Math.round(rt.getX());
         this.y = (int)Math.round(rt.getY());
         this.color = rt.getColor();
         this.state=rt.getState();

    }
}
