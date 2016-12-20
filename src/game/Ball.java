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
	//private double vx = ((int)(Math.random() * 10.0))/20.0;
	private double vx = 1;
	//private double vy = ((int)(Math.random() * 10.0))/20.0;
	private double vy = 1;
	private int radius = 6;
	
	private Color color = Color.white;
	
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
		x = x + vx;
		y = y + vy;
		setChanged();
		notifyObservers(this);

	}
	
	public void paint(Graphics g) {
		Rectangle clipRect = g.getClipBounds();

		if (clipRect.intersects(this.boundingBox())) {
			g.setColor(color);
			g.fillOval((int)(x-radius), (int)(y-radius), radius+radius, radius+radius);
		}
	}
	
	public Rectangle boundingBox() {
		return new Rectangle((int)(x-radius), (int)(y-radius), radius+radius, radius+radius);
	}


	

	
}