package xml;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import game.Ball;
import game.Cezerye;
import game.HadiCezmi;
import game.Cezmi;
import game.Gizmo;
import game.Player;
import game.SquareTakoz;
import game.TriangleTakoz;
import game.LeftTokat;
import game.RightTokat;
import game.Firildak;

public class XMLBuilder {
	
	private HadiCezmi hadiCezmi;
	public XMLBuilder(HadiCezmi cezmi){
		this.hadiCezmi = cezmi;
	}
	
	public void writeToXML() throws ParserConfigurationException, TransformerException {
		
	int k = 1;
	
	DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

	Document doc = docBuilder.newDocument();
	Element rootElement = doc.createElement("board");
	doc.appendChild(rootElement); 

	Ball ball = hadiCezmi.getBoard().getBall();
	Element element = doc.createElement("ball");
	rootElement.appendChild(element);
	
	Attr ballAttr = doc.createAttribute("x");
	ballAttr.setValue(Double.toString(ball.getX()));
	element.setAttributeNode(ballAttr);
	
	Attr ballAttr2 = doc.createAttribute("y");
	ballAttr2.setValue(Double.toString(ball.getY()));
	element.setAttributeNode(ballAttr2);
	
	Attr ballAttr3 = doc.createAttribute("xVelocity");
	ballAttr3.setValue(Double.toString(ball.getVx()));
	element.setAttributeNode(ballAttr3);
	
	Attr ballAttr4 = doc.createAttribute("yVelocity");
	ballAttr4.setValue(Double.toString(ball.getVy()));
	element.setAttributeNode(ballAttr4);
	
	//
	
	Cezmi cezmi1 = hadiCezmi.getBoard().getCezmi1();
	Player player1 = hadiCezmi.getPlayer1();
	
	Element element1 = doc.createElement("cezmi1");
	rootElement.appendChild(element1);
	
	Attr cezmi1Attr = doc.createAttribute("x");
	cezmi1Attr.setValue(Double.toString(cezmi1.getX()));
	element1.setAttributeNode(cezmi1Attr);
	
	Attr cezmi1Attr2 = doc.createAttribute("y");
	cezmi1Attr2.setValue(Double.toString(cezmi1.getY()));
	element1.setAttributeNode(cezmi1Attr2);
	
	Attr cezmi1Attr3 = doc.createAttribute("score");
	cezmi1Attr3.setValue(Double.toString(player1.getScore()));
	element1.setAttributeNode(cezmi1Attr3);
	
	//
	
	Cezmi cezmi2 = hadiCezmi.getBoard().getCezmi2();
	Player player2 = hadiCezmi.getPlayer2();

	Element element2 = doc.createElement("cezmi2");
	rootElement.appendChild(element2);
	
	Attr cezmi2Attr = doc.createAttribute("x");
	cezmi2Attr.setValue(Double.toString(cezmi2.getX()));
	element2.setAttributeNode(cezmi2Attr);
	
	Attr cezmi2Attr2 = doc.createAttribute("y");
	cezmi2Attr2.setValue(Double.toString(cezmi2.getY()));
	element2.setAttributeNode(cezmi2Attr2);
	
	Attr cezmi2Attr3 = doc.createAttribute("score");
	cezmi2Attr3.setValue(Double.toString(player2.getScore()));
	element2.setAttributeNode(cezmi2Attr3);
	
	//

	Element cezeryes = doc.createElement("cezeryes");
	rootElement.appendChild(cezeryes);
	
	for(int j=0; j<hadiCezmi.getBoard().getGizmoArrayList().size(); j++){
		Gizmo g2 = hadiCezmi.getBoard().getGizmoArrayList().get(j);
		if (g2 instanceof Cezerye){

		Element element3 = doc.createElement("cezerye");
		cezeryes.appendChild(element3);
		
		Attr cezeryeAttr = doc.createAttribute("x");
		cezeryeAttr.setValue(Double.toString(g2.getX()));
		element3.setAttributeNode(cezeryeAttr);
		
		Attr cezeryeAttr2 = doc.createAttribute("y");
		cezeryeAttr2.setValue(Double.toString(g2.getY()));
		element3.setAttributeNode(cezeryeAttr2);
		
		Attr cezeryeAttr3 = doc.createAttribute("time");
		cezeryeAttr3.setValue(Double.toString(g2.getTime()));
		element3.setAttributeNode(cezeryeAttr3);
	
		}
	}	
	//	
	
	Element gizmos = doc.createElement("gizmos");
	rootElement.appendChild(gizmos);
	
	for(int i=0; i<hadiCezmi.getBoard().getGizmoArrayList().size(); i++){
		Gizmo g = hadiCezmi.getBoard().getGizmoArrayList().get(i);
		
		if (g instanceof Firildak){
			Element element6 = doc.createElement("firildak");
			gizmos.appendChild(element6);
			
			Attr firildakAttr = doc.createAttribute("x");
			firildakAttr.setValue(Integer.toString(g.getX()));
			element6.setAttributeNode(firildakAttr);
			
			Attr firildakAttr2 = doc.createAttribute("y");
			firildakAttr2.setValue(Integer.toString(g.getY()));
			element6.setAttributeNode(firildakAttr2);
			
			Attr firildakAttr3 = doc.createAttribute("angle");
			firildakAttr3.setValue(Double.toString(g.getAngle()));
			element6.setAttributeNode(firildakAttr3);

			}
		
		else if (g instanceof SquareTakoz){

		Element element4 = doc.createElement("squareTakoz");
		gizmos.appendChild(element4);
		
		Attr squareTakozAttr = doc.createAttribute( "x");
		squareTakozAttr.setValue(Integer.toString(g.getX()));
		element4.setAttributeNode(squareTakozAttr);
		
		Attr squareTakozAttr2 = doc.createAttribute("y");
		squareTakozAttr2.setValue(Integer.toString(g.getY()));
		element4.setAttributeNode(squareTakozAttr2);
		
		}
		
		//
		
		else if (g instanceof TriangleTakoz){
		Element element5 = doc.createElement("triangleTakoz");
		gizmos.appendChild(element5);
		
		Attr triangleTakozAttr = doc.createAttribute("x");
		triangleTakozAttr.setValue(Integer.toString(g.getX()));
		element5.setAttributeNode(triangleTakozAttr);
		
		Attr triangleTakozAttr2 = doc.createAttribute("y");
		triangleTakozAttr2.setValue(Integer.toString(g.getY()));
		element5.setAttributeNode(triangleTakozAttr2);
		
		Attr triangleTakozAttr3 = doc.createAttribute("orientation");
		triangleTakozAttr3.setValue(Integer.toString(g.getOrientation()));
		element5.setAttributeNode(triangleTakozAttr3);
		
		}
		
		//
		
		else if (g instanceof LeftTokat){
		
		Element element7 = doc.createElement("leftTokat");
		gizmos.appendChild(element7);
		
		Attr leftTokatAttr = doc.createAttribute("x");
		leftTokatAttr.setValue(Integer.toString(g.getX()));
		element7.setAttributeNode(leftTokatAttr);
		
		Attr leftTokatAttr2 = doc.createAttribute("y");
		leftTokatAttr2.setValue(Integer.toString(g.getY()));
		element7.setAttributeNode(leftTokatAttr2);
		
		Attr leftTokatAttr3 = doc.createAttribute("orientation");
		leftTokatAttr3.setValue(Integer.toString(g.getOrientation()));
		element7.setAttributeNode(leftTokatAttr3);
		
		}
		
		//
		
		else if (g instanceof RightTokat){
		
		Element element8 = doc.createElement("rightTokat");
		gizmos.appendChild(element8);
		
		Attr rightTokatAttr = doc.createAttribute("x");
		rightTokatAttr.setValue(Integer.toString(g.getX()));
		element8.setAttributeNode(rightTokatAttr);
		
		Attr rightTokatAttr2 = doc.createAttribute("y");
		rightTokatAttr2.setValue(Integer.toString(g.getY()));
		element8.setAttributeNode(rightTokatAttr2);
		
		Attr rightTokatAttr3 = doc.createAttribute("orientation");
		rightTokatAttr3.setValue(Integer.toString(g.getOrientation()));
		element8.setAttributeNode(rightTokatAttr3);
		
		}
		
	}
	
	//
	
	Element keys = doc.createElement("keys");
	rootElement.appendChild(keys);
	
	Element element9 = doc.createElement("key1left");
	keys.appendChild(element9);
	
	Attr key1LeftAttr = doc.createAttribute("key");
	key1LeftAttr.setValue(Double.toString(hadiCezmi.getCezmi1Left()));
	element9.setAttributeNode(key1LeftAttr);
	
	Element element10 = doc.createElement("key1right");
	keys.appendChild(element10);
	
	Attr key1RighttAttr = doc.createAttribute("key");
	key1RighttAttr.setValue(Double.toString(hadiCezmi.getCezmi1Right()));
	element10.setAttributeNode(key1RighttAttr);
	
	Element element11 = doc.createElement("key2left");
	keys.appendChild(element11);
	
	Attr key2LeftAttr = doc.createAttribute("key");
	key2LeftAttr.setValue(Double.toString(hadiCezmi.getCezmi2Left()));
	element11.setAttributeNode(key2LeftAttr);
	
	Element element12 = doc.createElement("key2right");
	keys.appendChild(element12);
	
	Attr key2RightAttr = doc.createAttribute("key");
	key2RightAttr.setValue(Double.toString(hadiCezmi.getCezmi2Right()));
	element12.setAttributeNode(key2RightAttr);
	
	//
	
	Attr friction1Attr = doc.createAttribute("friction1");
	friction1Attr.setValue(Double.toString(hadiCezmi.getBoard().getFriction()));
	rootElement.setAttributeNode(friction1Attr);
	
	Attr friction2Attr = doc.createAttribute("friction2");
	friction2Attr.setValue(Double.toString(hadiCezmi.getBoard().getFriction()));
	rootElement.setAttributeNode(friction2Attr);
	
	Attr gravityAttr = doc.createAttribute("gravity");
	gravityAttr.setValue(Double.toString(hadiCezmi.getBoard().getGravity()));
	rootElement.setAttributeNode(gravityAttr);
	
	Attr levelAttr = doc.createAttribute("level");
	levelAttr.setValue(Integer.toString(hadiCezmi.getBoard().getLevel()));
	rootElement.setAttributeNode(levelAttr);
	
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File("HadiCezmi"+k+".xml"));
	transformer.transform(source, result);
	k++;
	}
}
