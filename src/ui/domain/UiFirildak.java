package ui.domain;

import game.SquareTakoz;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiFirildak extends UiSquareTakoz implements Observer {

    public UiFirildak(SquareTakoz sq) {
        super(sq);
    }

    @Override
    public void update(Observable o, Object arg) {

    }

}
