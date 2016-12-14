package game;

import java.awt.Color;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class LeftTokat extends Tokat {


    public LeftTokat(int xLoc, int yLoc) {

        this.x = xLoc;
        this.y = yLoc;
        this.color = Color.ORANGE;
        this.state = "down";
        this.width = 10;
        this.height = 40;
    }

    public void rotate() {

    }

}
