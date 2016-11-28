package game;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Player {
	String name;
	int score;
	
	public Player(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
}
