package game;

import java.util.Observable;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class Player extends Observable {
    private String name;
    private double score;
    private int numOfEdit;
    private int numOfGizmo;


    public Player() {
        this.score = 0;
        this.numOfEdit = 3;
    }

    public Player(String name) {
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getNumOfEdit() {
        return numOfEdit;
    }

    public void setNumOfEdit(int numOfEdit) {
        this.numOfEdit = numOfEdit;
    }

    public void decrementNumOfEdit() {
        this.numOfEdit -= 1;
    }

    public boolean checkNumOfEdit() {
        if (numOfEdit >= 1) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumOfGizmo() {
        return numOfGizmo;
    }

    public void setNumOfGizmo(int numOfGizmo) {
        this.numOfGizmo = numOfGizmo;
    }

    public void decrementNumOfGizmo() {
        this.numOfGizmo -= 1;
    }

    public boolean checkNumOfGizmo() {
        if (numOfGizmo <= 4) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Player [name=" + name + ", score=" + score + ", numOfEdit=" + numOfEdit + ", numOfGizmo=" + numOfGizmo
                + "]";
    }


}
