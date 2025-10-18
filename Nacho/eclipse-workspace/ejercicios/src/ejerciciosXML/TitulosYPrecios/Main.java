package ejerciciosXML.TitulosYPrecios;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.*;

import java.io.File;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		try {
            File xmlFile = new File("biblio.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList listaLibros = doc.getElementsByTagName("book");

            //Lista para guardar pares titulo y precios 
            List<Map.Entry<String, Double>> libros = new ArrayList<>();

            for (int i = 0; i < listaLibros.getLength(); i++) {
                Element libro = (Element) listaLibros.item(i);
                String titulo = libro.getElementsByTagName("title").item(0).getTextContent();
                double precio = Double.parseDouble(libro.getElementsByTagName("price").item(0).getTextContent());
                libros.add(Map.entry(titulo, precio));
            }

            //Ordenar por precio ascendente
            libros.sort(Map.Entry.comparingByValue());
            System.out.println("Títulos y precios: ");

            for (Map.Entry<String, Double> entry : libros) {
                System.out.println(entry.getKey() + " → " + entry.getValue() + " €");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

	}

}
