package repository;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

import modelo.Producto;
import repository.ProductoDAO;
import repository.ProductoDAOImpl;


public class ProductoHandler extends DefaultHandler {

    private StringBuilder contenido = new StringBuilder();
    private String nombre;
    private double precio;
    private int stock;

    private ProductoDAO dao = new ProductoDAOImpl();
    private List<Producto> listaProductos;

    public ProductoHandler(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        contenido.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        contenido.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        switch (qName.toLowerCase()) {
            case "nombre" -> nombre = contenido.toString().trim();
            case "precio" -> precio = Double.parseDouble(contenido.toString().trim());
            case "stock"  -> stock = Integer.parseInt(contenido.toString().trim());

            case "producto" -> {
                Producto pd = new Producto(nombre, precio, stock);

                // añadir a lista
                listaProductos.add(pd);

                // insertar en BD
                dao.insertar(pd);

                System.out.println("Producto insertado desde SAX: " + nombre);
            }
        }
    }
}
