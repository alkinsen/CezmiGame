package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class TriangleTakoz extends Takoz {
	
	
	//constructor
	public TriangleTakoz(int xLoc, int yLoc){
		
		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.darkGray;
		this.width = 25;
		this.height = 25;

	}
	
	//methods
	public void rotate(){

	}

	@Override
	public String toString() {
		return "TriangleTakoz [x=" + x + ", y=" + y + ", orientation=" + orientation + "]";
	}
	
	
}
