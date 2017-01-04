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
		Node tempLevel;
		NodeList nodeLevelList;
		int cezmiIntLevel = 1;

		try{
			nodeLevelList = doc.getElementsByTagName("board");
			for (int i = 0; i < nodeLevelList.getLength(); i++) {
				tempLevel = nodeLevelList.item(i);

				if (tempLevel.getNodeType() == Node.ELEMENT_NODE) {

					Element level = (Element) tempLevel;

					String cezmiLevel = level.getAttribute("level");
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
		Node tempBall;
		NodeList nodeBallList;
		try {
			nodeBallList = doc.getElementsByTagName("ball");
			if(nodeBallList.getLength() != 0){

				for (int i = 0; i < nodeBallList.getLength(); i++) {
					tempBall = nodeBallList.item(i);

					HashMap<String, String> ballInfo = new HashMap<String, String>();
					Element ball = (Element) tempBall;

					ballInfo.put("type", "ball");

					String ballX = ball.getAttribute("x");
					double ballDoubleX = Double.parseDouble(ballX);	
					String ballY = ball.getAttribute("y");
					double ballDoubleY = Double.parseDouble(ballY);	 

					if (getLevel() == 1){
						if(nodeBallList.getLength() == 1){
							if(ballDoubleX <= 500 && ballDoubleX >= 0 && ballDoubleY <= 500 && ballDoubleY >= 0 ){
								ballInfo.put("x", ball.getAttribute("x"));
								ballInfo.put("y", ball.getAttribute("y"));
								ballInfo.put("vx", ball.getAttribute("xVelocity"));
								ballInfo.put("vy", ball.getAttribute("yVelocity"));
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
						if(nodeBallList.getLength() == 2){
							if(ballDoubleX < 500 && ballDoubleX > 0 && ballDoubleY < 500 && ballDoubleY > 0){
								ballInfo.put("x", ball.getAttribute("x"));
								ballInfo.put("y", ball.getAttribute("y"));
								ballInfo.put("vx", ball.getAttribute("xVelocity"));
								ballInfo.put("vy", ball.getAttribute("yVelocity"));
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
		Node tempCezmi;
		NodeList nodeCezmiList;

		try {
			nodeCezmiList = doc.getElementsByTagName("cezmi1");
			if(nodeCezmiList.getLength() != 0){
				for (int i = 0; i < nodeCezmiList.getLength(); i++) {
					tempCezmi = nodeCezmiList.item(i);

					Element cezmi1 = (Element) tempCezmi;

					cezmiInfo.put("type", "Cezmi");

					String cezmi1X = cezmi1.getAttribute("x");
					double cezmi1intX = Double.parseDouble(cezmi1X);					
					String cezmi1Y = cezmi1.getAttribute("y");
					double cezmi1intY = Double.parseDouble(cezmi1Y);	
					
					if (getLevel() == 1){
						if (cezmi1intX <= 247 && cezmi1intX >= 0 && cezmi1intY == 500){
							cezmiInfo.put("x", cezmi1.getAttribute("x"));
							cezmiInfo.put("y", cezmi1.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}
					
					else if (getLevel() == 2){
						if ((cezmi1intX <= 247 && cezmi1intX >= 0 && cezmi1intY == 500) || (cezmi1intX == 0 && cezmi1intY >= 0 && cezmi1intY <= 500)){
							cezmiInfo.put("x", cezmi1.getAttribute("x"));
							cezmiInfo.put("y", cezmi1.getAttribute("y"));
	
						}
						else{
							throw new Error("Invalid location for Cezmi1");
						}
					}
					else{
						throw new Error("Invalid level");
					}

					String cezmi1Score = cezmi1.getAttribute("score");
					double cezmi1intScore = Double.parseDouble(cezmi1Score);

					if (cezmi1intScore < 10 && cezmi1intScore >= 0){
						cezmiInfo.put("score", cezmi1.getAttribute("score"));
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
		Node tempCezmi;
		NodeList nodeCezmiList;

		try {
			nodeCezmiList = doc.getElementsByTagName("cezmi2");
			if(nodeCezmiList.getLength() == 1){
				for (int i = 0; i < nodeCezmiList.getLength(); i++) {
					tempCezmi = nodeCezmiList.item(i);

					Element cezmi2 = (Element) tempCezmi;

					cezmiInfo.put("type", "Cezmi");

					String cezmi2X = cezmi2.getAttribute("x");
					double cezmi2DoubleX = Double.parseDouble(cezmi2X);					
					String cezmi2Y = cezmi2.getAttribute("y");
					double cezmi2DoubleY = Double.parseDouble(cezmi2Y);	

					if (getLevel() == 1){
						if (cezmi2DoubleX >= 253 && cezmi2DoubleX <= 500 && cezmi2DoubleY == 500){
							cezmiInfo.put("x", cezmi2.getAttribute("x"));
							cezmiInfo.put("y", cezmi2.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}

					else if (getLevel() == 2){
						if ((cezmi2DoubleX >= 253 && cezmi2DoubleX <= 500 && cezmi2DoubleY == 500) || (cezmi2DoubleX == 500 && cezmi2DoubleY >= 0 && cezmi2DoubleY <= 500)){
							cezmiInfo.put("x", cezmi2.getAttribute("x"));
							cezmiInfo.put("y", cezmi2.getAttribute("y"));
						}
						else{
							throw new Error("Invalid location for Cezmi2");
						}
					}
					else{
						throw new Error("Invalid level");
					}

					String cezmi2Score = cezmi2.getAttribute("score");
					double cezmi2DoubleScore = Double.parseDouble(cezmi2Score);

					if (cezmi2DoubleScore < 10 && cezmi2DoubleScore >= 0){
						cezmiInfo.put("score", cezmi2.getAttribute("score"));
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

		Node tempCezerye;
		NodeList nodeCezeryeList;

		try {
			nodeCezeryeList = doc.getElementsByTagName("cezerye");
			if(nodeCezeryeList.getLength() > 0){

				for (int i = 0; i < nodeCezeryeList.getLength(); i++) {
					tempCezerye = nodeCezeryeList.item(i);

					if (tempCezerye.getNodeType() == Node.ELEMENT_NODE) {

						Element cezerye = (Element) tempCezerye;
						HashMap<String, String> cezeryeInfo = new HashMap<String, String>();

						cezeryeInfo.put("type", "Cezerye");

						String cezeryeX = cezerye.getAttribute("x");
						int  cezeryeIntX = Integer.parseInt(cezeryeX);
						String cezeryeY = cezerye.getAttribute("y");
						int  cezeryeIntY = Integer.parseInt(cezeryeY);
						String cezeryeTime = cezerye.getAttribute("time");
						double cezeryeDoubleTime =  Double.parseDouble(cezeryeTime);	

						if(cezeryeIntX > 0 && cezeryeIntX < 500 && cezeryeIntY > 0 && cezeryeIntY < 380 && cezeryeDoubleTime > 0 && cezeryeDoubleTime <= 5){
							cezeryeInfo.put("x", cezerye.getAttribute("x"));
							cezeryeInfo.put("y", cezerye.getAttribute("y"));
							cezeryeInfo.put("time", cezerye.getAttribute("time"));
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
		Node tempGizmo;
		NodeList nodeGizmoList;
		NodeList nodeSquareTakozList;
		NodeList nodeTriangleTakozList;
		NodeList nodeFirildakList;
		NodeList nodeLeftTokatList;
		NodeList nodeRightTokatList;
	
		int j = 0;
		int k = 0;

		nodeGizmoList = doc.getElementsByTagName("gizmos");
		nodeSquareTakozList = doc.getElementsByTagName("squareTakoz");
		nodeTriangleTakozList = doc.getElementsByTagName("triangleTakoz");
		nodeFirildakList = doc.getElementsByTagName("firildak");
		nodeLeftTokatList = doc.getElementsByTagName("leftTokat");
		nodeRightTokatList = doc.getElementsByTagName("rightTokat");

		if((nodeSquareTakozList.getLength() + nodeTriangleTakozList.getLength() + nodeFirildakList.getLength() + nodeLeftTokatList.getLength() + nodeRightTokatList.getLength()) == 8){
				for (int i = 0; i < nodeGizmoList.getLength(); i++) {
					tempGizmo = nodeGizmoList.item(i);}
				try {
					nodeSquareTakozList = doc.getElementsByTagName("squareTakoz");
					for (int i = 0; i < nodeSquareTakozList.getLength(); i++) {
						tempGizmo = nodeSquareTakozList.item(i);

						if (tempGizmo.getNodeType() == Node.ELEMENT_NODE) {

							Element squareTakoz = (Element) tempGizmo;

							HashMap<String, String> gizmoInfo = new HashMap<String, String>();

							if(!squareTakoz.getAttribute("x").equals("")){

								gizmoInfo.put("type", "SquareTakoz");

								String squareTakozX = squareTakoz.getAttribute("x");
								int  squareTakozIntX = Integer.parseInt(squareTakozX);
								String squareTakozY = squareTakoz.getAttribute("y");
								int  squareTakozIntY = Integer.parseInt(squareTakozY);
								
								if(squareTakozIntX > 0 && squareTakozIntX < 500 && squareTakozIntY > 0 && squareTakozIntY < 380){
									gizmoInfo.put("x", squareTakoz.getAttribute("x"));
									gizmoInfo.put("y", squareTakoz.getAttribute("y"));
								}
								else{
									throw new Error("Invalid location for Square Takoz");
								}
								if(squareTakozIntX >= 0 && squareTakozIntX <250){
									j++;
								}
								else{
									k++;
								}
							}

							gizmoList.add(gizmoInfo);
						}
					}

					nodeTriangleTakozList = doc.getElementsByTagName("triangleTakoz");
					
					for (int i = 0; i < nodeTriangleTakozList.getLength(); i++) {
						tempGizmo = nodeTriangleTakozList.item(i);

						if (tempGizmo.getNodeType() == Node.ELEMENT_NODE) {

							Element triangleTakoz = (Element) tempGizmo;

							HashMap<String, String> gizmoInfo = new HashMap<String, String>();

							if(!triangleTakoz.getAttribute("x").equals("")){
								

								gizmoInfo.put("type", "TriangleTakoz");

								String triangleTakozX = triangleTakoz.getAttribute("x");
								int  triangleTakozIntX = Integer.parseInt(triangleTakozX);
								String triangleTakozY = triangleTakoz.getAttribute("y");
								int  triangleTakozIntY = Integer.parseInt(triangleTakozY);
								//String triangleTakozOrientation = triangleTakoz.getAttribute("orientation");
							    //int triangleTakozIntOrientation = Integer.parseInt(triangleTakozOrientation);

								if(triangleTakozIntX > 0 && triangleTakozIntX < 500 && triangleTakozIntY > 0 && triangleTakozIntY < 380){
									gizmoInfo.put("x", triangleTakoz.getAttribute("x"));
									gizmoInfo.put("y", triangleTakoz.getAttribute("y"));	
								}
								else{
									throw new Error("Invalid location for Triangle Takoz");
								}
								/*if(triangleTakozIntOrientation == 0 || triangleTakozIntOrientation == 90 || triangleTakozIntOrientation == 180 || triangleTakozIntOrientation == 270){
									gizmoInfo.put("orientation", triangleTakoz.getAttribute("orientation"));
								}
								else{
									throw new Error("Invalid orientation for Triangle Takoz");
								}*/
								if(triangleTakozIntX >= 0 && triangleTakozIntX <250){
									j++;
								}
								else{
									k++;
								}
							}

							gizmoList.add(gizmoInfo);
						}
					}

					nodeFirildakList = doc.getElementsByTagName("firildak");
					for (int i= 0; i < nodeFirildakList.getLength(); i++) {
						tempGizmo = nodeFirildakList.item(i);

						if (tempGizmo.getNodeType() == Node.ELEMENT_NODE) {

							Element firildak = (Element) tempGizmo;

							HashMap<String, String> gizmoInfo = new HashMap<String, String>();

							if(!firildak.getAttribute("x").equals("")){

								gizmoInfo.put("type", "Firildak");
								String firildakX = firildak.getAttribute("x");
								int  firildakIntX = Integer.parseInt(firildakX);
								String firildakY = firildak.getAttribute("y");
								int  firildakIntY = Integer.parseInt(firildakY);
								
								String firildakAngle = firildak.getAttribute("angle");
								double  firildakDoubleAngle = Double.parseDouble(firildakAngle);
								int firildakIntAngle = (int) firildakDoubleAngle;

								if(firildakIntX > 0 && firildakIntX <500 && firildakIntY > 0 && firildakIntY < 380){
									gizmoInfo.put("x", firildak.getAttribute("x"));
									gizmoInfo.put("y", firildak.getAttribute("y"));
								}
								else{
									throw new Error ("Invalid location for Firildak");
								}
								if(firildakIntAngle >= 0 && firildakIntAngle < 359){	
									gizmoInfo.put("angle", firildak.getAttribute("angle"));
								}
								else{
									throw new Error ("Invalid angle for Firildak");
								}
								if(firildakIntX >= 0 && firildakIntX <250){
									j++;
								}
								else{
									k++;
								}
							}
							gizmoList.add(gizmoInfo);
						}
					}

					nodeLeftTokatList = doc.getElementsByTagName("leftTokat");
					for (int i= 0; i < nodeLeftTokatList.getLength(); i++) {
						tempGizmo = nodeLeftTokatList.item(i);

						if (tempGizmo.getNodeType() == Node.ELEMENT_NODE) {

							Element leftTokat = (Element) tempGizmo;

							HashMap<String, String> gizmoInfo = new HashMap<String, String>();

							if(!leftTokat.getAttribute("x").equals("")){

								gizmoInfo.put("type", "leftTokat");
								String leftTokatX = leftTokat.getAttribute("x");
								int  leftTokatIntX = Integer.parseInt(leftTokatX);
								String leftTokatY = leftTokat.getAttribute("y");
								int  leftTokatIntY = Integer.parseInt(leftTokatY);
								String leftTokatOrientation = leftTokat.getAttribute("orientation");
								int  leftTokatIntOrientation = Integer.parseInt(leftTokatOrientation);

								if(leftTokatIntX > 0 && leftTokatIntX < 500 && leftTokatIntY > 0 && leftTokatIntY < 380){
									gizmoInfo.put("x", leftTokat.getAttribute("x"));
									gizmoInfo.put("y", leftTokat.getAttribute("y"));
								}
								else{
									throw new Error ("Invalid location for Left Tokat");
								}
								if(leftTokatIntOrientation == 0 || leftTokatIntOrientation == 90 || leftTokatIntOrientation == 180 || leftTokatIntOrientation == 270 ){	
									gizmoInfo.put("orientation", leftTokat.getAttribute("orientation"));
								}
								else{
									throw new Error ("Invalid orientation for Left Tokat");
								}
								if(leftTokatIntX >= 0 && leftTokatIntX <250){
									j++;
								}
								else{
									k++;
								}
							}
							gizmoList.add(gizmoInfo);
						}
					}

					nodeRightTokatList = doc.getElementsByTagName("rightTokat");
					for (int i= 0; i < nodeRightTokatList.getLength(); i++) {
						tempGizmo = nodeRightTokatList.item(i);

						if (tempGizmo.getNodeType() == Node.ELEMENT_NODE) {

							Element rightTokat = (Element) tempGizmo;

							HashMap<String, String> gizmoInfo = new HashMap<String, String>();
							if(!rightTokat.getAttribute("x").equals("")){

								gizmoInfo.put("type", "leftTokat");
								String rightTokatX = rightTokat.getAttribute("x");
								int  rightTokatIntX = Integer.parseInt(rightTokatX);
								String rightTokatY = rightTokat.getAttribute("y");
								int  rightTokatIntY = Integer.parseInt(rightTokatY);
								String rightTokatOrientation = rightTokat.getAttribute("orientation");
								int  rightTokatIntOrientation = Integer.parseInt(rightTokatOrientation);

								if(rightTokatIntX > 0 && rightTokatIntX < 500 && rightTokatIntY > 0 && rightTokatIntY < 380){
									gizmoInfo.put("x", rightTokat.getAttribute("x"));
									gizmoInfo.put("y", rightTokat.getAttribute("y"));
								}
								else{
									throw new Error ("Invalid location for Right Tokat");
								}
								if(rightTokatIntOrientation == 0 || rightTokatIntOrientation == 90 || rightTokatIntOrientation == 180 || rightTokatIntOrientation == 270 ){	
									gizmoInfo.put("orientation", rightTokat.getAttribute("orientation"));
								}
								else{
									throw new Error ("Invalid orientation for Right Tokat");
								}
								if(rightTokatIntX >= 0 && rightTokatIntX <250){
									j++;
								}
								else{
									k++;
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
		if(j == k){
			return gizmoList;
		}
		else{
			throw new Error("Each player must have 4 Gizmos");
		}
	}

	public ArrayList<HashMap<String, String>> createKeysFromXml() {
		ArrayList<HashMap<String, String>> keysList = new ArrayList<>();
		HashMap<String, String> keysInfo = new HashMap<String, String>();
		Node tempKeys;
		NodeList nodeKeysList;

		try {
			nodeKeysList = doc.getElementsByTagName("key1left");
			for (int i = 0; i < nodeKeysList.getLength(); i++) {
				tempKeys = nodeKeysList.item(i);

				Element keys = (Element) tempKeys;	
				keysInfo.put("type", "keys");
				if(tempKeys.hasAttributes() == true){
					keysInfo.put("key1left", keys.getAttribute("key"));
				}
				else{
					throw new Error ("There is no assigned key for Cezmi1");
				}
				keysList.add(keysInfo); 
			}

			nodeKeysList = doc.getElementsByTagName("key1right");
			for (int i = 0; i < nodeKeysList.getLength(); i++) {
				tempKeys = nodeKeysList.item(i);

				Element keys = (Element) tempKeys;
				if(tempKeys.hasAttributes() == true){
					keysInfo.put("key1right", keys.getAttribute("key"));	
				}
				else{
					throw new Error("There is no assigned key for Cezmi1");
				}
				keysList.add(keysInfo);
			}  

			nodeKeysList = doc.getElementsByTagName("key2left");
			for (int i = 0; i < nodeKeysList.getLength(); i++) {
				tempKeys = nodeKeysList.item(i);

				Element keys = (Element) tempKeys;
				if(tempKeys.hasAttributes() == true){
					keysInfo.put("key2left", keys.getAttribute("key"));	
				}
				else{
					throw new Error ("There is no assigned key for Cezmi2");
				}
				keysList.add(keysInfo);
			}

			nodeKeysList = doc.getElementsByTagName("key2right");
			for (int i = 0; i < nodeKeysList.getLength(); i++) {
				tempKeys = nodeKeysList.item(i);

				Element keys = (Element) tempKeys;
				if(tempKeys.hasAttributes() == true){
					keysInfo.put("key2right", keys.getAttribute("key"));	
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
		Node tempBoard;
		NodeList tempNodeList;	

		try {
			tempNodeList = doc.getElementsByTagName("board");	

			for (int i = 0; i < tempNodeList.getLength(); i++) {
				tempBoard = tempNodeList.item(i);

				if (tempBoard.getNodeType() == Node.ELEMENT_NODE) {

					Element friction1 = (Element) tempBoard;

					if(friction1.getAttribute("friction1") != ""){
						boardInfo.put("friction1", friction1.getAttribute("friction1"));
					}
					else{
						boardInfo.put("friction1", "0.025");
					}
					boardList.add(boardInfo);
				}  
			}

			for (int i = 0; i < tempNodeList.getLength(); i++) {
				tempBoard = tempNodeList.item(i);

				if (tempBoard.getNodeType() == Node.ELEMENT_NODE) {

					Element friction2 = (Element) tempBoard;

					if(friction2.getAttribute("friction2") != ""){
						boardInfo.put("friction2", friction2.getAttribute("friction2"));
					}
					else{
						boardInfo.put("friction2", "0.025");
					}

					boardList.add(boardInfo);
				}  
			}

			for (int i = 0; i < tempNodeList.getLength(); i++) {
				tempBoard = tempNodeList.item(i);

				if (tempBoard.getNodeType() == Node.ELEMENT_NODE) {

					Element gravity = (Element) tempBoard;

					if(gravity.getAttribute("gravity") != ""){
						boardInfo.put("gravity", gravity.getAttribute("gravity"));
					}
					else{
						boardInfo.put("gravity", "25.0");
					}
					boardList.add(boardInfo);
				}  
			}

			for (int i = 0; i < tempNodeList.getLength(); i++) {
				tempBoard = tempNodeList.item(i);

				Element level = (Element) tempBoard;

				if(tempBoard.hasAttributes() == true){
					if(getLevel() == 1 || getLevel() == 2){
						boardInfo.put("level", level.getAttribute("level"));
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
