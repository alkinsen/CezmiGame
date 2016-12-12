package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class SquareTakoz extends Takoz  {
	
	
	//constructor
	public SquareTakoz(int xLoc, int yLoc){
		
		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.darkGray;
		this.height = 25;
		this.width = 25;
		
	}

	//methods
	public void rotate(){

	}

	@Override
	public String toString() {
		return "SquareTakoz [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
	}
	
	
}
