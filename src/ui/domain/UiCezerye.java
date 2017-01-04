package ui.domain;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import game.Cezerye;
import game.Engel;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiCezerye extends UiGizmo {
	private boolean appear = false;
	
	
	public UiCezerye(Cezerye c){
		c.addObserver(this);
		this.x=(int)Math.round(c.getX());
		this.y=(int)Math.round(c.getY());
		this.width=c.getWidth();
		this.height=c.getHeight();
		this.color=c.getColor();
	}

    @Override
    public void update(Observable o, Object arg) {
		if(arg == null){
			System.out.println(arg);
		}else {
			Cezerye cc = (Cezerye) arg;
			this.appear = cc.isCezeryeAppear();
			this.x = (int) Math.round(cc.getX());
			this.y = (int) Math.round(cc.getY());
			this.color = cc.getColor();
		}
    }

	public boolean isAppear() {
		return appear;
	}

	@Override
    public void paint(Graphics g) {
		if(appear) {
			Rectangle clipRect = g.getClipBounds();
			if (clipRect.intersects(this.boundingBox())) {
				g.setColor(color);
				g.fillRect(x, y, width, height);
			}
		}
    }
    private Rectangle boundingBox(){
        return new Rectangle(x, y, width+1, width+1);
    }
}
