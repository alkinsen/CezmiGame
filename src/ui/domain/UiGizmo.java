package ui.domain;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public abstract class UiGizmo implements Observer {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Color color;

    public abstract void paint(Graphics g);
}
