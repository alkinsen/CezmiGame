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

	public ArrayList<HashMap<String, String>> createBallFromXml(){ 
		ArrayList<HashMap<String, String>> ballList = new ArrayList<>();
		HashMap<String, String> ballInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("ball");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					ballInfo.put("type", "ball");

					if(eElement.getAttribute("x") != ""){
						ballInfo.put("x", eElement.getAttribute("x"));
					}

					if(eElement.getAttribute("y") != ""){
						ballInfo.put("y", eElement.getAttribute("y"));
					}

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

		try {
			NodeList nList = doc.getElementsByTagName("cezmi1");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					cezmiInfo.put("type", "Cezmi");

					if(eElement.getAttribute("x") != ""){
						cezmiInfo.put("x", eElement.getAttribute("x"));
					}

					if(eElement.getAttribute("y") != ""){
						cezmiInfo.put("y", eElement.getAttribute("y"));
					}				

					cezmiInfo.put("score", eElement.getAttribute("score"));

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

		try {
			NodeList nList = doc.getElementsByTagName("cezmi2");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					cezmiInfo.put("type", "Cezmi");

					if(eElement.getAttribute("x") != ""){
						cezmiInfo.put("x", eElement.getAttribute("x"));
					}

					if(eElement.getAttribute("y") != ""){
						cezmiInfo.put("y", eElement.getAttribute("y"));
					}				

					cezmiInfo.put("score", eElement.getAttribute("score"));

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
		HashMap<String, String> cezeryeInfo = new HashMap<String, String>();

		try {
			NodeList nList = doc.getElementsByTagName("cezerye");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					cezeryeInfo.put("type", "cezerye");

					if(eElement.getAttribute("x") != ""){
						cezeryeInfo.put("x", eElement.getAttribute("x"));	
					}	

					if(eElement.getAttribute("y") != ""){
						cezeryeInfo.put("y", eElement.getAttribute("y"));
					}	

					if(eElement.getAttribute("time") != ""){
						cezeryeInfo.put("time", eElement.getAttribute("time"));
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


		try {
			NodeList nList = doc.getElementsByTagName("squareTakoz");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

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

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "gizmo");
					gizmoInfo.put("x", eElement1.getAttribute("x"));
					gizmoInfo.put("y", eElement1.getAttribute("y"));
					gizmoInfo.put("orientation", eElement1.getAttribute("orientation"));

					gizmoList.add(gizmoInfo);
				}
			}

			NodeList nList2 = doc.getElementsByTagName("firildak");
			for (int temp2= 0; temp2 < nList2.getLength(); temp2++) {
				Node nNode2 = nList2.item(temp2);

				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement2 = (Element) nNode2;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "gizmo");
					gizmoInfo.put("x", eElement2.getAttribute("x"));
					gizmoInfo.put("y", eElement2.getAttribute("y"));
					gizmoInfo.put("angle", eElement2.getAttribute("angle"));

					gizmoList.add(gizmoInfo);
				}
			}

			NodeList nList3 = doc.getElementsByTagName("leftTokat");
			for (int temp3= 0; temp3 < nList3.getLength(); temp3++) {
				Node nNode3 = nList3.item(temp3);

				if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement3 = (Element) nNode3;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "gizmo");
					gizmoInfo.put("x", eElement3.getAttribute("x"));
					gizmoInfo.put("y", eElement3.getAttribute("y"));
					gizmoInfo.put("orientation", eElement3.getAttribute("orientation"));

					gizmoList.add(gizmoInfo);
				}
			}

			NodeList nList4 = doc.getElementsByTagName("rightTokat");
			for (int temp4= 0; temp4 < nList4.getLength(); temp4++) {
				Node nNode4 = nList4.item(temp4);

				if (nNode4.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement4 = (Element) nNode4;

					HashMap<String, String> gizmoInfo = new HashMap<String, String>();

					gizmoInfo.put("type", "gizmo");
					gizmoInfo.put("x", eElement4.getAttribute("x"));
					gizmoInfo.put("y", eElement4.getAttribute("y"));
					gizmoInfo.put("orientation", eElement4.getAttribute("orientation"));

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

		try {
			NodeList nList = doc.getElementsByTagName("key1");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					HashMap<String, String> keysInfo = new HashMap<String, String>();
					
					keysInfo.put("type", "keys");

					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key1", eElement.getAttribute("key"));	
					}
					if(eElement.getAttribute("key2") != ""){
						keysInfo.put("key2", eElement.getAttribute("key2"));	
					}	

					keysList.add(keysInfo);
				}  

			}
			
			NodeList nList1 = doc.getElementsByTagName("key2");
			for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
				Node nNode1 = nList1.item(temp1);

				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode1;
					
					HashMap<String, String> keysInfo = new HashMap<String, String>();
					
					keysInfo.put("type", "keys");
					
					if(eElement.getAttribute("key") != ""){
						keysInfo.put("key1", eElement.getAttribute("key"));	
					}	

					if(eElement.getAttribute("key2") != ""){
						keysInfo.put("key2", eElement.getAttribute("key2"));	
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

		try {
			NodeList nList = doc.getElementsByTagName("board");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					
					HashMap<String, String> boardInfo = new HashMap<String, String>();
					
					boardInfo.put("type", "friction1");
					
					if(eElement.getAttribute("friction1") != ""){
						boardInfo.put("friction1", eElement.getAttribute("friction1"));
					}
					else{
						boardInfo.put("friction1", "0.025");
					}

					boardList.add(boardInfo);
				}  

			}
			
			NodeList nList1 = doc.getElementsByTagName("board");
			for (int temp1 = 0; temp1 < nList1.getLength(); temp1++) {
				Node nNode1 = nList1.item(temp1);

				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode1;
					
					HashMap<String, String> boardInfo = new HashMap<String, String>();
					
					boardInfo.put("type", "friction2");
					
					if(eElement.getAttribute("friction2") != ""){
						boardInfo.put("friction2", eElement.getAttribute("friction2"));
					}
					else{
						boardInfo.put("friction2", "0.025");
					}

					boardList.add(boardInfo);
				}  

			}
			
			NodeList nList2 = doc.getElementsByTagName("board");
			
			for (int temp2 = 0; temp2 < nList2.getLength(); temp2++) {
				Node nNode2 = nList2.item(temp2);
				
				if (nNode2.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode2;
					
					HashMap<String, String> boardInfo = new HashMap<String, String>();
					
					boardInfo.put("type", "gravity");
					
					if(eElement.getAttribute("gravity") != ""){
						boardInfo.put("gravity", eElement.getAttribute("gravity"));
					}
					else{
						boardInfo.put("gravity", "25.0");
					}
					boardList.add(boardInfo);
				}  

			}
			
			NodeList nList3 = doc.getElementsByTagName("board");
			for (int temp3 = 0; temp3 < nList3.getLength(); temp3++) {
				Node nNode3 = nList3.item(temp3);

				if (nNode3.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode3;
					
					HashMap<String, String> boardInfo = new HashMap<String, String>();
					
					boardInfo.put("type", "level");
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



