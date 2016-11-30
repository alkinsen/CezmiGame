package game;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Player {
	String name;
	int score;
	int numOfEdit;
	
	public Player(String name){
		this.name = name;
		this.score = 0;
		this.numOfEdit = 3;
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

	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore(){
		this.score += 1;
	}
	
	public int getNumOfEdit() {
		return numOfEdit;
	}

	public void setNumOfEdit(int numOfEdit) {
		this.numOfEdit = numOfEdit;
	}
	
	public void decrementNumOfEdit(){
		this.numOfEdit -= 1;
	}
	
	public boolean checkNumOfEdit(){
		if(numOfEdit >=1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
