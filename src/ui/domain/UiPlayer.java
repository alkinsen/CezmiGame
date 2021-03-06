package ui.domain;

import java.util.Observable;
import java.util.Observer;

import game.Player;

/**
 * Created by ASEN14 on 9.12.2016.
 */
public class UiPlayer implements Observer {
	private String name;
	private double score;
	private int numOfEdit;
	private int numOfGizmo;
	
	public UiPlayer(Player p){
		this.name=p.getName();
		this.score=p.getScore();
		this.numOfEdit=p.getNumOfEdit();
		this.numOfGizmo=p.getNumOfGizmo();
		
		
	}

    @Override
    public void update(Observable o, Object arg) {
    	Player pp=(Player) arg;
    	
    	this.name=pp.getName();
    	this.score=pp.getScore();
    	this.numOfEdit=pp.getNumOfEdit();
    	this.numOfGizmo=pp.getNumOfGizmo();

    }
}
