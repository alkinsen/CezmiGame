package xml;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class XMLParser {

	private Document doc;
	File CezmiFile;

	public XMLParser(File CezmiFile){

		try {	
			this.CezmiFile = CezmiFile;
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(CezmiFile);
			doc.getDocumentElement().normalize();


			//this.element = 
			//this.cezmi1Level = element.getAttribute("level");
			//cezmi1intX = Integer.parseInt(cezmi1X);	


		}catch(Exception e){
			System.out.println(e.toString());
		} 

	}

	private int getLevel(){
		Node tempNode;
		NodeList tempNodeList;
		int cezmi1intLevel = 1;

		try{
			tempNodeList = doc.getElementsByTagName("board");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					String cezmi1Level = eElement.getAttribute("level");
					cezmi1intLevel = Integer.parseInt(cezmi1Level);

				}
			}		

		}catch(Exception e){
			System.out.println(e.toString());
		} 

		return cezmi1intLevel;

	}

	public ArrayList<HashMap<String, String>> createBallFromXml(){ 
		ArrayList<HashMap<String, String>> ballList = new ArrayList<>();
		HashMap<String, String> ballInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("ball");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;
					ballInfo.put("type", "ball");
					
					String ballX = eElement.getAttribute("x");
					double ballDoubleX = Double.parseDouble(ballX);	
					String ballY = eElement.getAttribute("y");
					double ballDoubleY = Double.parseDouble(ballY);	
					String ballVX = eElement.getAttribute("xVelocity");
					double ballDoubleVX = Double.parseDouble(ballVX);	
					String ballVY = eElement.getAttribute("yVelocity");
					double ballDoubleVY = Double.parseDouble(ballVY);	

					ballInfo.put("x", eElement.getAttribute("x"));
					ballInfo.put("y", eElement.getAttribute("y"));
					ballInfo.put("vx", eElement.getAttribute("xVelocity"));
					ballInfo.put("vy", eElement.getAttribute("yVelocity"));

					ballList.add(ballInfo);
				}

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return ballList;
	}

	public ArrayList<HashMap<String, String>> createCezmi1FromXml() {
		ArrayList<HashMap<String, String>> cezmiList = new ArrayList<>();
		HashMap<String, String> cezmiInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("cezmi1");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					cezmiInfo.put("type", "Cezmi");

					//

					String cezmi1X = eElement.getAttribute("x");
					double cezmi1intX = Double.parseDouble(cezmi1X);					
					String cezmi1Y = eElement.getAttribute("y");
					double cezmi1intY = Double.parseDouble(cezmi1Y);	


					if (getLevel() == 1){
						if (cezmi1intX <= 247 && cezmi1intX > 0 && cezmi1intY == 500){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}

					if (getLevel() == 2){
						if ((cezmi1intX <= 247 && cezmi1intX > 0 && cezmi1intY == 500) || (cezmi1intX == 0 && cezmi1intY > 0 && cezmi1intY < 500)){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}

					//

					String cezmi1Score = eElement.getAttribute("score");
					int cezmi1intScore = Integer.parseInt(cezmi1Score);

					if (cezmi1intScore < 10 && cezmi1intScore >= 0){
						cezmiInfo.put("score", eElement.getAttribute("score"));
					}
					else{
						throw new Error("Invalid score for Cezmi1");
					}

					cezmiList.add(cezmiInfo);
				}

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList;
	}

	public ArrayList<HashMap<String, String>> createCezmi2FromXml() {
		ArrayList<HashMap<String, String>> cezmiList = new ArrayList<>();
		HashMap<String, String> cezmiInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("cezmi2");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					cezmiInfo.put("type", "Cezmi");

					//

					String cezmi2X = eElement.getAttribute("x");
					double cezmi2DoubleX = Double.parseDouble(cezmi2X);					
					String cezmi2Y = eElement.getAttribute("y");
					double cezmi2DoubleY = Double.parseDouble(cezmi2Y);	


					if (getLevel() == 1){
						if (cezmi2DoubleX >= 253 && cezmi2DoubleX < 500 && cezmi2DoubleY == 500){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}

					if (getLevel() == 2){
						if ((cezmi2DoubleX >= 253 && cezmi2DoubleX < 500 && cezmi2DoubleY == 500) || (cezmi2DoubleX == 500 && cezmi2DoubleY > 0 && cezmi2DoubleY < 500)){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}

					//

					String cezmi2Score = eElement.getAttribute("score");
					int cezmi2DoubleScore = Integer.parseInt(cezmi2Score);

					if (cezmi2DoubleScore < 10 && cezmi2DoubleScore >= 0){
						cezmiInfo.put("score", eElement.getAttribute("score"));
					}
					else{
						throw new Error("Invalid score for Cezmi2");
					}

					cezmiList.add(cezmiInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList;
	}

	public ArrayList<HashMap<String, String>> createCezeryeFromXml() {
		ArrayList<HashMap<String, String>> cezeryeList = new ArrayList<>();

		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("cezeryes");

			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;
					HashMap<String, String> cezeryeInfo = new HashMap<String, String>();


					if(!eElement.getAttribute("x").equals("")){

						cezeryeInfo.put("type", "Cezerye");

						String cezeryeX = eElement.getAttribute("x");
						int  cezeryeIntX = Integer.parseInt(cezeryeX);
						String cezeryeY = eElement.getAttribute("y");
						int  cezeryeIntY = Integer.parseInt(cezeryeY);
						String cezeryeTime = eElement.getAttribute("time");
						double cezeryeDoubleTime =  Double.parseDouble(cezeryeTime);	

						if(cezeryeIntX > 0 && cezeryeIntX < 500 && cezeryeIntY > 0 && cezeryeIntY < 380 && cezeryeDoubleTime > 0 && cezeryeDoubleTime <= 5){
							cezeryeInfo.put("x", eElement.getAttribute("x"));
							cezeryeInfo.put("y", eElement.getAttribute("y"));
							cezeryeInfo.put("time", eElement.getAttribute("time"));
						}
						else{
							throw new Error("Invalid location for Cezerye");
						}
					}
					else{
						cezeryeInfo.put("x", "1");
						cezeryeInfo.put("y", "1");
						cezeryeInfo.put("time", "0.0");
					}		

					cezeryeList.add(cezeryeInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezeryeList;
	}  

	public ArrayList<HashMap<String, String>> createGizmoFromXml() {
		ArrayList<HashMap<String, String>> gizmoList = new ArrayList<>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("squareTakoz");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "SquareTakoz");
					gizmoInfo.put("x", eElement.getAttribute("x"));
					gizmoInfo.put("y", eElement.getAttribute("y"));

					gizmoList.add(gizmoInfo);
				}
			}

			tempNodeList = doc.getElementsByTagName("triangleTakoz");
			for (int temp1 = 0; temp1 < tempNodeList.getLength(); temp1++) {
				tempNode = tempNodeList.item(temp1);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement1 = (Element) tempNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "TriangleTakoz");
					gizmoInfo.put("x", eElement1.getAttribute("x"));
					gizmoInfo.put("y", eElement1.getAttribute("y"));
					gizmoInfo.put("orientation", eElement1.getAttribute("orientation"));

					gizmoList.add(gizmoInfo);
				}
			}

			tempNodeList = doc.getElementsByTagName("firildak");
			for (int temp2= 0; temp2 < tempNodeList.getLength(); temp2++) {
				tempNode = tempNodeList.item(temp2);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement2 = (Element) tempNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "Firildak");
					gizmoInfo.put("x", eElement2.getAttribute("x"));
					gizmoInfo.put("y", eElement2.getAttribute("y"));
					gizmoInfo.put("angle", eElement2.getAttribute("angle"));

					gizmoList.add(gizmoInfo);
				}
			}

			tempNodeList = doc.getElementsByTagName("leftTokat");
			for (int temp3= 0; temp3 < tempNodeList.getLength(); temp3++) {
				tempNode = tempNodeList.item(temp3);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement3 = (Element) tempNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "LeftTokat");
					gizmoInfo.put("x", eElement3.getAttribute("x"));
					gizmoInfo.put("y", eElement3.getAttribute("y"));
					gizmoInfo.put("orientation", eElement3.getAttribute("orientation"));

					gizmoList.add(gizmoInfo);
				}
			}

			tempNodeList = doc.getElementsByTagName("rightTokat");
			for (int temp3= 0; temp3 < tempNodeList.getLength(); temp3++) {
				tempNode = tempNodeList.item(temp3);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement3 = (Element) tempNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "rightTokat");
					gizmoInfo.put("x", eElement3.getAttribute("x"));
					gizmoInfo.put("y", eElement3.getAttribute("y"));
					gizmoInfo.put("orientation", eElement3.getAttribute("orientation"));

					gizmoList.add(gizmoInfo);
				}
			} 

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return gizmoList;
	}

	public ArrayList<HashMap<String, String>> createKeysFromXml() {
		ArrayList<HashMap<String, String>> keysList = new ArrayList<>();
		HashMap<String, String> keysInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("key1left");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;	

					keysInfo.put("type", "keys");

					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key1left", eElement.getAttribute("key"));	
					}

					keysList.add(keysInfo);
				}  

			}

			tempNodeList = doc.getElementsByTagName("key1right");
			for (int temp1 = 0; temp1 < tempNodeList.getLength(); temp1++) {
				tempNode = tempNodeList.item(temp1);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key1right", eElement.getAttribute("key"));	
					}

					keysList.add(keysInfo);
				}  

			}

			tempNodeList = doc.getElementsByTagName("key2left");
			for (int temp2 = 0; temp2 < tempNodeList.getLength(); temp2++) {
				tempNode = tempNodeList.item(temp2);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key2left", eElement.getAttribute("key"));	
					}	

					keysList.add(keysInfo);
				}
			}

			tempNodeList = doc.getElementsByTagName("key2right");
			for (int temp3 = 0; temp3 < tempNodeList.getLength(); temp3++) {
				tempNode = tempNodeList.item(temp3);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key2right", eElement.getAttribute("key"));	
					}	

					keysList.add(keysInfo);
				}
			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return keysList;
	}

	public ArrayList<HashMap<String, String>> createBoardFromXml() {
		ArrayList<HashMap<String, String>> boardList = new ArrayList<>();
		HashMap<String, String> boardInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("board");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("friction1") != ""){
						boardInfo.put("friction1", eElement.getAttribute("friction1"));
					}
					else{
						boardInfo.put("friction1", "0.025");
					}

					boardList.add(boardInfo);
				}  

			}

			for (int temp1 = 0; temp1 < tempNodeList.getLength(); temp1++) {
				tempNode = tempNodeList.item(temp1);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("friction2") != ""){
						boardInfo.put("friction2", eElement.getAttribute("friction2"));
					}
					else{
						boardInfo.put("friction2", "0.025");
					}

					boardList.add(boardInfo);
				}  

			}

			for (int temp2 = 0; temp2 < tempNodeList.getLength(); temp2++) {
				tempNode = tempNodeList.item(temp2);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					if(eElement.getAttribute("gravity") != ""){
						boardInfo.put("gravity", eElement.getAttribute("gravity"));
					}
					else{
						boardInfo.put("gravity", "25.0");
					}
					boardList.add(boardInfo);
				}  

			}

			for (int temp3 = 0; temp3 < tempNodeList.getLength(); temp3++) {
				tempNode = tempNodeList.item(temp3);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					boardInfo.put("level", eElement.getAttribute("level"));

					boardList.add(boardInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return boardList;
	}	

}



