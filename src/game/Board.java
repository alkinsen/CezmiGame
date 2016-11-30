package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Board {
	private int width = 500;
	private int height = 500;
	private Color color = new Color(0, 0, 255);
	
	public Board() {
		super();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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
	      g.fillRect(0, 0, width, height);
	    }
	  }
  
  public Rectangle boundingBox() {
	    // effect: Returns the smallest rectangle that completely covers the
	    //         current position of the ball.

	    // a Rectangle is the x,y for the upper left corner and then the
	    // width and height
	    return new Rectangle(0, 0, width, height);
	  }
	
	
	
}
