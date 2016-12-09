package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Ball extends Observable{

	private double x = (int)((Math.random() * 100.0) + 100.0);
	private double y = (int)((Math.random() * 100.0) + 100.0);
	private double vx = ((int)(Math.random() * 10.0))/20.0;
	private double vy = ((int)(Math.random() * 10.0))/20.0;
	private int radius = 6;
	
	private Color color = new Color(255, 0, 0);
	
	public Ball() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vx;
	}

	public void setVx(double vx) {
		this.vx = vx;
	}

	public double getVy() {
		return vy;
	}

	public void setVy(double vy) {
		this.vy = vy;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "Ball [x=" + x + ", y=" + y + ", vx=" + vx + ", vy=" + vy + "]";
	}
	
	public void move(){
		x = x + 10;
		y = y + 10;
		setChanged();
		notifyObservers(this);

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
			g.fillOval((int)(x-radius), (int)(y-radius), radius+radius, radius+radius);
		}
	}
	
	public Rectangle boundingBox() {
		// effect: Returns the smallest rectangle that completely covers the
		//         current position of the ball.

		// a Rectangle is the x,y for the upper left corner and then the
		// width and height
		return new Rectangle((int)(x-radius), (int)(y-radius), radius+radius, radius+radius);
	}


	

	
}