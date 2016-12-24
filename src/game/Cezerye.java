package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Cezerye extends Gizmo {


	public Cezerye(int xLoc, int yLoc){

		this.x = xLoc;
		this.y = yLoc;
		this.color = Color.cyan;
		this.height = 20;
		this.width = 20;
        this.time = 0.0;

	}

	public void rotate(){

	}

	@Override
	public String toString() {
		return "Cezerye [x=" + x + ", y=" + y + ", time=" + time + "]";
	}

}