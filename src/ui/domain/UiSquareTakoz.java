package ui.domain;

import game.Firildak;
import game.SquareTakoz;
import game.Takoz;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiSquareTakoz extends UiTakoz {

	public UiSquareTakoz(SquareTakoz sq){
		if(!(sq instanceof Firildak)){
			sq.addObserver(this);
		}

		this.x = (int)Math.round(sq.getX());
		this.y = (int)Math.round(sq.getY());
		this.width = sq.getWidth();
		this.color = sq.getColor();

	}

	public void paint(Graphics g) {
		Rectangle clipRect = g.getClipBounds();
		if (clipRect.intersects(this.boundingBox())) {
			g.setColor(color);
			g.fillRect(x, y, width, width);
		}
	}


	private Rectangle boundingBox(){
		return new Rectangle(x, y, width+1, width+1);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("update square takoz");
		SquareTakoz temp = (SquareTakoz) o;

		this.x = (int)Math.round(temp.getX());
		this.y = (int)Math.round(temp.getY());
		this.color = temp.getColor();

	}
}
