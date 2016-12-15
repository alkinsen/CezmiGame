package ui.domain;

import game.Ball;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiBall implements Observer {
    private int x;
    private int y;
    private int radius;
    private Color color;

    public UiBall(Ball ball){
        ball.addObserver(this);

        this.x = (int)Math.round(ball.getX());
        this.y = (int)Math.round(ball.getY());
        this.radius = ball.getRadius();
        this.color = ball.getColor();
    }

    public void paint(Graphics g) {
        Rectangle clipRect = g.getClipBounds();
        if (clipRect.intersects(this.boundingBox())) {
            g.setColor(color);
            g.fillOval(x-radius, y-radius, radius+radius, radius+radius);
        }
    }

    private Rectangle boundingBox(){
       return new Rectangle(x-radius, y-radius, radius+radius+1, radius+radius+1);
    }

    @Override
    public void update(Observable o, Object arg) {
        Ball temp = (Ball) arg;

        this.x = (int)Math.round(temp.getX());
        this.y = (int)Math.round(temp.getY());
        this.radius = temp.getRadius();
        this.color = temp.getColor();

    }
}
