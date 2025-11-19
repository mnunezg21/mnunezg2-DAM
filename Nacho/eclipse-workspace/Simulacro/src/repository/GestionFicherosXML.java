package repository;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import modelo.Almacen;
import modelo.Producto;

public class GestionFicherosXML {
	
	 public static List<Almacen> importarAlmacenesDOM(File ficheroXML) {

		 List<Almacen> lista = new ArrayList<>();

	     try {
	    	 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();	            DocumentBuilder builder = factory.newDocumentBuilder();
          	 Document doc = builder.parse(ficheroXML);

	         NodeList nodosAlmacen = doc.getElementsByTagName("almacen");

	         for (int i = 0; i < nodosAlmacen.getLength(); i++) {
	             Element e = (Element) nodosAlmacen.item(i);

	             String codigo = e.getElementsByTagName("codigo").item(0).getTextContent();
	             String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();                
	             String ciudad = e.getElementsByTagName("ciudad").item(0).getTextContent();
	             int capacidad = Integer.parseInt(e.getElementsByTagName("capacidad").item(0).getTextContent());

	             lista.add(new Almacen(codigo, nombre, ciudad, capacidad));
	         }

	         System.out.println("XML leído correctamente (DOM)");
	      } catch (Exception e) {
	          System.err.println("Error leyendo XML DOM: " + e.getMessage());
	      }
	        return lista;
	  }
	 
	 public static void exportarProductosCarosDOM(File ficheroXML, List<Producto> productosCaros) {
		 try {
	            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.newDocument();

	            Element root = doc.createElement("productos_caros");
	            doc.appendChild(root);

	            for (Producto p : productosCaros) {

	                Element producto = doc.createElement("producto");

	                Element id = doc.createElement("id");
	                id.setTextContent(String.valueOf(p.getId_producto()));
	                producto.appendChild(id);

	                Element nombre = doc.createElement("nombre");
	                nombre.setTextContent(p.getNombre());
	                producto.appendChild(nombre);

	                Element precio = doc.createElement("precio");
	                precio.setTextContent(String.valueOf(p.getPrecio()));
	                producto.appendChild(precio);

	                Element stock = doc.createElement("stock");
	                stock.setTextContent(String.valueOf(p.getPrecio()));
	                producto.appendChild(stock);
	                
	                root.appendChild(producto);
	            }

	            Transformer transformer = TransformerFactory.newInstance().newTransformer();
	            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

	            DOMSource source = new DOMSource(doc);
	            StreamResult result = new StreamResult(ficheroXML);
	            transformer.transform(source, result);

	            System.out.println("XML generado correctamente: " + ficheroXML.getAbsolutePath());

	        } catch (Exception e) {
	            System.err.println("Error generando XML DOM: " + e.getMessage());
	        }
	 }
	 
}
