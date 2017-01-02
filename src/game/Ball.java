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
	private int radius = HadiCezmi.UNIT_LENGTH;
	private double acceleration= 0.003;
	private double score = 1;
	private String state = "";
	private double player = 1;
	private int tokatCounter = 0;
	private Color color = Color.white;
	
	public Ball() {
		super();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println(state);
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
		
		if(y>500 && vy>0){
			y=494;
			vy=-vy;
		}
		
		x = x + vx;
		y = y + vy;
		vy= vy+acceleration;
		if(getTokatCounter() > 0){
			decrementTokatCounter();
		}

		if(getTokatCounter() == 0){
			this.setScore(1.0);
		}
		setChanged();
		notifyObservers(this);

	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public double getPlayer() {
		return player;
	}

	public void setPlayer(double player) {
		this.player = player;
	}

	public int getTokatCounter() {
		return tokatCounter;
	}

	public void setTokatCounter(int tokatCounter) {
		this.tokatCounter = tokatCounter;
	}
	public void decrementTokatCounter() {
		this.tokatCounter = this.tokatCounter--;
	}

}