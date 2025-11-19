package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Producto;
import modelo.Almacen;
import repository.GestionFicheros;
import repository.ProductoDAOImpl;

public class MainApp {

	private static Scanner teclado = new Scanner(System.in);
	private static final ProductoDAOImpl dao = new ProductoDAOImpl();
	private static File directorioTienda = new File("C:\\tienda");
	private static File ficheroStockBajo = new File("C:\\tienda\\stock_bajo.txt");
	private static File ficheroAlmacenes = new File("ficheros\\almacenes.dat.txt");

	
	public static void main(String[] args) {		
		int opcion=0;
		
		
		
		try {
			if(directorioTienda.mkdir()) System.out.println("Directorio creado perfectamente");
			if(ficheroStockBajo.createNewFile()) System.out.println("Directorio creado perfectamente");
		} catch (IOException e) {
			System.err.println("Error al generar el fichero y el directorio: "+e.getMessage());
		}
	
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				insertarNuevoProducto();
				break;
			case 2:
				actualizarStock();
				break;
			case 3:
				eliminarProducto();
				break;
			case 4:
				exportarStockBajo();
				break;
			case 5:
				importarAlmacenesDesdeFichero();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default: 
				System.out.println("Error en la entrada de teclado");
				break;
			}
		} while(opcion != 0);
	}

	private static void insertarNuevoProducto() {
		String nombre;
		Double precio;
		int stock;
		
		System.out.println("Introduce el nombre del producto: ");
		nombre=teclado.next();
		System.out.println("Introduce el precio del producto: ");
		precio=teclado.nextDouble();
		System.out.println("Introduce el stock del producto: ");
		stock=teclado.nextInt();
		
		Producto producto = new Producto(nombre,precio,stock);
		
		if (dao.insertar(producto)) System.out.println("Producto creado correctamente");
		else System.out.println("Error al crear el producto");
	}
	
	private static void actualizarStock() {
		int id_producto;
		int stock;
	
		System.out.println("Introduce el id del producto: ");
		id_producto=teclado.nextInt();
		System.out.println("Introduce el valor del stock que quieres modificar: ");
		stock=teclado.nextInt();
		
		if (dao.actualizar(id_producto, stock)) System.out.println("Stock actualizado con exito");
		else System.out.println("El stock no se ha podido actualizar");
	}
	
	private static void eliminarProducto() {
		int id_producto;
		
		System.out.println("Introduce el id del producto que quieres eliminar: ");
		id_producto=teclado.nextInt();
		
		if (dao.eliminar(id_producto)) System.out.println("Producto eliminado correctamente");
		else System.out.println("Error al eliminar el producto");
	}
	
	private static void exportarStockBajo() {
		List<Producto> productos = new ArrayList<Producto>();
		System.out.println("Buscando los productos con el stock por debajo de 10...");
		
		productos = dao.buscarStockInferior();
		System.out.println("Productos por de bajo del minimo de stock:");
		
		for(Producto p : productos) {
			System.out.println(p.toString());
		}

		
		if(GestionFicheros.exportarStockBajo(ficheroStockBajo, productos)) System.out.println("Exportacion completa, los productos ya estan dentro del fichero");
		else System.out.println("Error al exportar");
	}
	
	private static void importarAlmacenesDesdeFichero() {
		List<Almacen> almacenes =  new ArrayList<Almacen>();
		
		GestionFicheros.leerAlmacenes(ficheroAlmacenes);
		
		
		if (dao.importarAlmacenes(almacenes)) System.out.println("Almacenes insertados correctamente");
		else System.out.println("Error al insertar los almacenes");
	}

	private static int mostrarMenu() {
		System.out.println("1. Insertar un nuevo producto"+
						  "\n2. Actualizar el stock de un producto"+
						  "\n3. Eliminar un producto"+
						  "\n4. Buscar stock por debajo de 10"+
						  "\n5. Exportar productos con stock bajo a fichero"+
			              "\n6. Importar almacenes desde fichero"+
						  "\n0. Salir");
		return teclado.nextInt();
	}

}
