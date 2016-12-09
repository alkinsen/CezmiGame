package ui.domain;

import game.Cezmi;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiCezmi implements Observer {
    private int radius;
    private int x;
    private int y;
    private Color color;

    public UiCezmi(Cezmi cezmi){
        cezmi.addObserver(this);

        this.x = (int)Math.round(cezmi.getX());
        this.y = (int)Math.round(cezmi.getY());
        this.radius = cezmi.getRadius();
        this.color = cezmi.getColor();

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
        System.out.println("update uicezmi");
        Cezmi temp = (Cezmi) arg;

        this.x = (int)Math.round(temp.getX());
        this.y = (int)Math.round(temp.getY());
        this.radius = temp.getRadius();
        this.color = temp.getColor();

    }
}
