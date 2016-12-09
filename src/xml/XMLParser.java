package xml;


import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


import game.Ball;
import game.Takoz;
import game.SquareTakoz;
import game.TriangleTakoz;
import game.Tokat;
import game.Firildak;
import game.Cezerye;


import game.LeftTokat;
import game.RightTokat;
import game.Cezmi;

public class XMLParser {
	Ball CezmiBall = new Ball();
	
	ArrayList<SquareTakoz> CezmiSquareTakoz = new ArrayList<SquareTakoz>();
	ArrayList<TriangleTakoz> CezmiTriangleTakoz = new ArrayList<TriangleTakoz>();
	ArrayList<Tokat> CezmiTokat = new ArrayList<Tokat>();
	ArrayList<Firildak> CezmiFirildak = new ArrayList<Firildak>();
	ArrayList<Cezerye> CezmiCezerye = new ArrayList<Cezerye>();
	ArrayList<LeftTokat> CezmiLeftTokat = new ArrayList<LeftTokat>();
	ArrayList<RightTokat> CezmiRightTokat = new ArrayList<RightTokat>();
	
	Cezmi HadiCezmi1 = new Cezmi();
	Cezmi HadiCezmi2 = new Cezmi();
	File CezmiFile;
	Boolean validity = true; 
	
   public XMLParser(File CezmiCezmiFile){
	   this.CezmiFile = CezmiCezmiFile;
	   CezmiBall = new Ball();
	   CezmiSquareTakoz = new ArrayList<SquareTakoz>();
	   CezmiTriangleTakoz = new ArrayList<TriangleTakoz>();
	   CezmiTokat = new ArrayList<Tokat>();
	   CezmiFirildak = new ArrayList<Firildak>();
	   CezmiCezerye = new ArrayList<Cezerye>();
	   CezmiLeftTokat = new ArrayList<LeftTokat>();
	   CezmiRightTokat = new ArrayList<RightTokat>();
	   
	   validity = true;
	   
      try {	
         File inputFile = CezmiCezmiFile;
         DocumentBuilderFactory dbFactory 
            = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(inputFile);
         doc.getDocumentElement().normalize();
         
         NodeList nList = doc.getElementsByTagName("ball");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               
               CezmiBall.setVx(Double.parseDouble(eElement.getAttribute("xVelocity")));
               CezmiBall.setVy(Double.parseDouble(eElement.getAttribute("yVelocity")));
               
               if(eElement.getAttribute("x")!=""){
            	   CezmiBall.setX(Double.parseDouble(eElement.getAttribute("x")));
            	   }
               if(eElement.getAttribute("y")!=""){
            	   CezmiBall.setY(Double.parseDouble(eElement.getAttribute("y")));
            	   }
            }
         }
         
         NodeList nList1 = doc.getElementsByTagName("cezmi1");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList1.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;   
               
               HadiCezmi1.setScore(Integer.parseInt(eElement.getAttribute("score")));   
            
               if(eElement.getAttribute("x")!=""){   
            	   HadiCezmi1.setX(Double.parseDouble(eElement.getAttribute("x")));
            }  
               
            }
         }
         
         NodeList nList2 = doc.getElementsByTagName("cezmi2");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList2.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;   
               
               HadiCezmi2.setScore(Integer.parseInt(eElement.getAttribute("score")));   
            
               if(eElement.getAttribute("x")!=""){   
            	   HadiCezmi2.setX(Double.parseDouble(eElement.getAttribute("x")));
            }  
               
            }
         }
         
         NodeList nList3 = doc.getElementsByTagName("key1");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList2.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;   
              
               key1.setKey(Integer.parseInt(eElement.getAttribute("key")));  
               
            }  
               
            }
         
         
         NodeList nList4 = doc.getElementsByTagName("key2");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList2.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;   
              
               key2.setKey(Integer.parseInt(eElement.getAttribute("key")));  
               
            }  
               
            }
         
         NodeList nList5 = doc.getElementsByTagName("squareTakoz");

         for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList5.item(temp);
            
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;   
              
               SquareTakoz.setKey(Integer.parseInt(eElement.getAttribute("key")));  
               
            }  
               
            }


         
         NodeList nList5 = doc.getElementsByTagName("takoz");

         for (int temp = 0; temp < nList2.getLength(); temp++) {
            Node nNode = nList5.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               Takoz takoz = new Takoz(Integer.parseInt(eElement.getAttribute("x")),Integer.parseInt(eElement.getAttribute("y")));
               if(checkPosition(takoz)){
            	   CezmiTakoz.add(takoz);
               } else{
            	   validity = false;
               }
               
            }
         }
         
         
         
         NodeList nList4 = doc.getElementsByTagName("tokat");

         for (int temp = 0; temp < nList4.getLength(); temp++) {
            Node nNode = nList4.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
               Element eElement = (Element) nNode;
               Tokat tokat = new Tokat(Integer.parseInt(eElement.getAttribute("x")),Integer.parseInt(eElement.getAttribute("y")));
               if(checkPosition(tokat)){
            	   CezmiTokat.add(tokat);
               } else{
            	   validity = false;
               }
               
            }
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   
   //Checking invalid gizmo positions
//private boolean checkPosition(Takoz takoz) {
	// TODO Auto-generated method stub
	//if(takoz.x < 0 || takoz.y <0 || takoz.x > 20 || takoz.y > 20 ) return false;
	//for(int i=0; i<CezmiTakoz.size(); i++){
		//Takoz temp = CezmiTakoz.get(i);
		//if(temp.x == takoz.x && temp.y == takoz.y){
			//return false;
		//}
	//}
	//return true;
//}


//private boolean checkPosition(Tokat tokat) {
	// TODO Auto-generated method stub
	//if(tokat.x < 0 || tokat.y <0 || tokat.x > 20 || tokat.y > 20 ) return false;
	//for(int i=0; i<CezmiTokat.size(); i++){
		//Takoz temp = CezmiTokat.get(i);
		//if(temp.x == tokat.x && temp.y == tokat.y){
			//return false;
		//}
	//}
	//return true;
//}


public Ball getBall() {
	return CezmiBall;
}

public void setBall(Ball CezmiBall) {
	this.CezmiBall = CezmiBall;
}


public ArrayList<Takoz> getCezmiTakoz() {
	return CezmiTakoz;
}

public void setCezmiTakoz(ArrayList<Takoz> CezmiTakoz) {
	this.CezmiTakoz = CezmiTakoz;
}

public File getXMLFile() {
	return CezmiFile;
}

public void setFile(File CezmiFile) {
	this.CezmiFile = CezmiFile;
}

public Boolean getValidity() {
	return validity;
}

public void setValidity(Boolean validity) {
	this.validity = validity;
}
}


