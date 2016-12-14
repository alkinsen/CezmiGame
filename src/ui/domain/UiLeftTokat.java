package ui.domain;

import java.awt.*;
import java.util.Observable;

import game.LeftTokat;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiLeftTokat extends UiTokat {
	
	
	public UiLeftTokat (LeftTokat l){
		l.addObserver(this);
		this.x=l.getX();
		this.y=l.getY();
		this.color=l.getColor();
		this.state=l.getState();
		this.width=l.getWidth();
		this.height=l.getHeight();
		
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
    	
    	System.out.println("lefttokat update");
    	LeftTokat lt=(LeftTokat) arg;
    	 this.x = (int)Math.round(lt.getX());
         this.y = (int)Math.round(lt.getY());
         this.color = lt.getColor();
         this.state=lt.getState();

    }
}
