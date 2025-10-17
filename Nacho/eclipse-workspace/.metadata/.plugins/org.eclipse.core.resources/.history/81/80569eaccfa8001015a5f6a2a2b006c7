package xmlSAX;

import java.io.IOException;
import java.nio.file.Path;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Main {

	public static void main(String[] args) {
		Path path = Path.of("ficheros/ms.xml");
		leerXML(path);
	}

	private static void leerXML(Path path) {
		//1. SAXParserFactory  Clase especial, nos permitirá crear nuevos SAX parsers
		SAXParserFactory factory= SAXParserFactory.newInstance();
		
		//2. SAXParser  Creación de un nuevo parser para SAX, utiliza la clase anterior
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			System.err.println("ERROR");
			System.err.println(e.getMessage());
			System.exit(-1);
		}		
		//3. XMLReader  Objeto que permite leer el documento XML elemento a lemento
		XMLReader reader = null; 
		
		try {
			reader = parser.getXMLReader();
		} catch (SAXException e) {
			System.err.println("ERROR");
			System.err.println(e.getMessage());
			System.exit(-2);
		}
		reader.setContentHandler(new MiControladoraXML());
		try {
			reader.parse(path.toString());
		} catch (IOException | SAXException e) {
			System.err.println("ERROR");
			System.err.println(e.getMessage());
			System.exit(-3);
		}
		//4. DefaultHandler  Clase abstracta que debemos implementar, contiene las llamadas a los eventos
		
	}

}
