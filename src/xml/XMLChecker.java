package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class XMLChecker {
	private File xmlFile;
	public XMLChecker(File file){
		this.xmlFile = file;
	}
	
	public boolean check() throws SAXException, IOException{
		File schemaFile = new File("cezmi.xsd");
		Source xmlFile = new StreamSource(this.xmlFile);
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(schemaFile);
		Validator validator = schema.newValidator();
		try {
			validator.validate(xmlFile);
			return true;
		} catch (SAXException e) {
			System.out.println("Reason: " + e.getLocalizedMessage());
			return false;
		}
	}
}
