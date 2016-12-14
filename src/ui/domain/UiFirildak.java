package ui.domain;

import game.Firildak;
import game.SquareTakoz;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiFirildak extends UiSquareTakoz implements Observer {

    public UiFirildak(Firildak sq) {
        super(sq);
        sq.addObserver(this);
    }
    
    

    @Override
    public void update(Observable o, Object arg) {
    	
    	Firildak temp = (Firildak) o;
    	System.out.println("Changed to: x="+temp.getPoints()[0].x()+" and y="+temp.getPoints()[0].y());

    }

}
