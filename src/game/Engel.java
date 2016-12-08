package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Engel {
	private int x = 247; // 247.5 olmalı
	private int y = 440;
	private int width = 5;
	private int height = 60;
	private Color color = new Color(0, 255, 0);
	
	public Engel() {
		super();
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth(){
		return width;
	}
	
	public int getHeight(){
		return height;
	}
	
	@Override
	public String toString() {
		return "Engel [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
	public void paint(Graphics g) {
	    // modifies: the Graphics object <g>.
	    // effects: paints a circle on <g> reflecting the current position
	    // of the ball.

	    // the "clip rectangle" is the area of the screen that needs to be
	    // modified
	    Rectangle clipRect = g.getClipBounds();

	    // For this tiny program, testing whether we need to redraw is
	    // kind of silly.  But when there are lots of objects all over the
	    // screen this is a very important performance optimization
	    if (clipRect.intersects(this.boundingBox())) {
	      g.setColor(color);
	      g.fillRect(x, y, width, height);
	    }
	  }
  
  public Rectangle boundingBox() {
	    // effect: Returns the smallest rectangle that completely covers the
	    //         current position of the ball.

	    // a Rectangle is the x,y for the upper left corner and then the
	    // width and height
	    return new Rectangle(x, y, width, height);
	  }
	
	
}
