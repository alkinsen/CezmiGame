package ui.domain;

import game.Firildak;
import game.SquareTakoz;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiFirildak extends UiSquareTakoz implements Observer {
	protected int angularVelocity;

    public UiFirildak(Firildak sq) {
        super(sq);
        sq.addObserver(this);
        
        
    }
    public void paint(Graphics g) {
        Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillRect(x, y, width, width);
        }
    }


    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, width+1);
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
    	System.out.println("firildak's update");
    	Firildak f=(Firildak) arg;
    	this.x = (int)Math.round(f.getX());
        this.y = (int)Math.round(f.getY());
        this.color = f.getColor();
        this.width=f.getWidth();
        this.height=f.getHeight();

    }

}