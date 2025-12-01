package main;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.boot.model.source.spi.FetchCharacteristics;

import modelo.Producto;
import modelo.Proveedor;
import modelo.Ubicacion;
import repository.CRUD;


public class Main {

	private static final CRUD REPO = new CRUD();
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {		
		int opcion=0;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				guardarProductoCompleto();
				break;
			case 2:
				obtenerProductosEnRiesgo();
				break;
			case 3:
				asignarNuevoProveedor();
				break;
			case 4:
				eliminarProductoYUbicacion();
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


	private static void guardarProductoCompleto() {
		int id_producto;
		String nombre;
		int stock;
		Double precio;
		Ubicacion ubicacion = null;
		
		System.out.println("Introduce el nombre del producto: ");
		nombre = teclado.next();
		System.out.println("Introduce el stock del producto: ");
		stock = teclado.nextInt();
		System.out.println("Introduce el precio: ");
		precio = teclado.nextDouble();
		System.out.println("Introduce el id de la ubicacion: ");
		ubicacion = REPO.buscarUbicacion(teclado.nextInt());
		Producto producto = new Producto(nombre,stock,precio,ubicacion);
		
		REPO.guardarProductoCompleto(producto);
	}


	private static void obtenerProductosEnRiesgo() {
		int stock_minimo;
		List<Producto> productos = new ArrayList<>();
		
		System.out.println("Introduce el stock minimo: ");
		stock_minimo=teclado.nextInt();
		
		productos = REPO.obtenerProductosEnRiesgo(stock_minimo);
		
		for (Producto producto : productos) {
			System.out.println("Producto: "+producto.getIdProducto()+", con stock: "+producto.getStock()+", llega al stock minimo");
		}
	}


	private static void asignarNuevoProveedor() {
		int id_producto;
		int id_proveedor;
		System.out.print("Dime el ID del producto a cambiar: ");
		id_producto = teclado.nextInt();
		System.out.print("Dime el ID del nuevo proveedor: ");
		id_proveedor = teclado.nextInt();
		
		REPO.asignarNuevoProveedor(id_producto, id_proveedor);	
	}


	private static void eliminarProductoYUbicacion() {
		int id_producto;
		boolean bool = false;
		
		System.out.println("Introduce el id del producto: ");
		id_producto=teclado.nextInt();
		
		bool=REPO.eliminarProductoYUbicacion(id_producto);
		if(bool)System.out.println("Producto eliminado"); 
		else System.out.println("Producto no eliminado");
	}

	private static int mostrarMenu() {
		System.out.println("1. Crear nuevo producto completo"+
						  "\n2. Consultar productos en riesgo"+
						  "\n3. Asignar nuevo proveedor"+
						  "\n4. Eliminar un producto y su ubicacion"+
						  "\n5. Obtener Reporte Proveedores"+
						  "\n6. Obtener Productos por pasillo"+
						  "\n7. Crear categoría y asignar producto"+
						  "\n8. Ver productos por categoria"+
						  "\n9. Ver categorías vacías"+
						  "\n4. Eliminar un producto y su ubicacion"+
						  "\n0. Salir");
		return teclado.nextInt();
	}
	
	
}
