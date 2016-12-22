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

		}catch(Exception e){
			System.out.println(e.toString());
		} 

	}

	private int getLevel(){
		Node tempNode;
		NodeList tempNodeList;
		int cezmiIntLevel = 1;

		try{
			tempNodeList = doc.getElementsByTagName("board");
			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);

				if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) tempNode;

					String cezmiLevel = eElement.getAttribute("level");
					cezmiIntLevel = Integer.parseInt(cezmiLevel);

				}
			}		

		}catch(Exception e){
			System.out.println(e.toString());
		} 

		return cezmiIntLevel;

	}

	public ArrayList<HashMap<String, String>> createBallFromXml(){ 
		ArrayList<HashMap<String, String>> ballList = new ArrayList<>();
		Node tempNode;
		NodeList tempNodeList;
		try {
			tempNodeList = doc.getElementsByTagName("ball");
			if(tempNodeList.getLength() != 0){

				for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
					tempNode = tempNodeList.item(temp);

					HashMap<String, String> ballInfo = new HashMap<String, String>();
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

					if (getLevel() == 1){
						if(tempNodeList.getLength() == 1){
							if(ballDoubleX < 500 && ballDoubleX > 0 && ballDoubleY < 500 && ballDoubleY > 0 && ballDoubleVX >= 0 && ballDoubleVY >= 0){
								ballInfo.put("x", eElement.getAttribute("x"));
								ballInfo.put("y", eElement.getAttribute("y"));
								ballInfo.put("vx", eElement.getAttribute("xVelocity"));
								ballInfo.put("vy", eElement.getAttribute("yVelocity"));
							}
							else{
								throw new Error("Invalid location for Ball");
							}
						}
						else{
							throw new Error("Invalid number of balls");
						}
					}
					else if(getLevel() ==2){
						if(tempNodeList.getLength() == 2){
							if(ballDoubleX < 500 && ballDoubleX > 0 && ballDoubleY < 500 && ballDoubleY > 0 && ballDoubleVX >= 0 && ballDoubleVY >= 0){
								ballInfo.put("x", eElement.getAttribute("x"));
								ballInfo.put("y", eElement.getAttribute("y"));
								ballInfo.put("vx", eElement.getAttribute("xVelocity"));
								ballInfo.put("vy", eElement.getAttribute("yVelocity"));
							}
							else{
								throw new Error("Invalid location for Ball");
							}
						}
						else{
							throw new Error("Invalid number of balls");
						}
					}
					else{
						throw new Error("Invalid level");
					}
					ballList.add(ballInfo);
				}
			}
			else{
				throw new Error("There is no Ball");
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
			if(tempNodeList.getLength() != 0){
				for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
					tempNode = tempNodeList.item(temp);

					Element eElement = (Element) tempNode;

					cezmiInfo.put("type", "Cezmi");

					String cezmi1X = eElement.getAttribute("x");
					double cezmi1intX = Double.parseDouble(cezmi1X);					
					String cezmi1Y = eElement.getAttribute("y");
					double cezmi1intY = Double.parseDouble(cezmi1Y);	

					if (getLevel() == 1){
						if (cezmi1intX <= 247 && cezmi1intX >= 0 && cezmi1intY == 500){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}

					else if (getLevel() == 2){
						if ((cezmi1intX <= 247 && cezmi1intX >= 0 && cezmi1intY == 500) || (cezmi1intX == 0 && cezmi1intY >= 0 && cezmi1intY <= 500)){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}
					else{
						throw new Error("Invalid level");
					}

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
			else{
				throw new Error("There is no Cezmi1");
			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList;
	}

	public ArrayList<HashMap<String, String>> createCezmi2FromXml() {
		ArrayList<HashMap<String, String>> cezmiList2 = new ArrayList<>();
		HashMap<String, String> cezmiInfo = new HashMap<String, String>();
		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("cezmi2");
			if(tempNodeList.getLength() == 1){
				for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
					tempNode = tempNodeList.item(temp);

					Element eElement = (Element) tempNode;

					cezmiInfo.put("type", "Cezmi");

					String cezmi2X = eElement.getAttribute("x");
					double cezmi2DoubleX = Double.parseDouble(cezmi2X);					
					String cezmi2Y = eElement.getAttribute("y");
					double cezmi2DoubleY = Double.parseDouble(cezmi2Y);	

					if (getLevel() == 1){
						if (cezmi2DoubleX >= 253 && cezmi2DoubleX <= 500 && cezmi2DoubleY == 500){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}

					else if (getLevel() == 2){
						if ((cezmi2DoubleX >= 253 && cezmi2DoubleX <= 500 && cezmi2DoubleY == 500) || (cezmi2DoubleX == 500 && cezmi2DoubleY >= 0 && cezmi2DoubleY <= 500)){
							cezmiInfo.put("x", eElement.getAttribute("x"));
							cezmiInfo.put("y", eElement.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}
					else{
						throw new Error("Invalid level");
					}

					String cezmi2Score = eElement.getAttribute("score");
					int cezmi2DoubleScore = Integer.parseInt(cezmi2Score);

					if (cezmi2DoubleScore < 10 && cezmi2DoubleScore >= 0){
						cezmiInfo.put("score", eElement.getAttribute("score"));
					}
					else{
						throw new Error("Invalid score for Cezmi2");
					}

					cezmiList2.add(cezmiInfo);
				}
			}
			else{
				throw new Error("There can if and only if one Cezmi2");
			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList2;
	}

	public ArrayList<HashMap<String, String>> createCezeryeFromXml() {
		ArrayList<HashMap<String, String>> cezeryeList = new ArrayList<>();

		Node tempNode;
		NodeList tempNodeList;

		try {
			tempNodeList = doc.getElementsByTagName("cezerye");
			if(tempNodeList.getLength() > 0){

				for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
					tempNode = tempNodeList.item(temp);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) tempNode;
						HashMap<String, String> cezeryeInfo = new HashMap<String, String>();

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
						cezeryeList.add(cezeryeInfo);
					}  
				}
			}
			else{
				HashMap<String, String> cezeryeInfo = new HashMap<String, String>();
				cezeryeInfo.put("type", "Cezerye");
				cezeryeInfo.put("x", "1");
				cezeryeInfo.put("y", "1");
				cezeryeInfo.put("time", "0.0");
				cezeryeList.add(cezeryeInfo);
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
		NodeList tempNodeList2;
		NodeList tempNodeList3;
		NodeList tempNodeList4;
		NodeList tempNodeList5;
		NodeList tempNodeList6;

		tempNodeList = doc.getElementsByTagName("gizmos");
		tempNodeList2 = doc.getElementsByTagName("squareTakoz");
		tempNodeList3 = doc.getElementsByTagName("triangleTakoz");
		tempNodeList4 = doc.getElementsByTagName("firildak");
		tempNodeList5 = doc.getElementsByTagName("leftTokat");
		tempNodeList6 = doc.getElementsByTagName("rightTokat");

		if((tempNodeList2.getLength() + tempNodeList3.getLength() + tempNodeList4.getLength() + tempNodeList5.getLength() + tempNodeList6.getLength()) == 8){

			for (int temp = 0; temp < tempNodeList.getLength(); temp++) {
				tempNode = tempNodeList.item(temp);}
			try {
				tempNodeList = doc.getElementsByTagName("squareTakoz");
				for (int temp5 = 0; temp5 < tempNodeList.getLength(); temp5++) {
					tempNode = tempNodeList.item(temp5);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) tempNode;

						HashMap<String, String> gizmoInfo = new HashMap<String, String>();

						if(!eElement.getAttribute("x").equals("")){

							gizmoInfo.put("type", "SquareTakoz");

							String squareTakozX = eElement.getAttribute("x");
							int  squareTakozIntX = Integer.parseInt(squareTakozX);
							String squareTakozY = eElement.getAttribute("y");
							int  squareTakozIntY = Integer.parseInt(squareTakozY);

							if(squareTakozIntX > 0 && squareTakozIntX < 380 && squareTakozIntY > 0 && squareTakozIntY < 380){
								gizmoInfo.put("x", eElement.getAttribute("x"));
								gizmoInfo.put("y", eElement.getAttribute("y"));
							}
							else{
								throw new Error("Invalid location for Square Takoz");
							}

						}

						gizmoList.add(gizmoInfo);
					}
				}

				tempNodeList = doc.getElementsByTagName("triangleTakoz");
				for (int temp1 = 0; temp1 < tempNodeList.getLength(); temp1++) {
					tempNode = tempNodeList.item(temp1);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement1 = (Element) tempNode;

						HashMap<String, String> gizmoInfo = new HashMap<String, String>();

						if(!eElement1.getAttribute("x").equals("")){

							gizmoInfo.put("type", "TriangleTakoz");

							String triangleTakozX = eElement1.getAttribute("x");
							int  triangleTakozIntX = Integer.parseInt(triangleTakozX);
							String triangleTakozY = eElement1.getAttribute("y");
							int  triangleTakozIntY = Integer.parseInt(triangleTakozY);
							String triangleTakozOrientation = eElement1.getAttribute("orientation");
							int triangleTakozIntOrientation = Integer.parseInt(triangleTakozOrientation);

							if(triangleTakozIntX > 0 && triangleTakozIntX < 380 && triangleTakozIntY > 0 && triangleTakozIntY < 380){
								gizmoInfo.put("x", eElement1.getAttribute("x"));
								gizmoInfo.put("y", eElement1.getAttribute("y"));	
							}
							else{
								throw new Error("Invalid location for Triangle Takoz");
							}
							if(triangleTakozIntOrientation == 0 || triangleTakozIntOrientation == 90 || triangleTakozIntOrientation == 180 || triangleTakozIntOrientation == 270){
								gizmoInfo.put("orientation", eElement1.getAttribute("orientation"));
							}
							else{
								throw new Error("Invalid orientation for Triangle Takoz");
							}

						}

						gizmoList.add(gizmoInfo);
					}
				}

				tempNodeList = doc.getElementsByTagName("firildak");
				for (int temp2= 0; temp2 < tempNodeList.getLength(); temp2++) {
					tempNode = tempNodeList.item(temp2);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement2 = (Element) tempNode;

						HashMap<String, String> gizmoInfo = new HashMap<String, String>();

						if(!eElement2.getAttribute("x").equals("")){

							gizmoInfo.put("type", "Firildak");
							String firildakX = eElement2.getAttribute("x");
							int  firildakIntX = Integer.parseInt(firildakX);
							String firildakY = eElement2.getAttribute("y");
							int  firildakIntY = Integer.parseInt(firildakY);
							String firildakAngle = eElement2.getAttribute("angle");
							int  firildakIntAngle = Integer.parseInt(firildakAngle);

							if(firildakIntX > 0 && firildakIntX < 380 && firildakIntY > 0 && firildakIntY < 380){
								gizmoInfo.put("x", eElement2.getAttribute("x"));
								gizmoInfo.put("y", eElement2.getAttribute("y"));
							}
							else{
								throw new Error ("Invalid location for Firildak");
							}
							if(firildakIntAngle >= 0 && firildakIntAngle < 359){	
								gizmoInfo.put("angle", eElement2.getAttribute("angle"));
							}
							else{
								throw new Error ("Invalid angle for Firildak");
							}
						}
						gizmoList.add(gizmoInfo);
					}
				}

				tempNodeList = doc.getElementsByTagName("leftTokat");
				for (int temp3= 0; temp3 < tempNodeList.getLength(); temp3++) {
					tempNode = tempNodeList.item(temp3);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement3 = (Element) tempNode;

						HashMap<String, String> gizmoInfo = new HashMap<String, String>();

						if(!eElement3.getAttribute("x").equals("")){

							gizmoInfo.put("type", "leftTokat");
							String leftTokatX = eElement3.getAttribute("x");
							int  leftTokatIntX = Integer.parseInt(leftTokatX);
							String leftTokatY = eElement3.getAttribute("y");
							int  leftTokatIntY = Integer.parseInt(leftTokatY);
							String leftTokatOrientation = eElement3.getAttribute("orientation");
							int  leftTokatIntOrientation = Integer.parseInt(leftTokatOrientation);

							if(leftTokatIntX > 0 && leftTokatIntX < 380 && leftTokatIntY > 0 && leftTokatIntY < 380){
								gizmoInfo.put("x", eElement3.getAttribute("x"));
								gizmoInfo.put("y", eElement3.getAttribute("y"));
							}
							else{
								throw new Error ("Invalid location for Left Tokat");
							}
							if(leftTokatIntOrientation == 0 || leftTokatIntOrientation == 90 || leftTokatIntOrientation == 180 || leftTokatIntOrientation == 270 ){	
								gizmoInfo.put("orientation", eElement3.getAttribute("orientation"));
							}
							else{
								throw new Error ("Invalid orientation for Left Tokat");
							}
						}
						gizmoList.add(gizmoInfo);
					}
				}

				tempNodeList = doc.getElementsByTagName("rightTokat");
				for (int temp4= 0; temp4 < tempNodeList.getLength(); temp4++) {
					tempNode = tempNodeList.item(temp4);

					if (tempNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement4 = (Element) tempNode;

						HashMap<String, String> gizmoInfo = new HashMap<String, String>();
						if(!eElement4.getAttribute("x").equals("")){

							gizmoInfo.put("type", "leftTokat");
							String rightTokatX = eElement4.getAttribute("x");
							int  rightTokatIntX = Integer.parseInt(rightTokatX);
							String rightTokatY = eElement4.getAttribute("y");
							int  rightTokatIntY = Integer.parseInt(rightTokatY);
							String rightTokatOrientation = eElement4.getAttribute("orientation");
							int  rightTokatIntOrientation = Integer.parseInt(rightTokatOrientation);

							if(rightTokatIntX > 0 && rightTokatIntX < 380 && rightTokatIntY > 0 && rightTokatIntY < 380){
								gizmoInfo.put("x", eElement4.getAttribute("x"));
								gizmoInfo.put("y", eElement4.getAttribute("y"));
							}
							else{
								throw new Error ("Invalid location for Right Tokat");
							}
							if(rightTokatIntOrientation == 0 || rightTokatIntOrientation == 90 || rightTokatIntOrientation == 180 || rightTokatIntOrientation == 270 ){	
								gizmoInfo.put("orientation", eElement4.getAttribute("orientation"));
							}
							else{
								throw new Error ("Invalid orientation for Right Tokat");
							}
						}
						gizmoList.add(gizmoInfo);
					}
				}
			}
			catch(Exception e){
				System.out.println(e.toString());
			}
		}
		else{
			throw new Error ("Number of gizmos must be 8");
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

				Element eElement = (Element) tempNode;	
				keysInfo.put("type", "keys");
				if(tempNode.hasAttributes() == true){
					keysInfo.put("key1left", eElement.getAttribute("key"));
				}
				else{
					throw new Error ("There is no assigned key for Cezmi1");
				}
				keysList.add(keysInfo); 

			}

			tempNodeList = doc.getElementsByTagName("key1right");
			for (int temp1 = 0; temp1 < tempNodeList.getLength(); temp1++) {
				tempNode = tempNodeList.item(temp1);

				Element eElement = (Element) tempNode;

				if(tempNode.hasAttributes() == true){
					keysInfo.put("key1right", eElement.getAttribute("key"));	
				}
				else{
					throw new Error("There is no assigned key for Cezmi1");
				}
				keysList.add(keysInfo);
			}  

			tempNodeList = doc.getElementsByTagName("key2left");
			for (int temp2 = 0; temp2 < tempNodeList.getLength(); temp2++) {
				tempNode = tempNodeList.item(temp2);

				Element eElement = (Element) tempNode;

				if(tempNode.hasAttributes() == true){
					keysInfo.put("key2left", eElement.getAttribute("key"));	
				}
				else{
					throw new Error ("There is no assigned key for Cezmi2");
				}

				keysList.add(keysInfo);
			}

			tempNodeList = doc.getElementsByTagName("key2right");
			for (int temp3 = 0; temp3 < tempNodeList.getLength(); temp3++) {
				tempNode = tempNodeList.item(temp3);

				Element eElement = (Element) tempNode;

				if(tempNode.hasAttributes() == true){
					keysInfo.put("key2right", eElement.getAttribute("key"));	
				}	
				else{
					throw new Error ("There is no assigned key for Cezmi2");
				}

				keysList.add(keysInfo);
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

				Element eElement = (Element) tempNode;

				if(tempNode.hasAttributes() == true){
					if(getLevel() == 1 || getLevel() == 2){
						boardInfo.put("level", eElement.getAttribute("level"));
					}
					else{
						throw new Error("Invalid level");
					}
				}
				else{
					throw new Error ("There is no level");
				}
				boardList.add(boardInfo);  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return boardList;
	}	

}