package ui.domain;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import game.Engel;
import game.SquareTakoz;

public class UiEngel implements Observer{
	private int x;
	private int y;
	private int width;
	private int height;
	private Color color;
	
	   public UiEngel(Engel e){
	        e.addObserver(this);

	        this.x = (int)Math.round(e.getX());
	        this.y = (int)Math.round(e.getY());
	        this.width = e.getWidth();
	        this.height = e.getHeight();
	        this.color = e.getColor();

	    }

	    public void paint(Graphics g) {
	        Rectangle clipRect = g.getClipBounds();
	        if (clipRect.intersects(this.boundingBox())) {
	            g.setColor(color);
	            g.fillRect(x, y, width, height);
	        }
	    }
	    
	    private Rectangle boundingBox(){
	        return new Rectangle(x, y, width+1, width+1);
	    }

	    @Override
	    public void update(Observable o, Object arg) {
	        System.out.println("update engel");
	        Engel temp = (Engel) arg;

	        this.x = (int)Math.round(temp.getX());
	        this.y = (int)Math.round(temp.getY());
	        this.color = temp.getColor();

	    }

}
