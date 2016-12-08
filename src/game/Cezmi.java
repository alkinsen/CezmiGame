package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Cezmi {

	private int radius;
	private int x;
	private int y;
	private Color color;
	
	public Cezmi(int xLoc, int yLoc){
		
		x=xLoc;
		y=yLoc;
		radius=20;
		color=Color.RED;
		
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
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

	@Override
	public String toString() {
		return "Cezmi [radius=" + radius + ", x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	
}
