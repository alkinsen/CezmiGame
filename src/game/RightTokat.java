package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class RightTokat extends Tokat {

	public RightTokat(int xLoc, int yLoc){

		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.ORANGE;
		this.state = "down";

	}


	public void rotate(){

	}
}
