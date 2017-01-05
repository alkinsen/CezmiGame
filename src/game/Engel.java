package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Engel extends Observable{
	private int x = 247; // 247.5 olmalı
	private int y = 440;
	private int width = 5;
	private int height = 60;
	private Color color = Color.cyan;
	
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

  	public Rectangle boundingBox() {
	    return new Rectangle(x, y, width, height);
  }

	public Color getColor() {
	return color;
}

	public void setColor(Color color) {
	this.color = color;
}

	public void setWidth(int width) {
	this.width = width;
}

	public void setHeight(int height) {
	this.height = height;
}

}
