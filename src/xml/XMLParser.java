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
			DocumentBuilderFactory dbFactory 
			= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(CezmiFile);
			doc.getDocumentElement().normalize();

		}catch(Exception e){
			System.out.println(e.toString());
		} 

	}

	public ArrayList<HashMap<String, String>> createBallFromXml(){ 
		ArrayList<HashMap<String, String>> ballList = new ArrayList<>();
		HashMap<String, String> ballInfo = new HashMap<String, String>();
		
		try {
			System.out.println("deneme");
			NodeList nList = doc.getElementsByTagName("ball");
			System.out.println(nList.getLength());
			for (int temp = 0; temp < nList.getLength(); temp++) {
				System.out.println("deneme2");
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					ballInfo.put("type", "ball");
					ballInfo.put("x", eElement.getAttribute("x"));
					ballInfo.put("y", eElement.getAttribute("y"));
					ballInfo.put("vx", eElement.getAttribute("xVelocity"));
					ballInfo.put("vy", eElement.getAttribute("yVelocity"));

					System.out.println("deneme3");
					ballList.add(ballInfo);
				}

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return ballList;
	}

	public ArrayList<HashMap<String, String>> crateCezmi1FromXml() {
		ArrayList<HashMap<String, String>> cezmiList = new ArrayList<>();
		HashMap<String, String> cezmiInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("cezmi1");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					cezmiInfo.put("type", "Cezmi");
					cezmiInfo.put("x", eElement.getAttribute("x"));
					cezmiInfo.put("y", eElement.getAttribute("y"));
					cezmiInfo.put("score", eElement.getAttribute("score"));
					cezmiInfo.put("name", eElement.getAttribute("name"));
					cezmiInfo.put("leftKey", eElement.getAttribute("leftKey"));
					cezmiInfo.put("rightKey", eElement.getAttribute("rightKey"));

					cezmiList.add(cezmiInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList;
	}

	public ArrayList<HashMap<String, String>> crateCezmi2FromXml() {
		ArrayList<HashMap<String, String>> cezmiList = new ArrayList<>();
		HashMap<String, String> cezmiInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("cezmi2");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					cezmiInfo.put("type", "Cezmi");
					cezmiInfo.put("x", eElement.getAttribute("x"));
					cezmiInfo.put("y", eElement.getAttribute("y"));
					cezmiInfo.put("score", eElement.getAttribute("score"));
					cezmiInfo.put("name", eElement.getAttribute("name"));
					cezmiInfo.put("leftKey", eElement.getAttribute("leftKey"));
					cezmiInfo.put("rightKey", eElement.getAttribute("rightKey"));

					cezmiList.add(cezmiInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return cezmiList;
	}

	public ArrayList<HashMap<String, String>> crateLevelFromXml() {
		ArrayList<HashMap<String, String>> levelList = new ArrayList<>();
		HashMap<String, String> levelInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("level");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					levelInfo.put("type", "level");
					levelInfo.put("level", eElement.getAttribute("level"));


					levelList.add(levelInfo);
				}  

			}

		}catch(Exception e){
			System.out.println(e.toString());
		} 
		return levelList;
	}  

	public ArrayList<HashMap<String, String>> crateGizmoFromXml() {
		ArrayList<HashMap<String, String>> gizmoList = new ArrayList<>();
		HashMap<String, String> gizmoInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("squareTakoz");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					gizmoInfo.put("type", "gizmo");
					gizmoInfo.put("x", eElement.getAttribute("x"));
					gizmoInfo.put("y", eElement.getAttribute("y"));

					gizmoList.add(gizmoInfo);
					}
			}

				NodeList nList1 = doc.getElementsByTagName("triangleTakoz");
				for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
					Node nNode1 = nList1.item(temp1);

					if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement1 = (Element) nNode1;
						gizmoInfo.put("type", "gizmo");
						gizmoInfo.put("x", eElement1.getAttribute("x"));
						gizmoInfo.put("y", eElement1.getAttribute("y"));
						gizmoInfo.put("orientation", eElement1.getAttribute("orientation"));

						gizmoList.add(gizmoInfo);
						}
				}
					NodeList nList2 = doc.getElementsByTagName("triangleTakoz");
					for (int temp2= 0; temp2 < nList2.getLength(); temp2++) {
						Node nNode2 = nList2.item(temp2);

						if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement2 = (Element) nNode2;
							gizmoInfo.put("type", "gizmo");
							gizmoInfo.put("x", eElement2.getAttribute("x"));
							gizmoInfo.put("y", eElement2.getAttribute("y"));

							gizmoList.add(gizmoInfo);
							}	
					}

						NodeList nList3 = doc.getElementsByTagName("firildak");
						for (int temp3= 0; temp3 < nList3.getLength(); temp3++) {
							Node nNode3 = nList3.item(temp3);

							if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

								Element eElement3 = (Element) nNode3;
								gizmoInfo.put("type", "gizmo");
								gizmoInfo.put("x", eElement3.getAttribute("x"));
								gizmoInfo.put("y", eElement3.getAttribute("y"));
								gizmoInfo.put("angle", eElement3.getAttribute("angle"));

								gizmoList.add(gizmoInfo);
								}
						}

							NodeList nList4 = doc.getElementsByTagName("leftTokat");
							for (int temp4= 0; temp4 < nList4.getLength(); temp4++) {
								Node nNode4 = nList4.item(temp4);

								if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

									Element eElement4 = (Element) nNode4;
									gizmoInfo.put("type", "gizmo");
									gizmoInfo.put("x", eElement4.getAttribute("x"));
									gizmoInfo.put("y", eElement4.getAttribute("y"));
									gizmoInfo.put("orientation", eElement4.getAttribute("orientation"));

									gizmoList.add(gizmoInfo);
									}
							}

								NodeList nList5 = doc.getElementsByTagName("rightTokat");
								for (int temp5= 0; temp5 < nList5.getLength(); temp5++) {
									Node nNode5 = nList5.item(temp5);

									if (nNode5.getNodeType() == Node.ELEMENT_NODE) {

										Element eElement5 = (Element) nNode5;
										gizmoInfo.put("type", "gizmo");
										gizmoInfo.put("x", eElement5.getAttribute("x"));
										gizmoInfo.put("y", eElement5.getAttribute("y"));
										gizmoInfo.put("orientation", eElement5.getAttribute("orientation"));

										gizmoList.add(gizmoInfo);
										}
								} 
					

							

						}catch(Exception e){
							System.out.println(e.toString());
						} 
						return gizmoList;
					}


				}


