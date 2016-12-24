package game;

import ui.GameFrame;

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

	private double x = (int) HadiCezmi.UNIT_LENGTH*15;
	private double y = (int)0;
	//private double vx = ((int)(Math.random() * 10.0))/20.0;
	private double vx = 1;
	//private double vy = ((int)(Math.random() * 10.0))/20.0;
	private double vy = 0;
	private int radius = (HadiCezmi.UNIT_LENGTH*6)/20;
	private double acceleration= 0.003;
	
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
		if(x<0 && vx<0){
			x=0;
			vx=-vx;
		}else if(x>495 && vx>0){
			x=494;
			vx=-vx;
		}
		
		if(y<0 && vy<0){
			y=0;
			vy=-vy;
		}else if(y>495 && vy>0){
			y=494;
			vy=-vy;
		}
		
		x = x + vx;
		y = y + vy;
		vy= vy+acceleration;
		setChanged();
		notifyObservers(this);

	}
	
}