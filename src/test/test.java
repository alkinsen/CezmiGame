package test;

import java.io.File;
import game.*;

import game.HadiCezmi;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HadiCezmi hadi = new HadiCezmi(1, "doruk", "yilmazcan");
		hadi.readXML(new File("CezmiPrototype3.xml"));
		hadi.play();
	}

}
