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
		
		boolean bool=false;
		boolean cambioRealizado;
		
		System.out.println("Introduce el id del cliente: ");
		id_cliente = teclado.nextInt();
		System.out.println("Introduciendo la fecha de realizacion del pedido... ");
		fecha_pedido = java.time.LocalDate.now().toString();
		System.out.println("Introduce el total: ");
		total = teclado.nextFloat();
		do {
			System.out.println("Introduce el estado(PENDIENTE, ENVIADO, ENTREGADO o CANCELADO): ");
			estado = teclado.nextLine();
			if(estado.equalsIgnoreCase("PENDIENTE") || 
			   estado.equalsIgnoreCase("ENVIADO")   || 
			   estado.equalsIgnoreCase("ENTREGADO") || 
			   estado.equalsIgnoreCase("CANCELADO")) {
				
				Pedido pedido =  new Pedido(id_cliente,fecha_pedido,total,estado);
				
				cambioRealizado = ventasDao.insertarPedido(id_cliente,pedido);
				if (cambioRealizado) System.out.println("Pedido insertado");
				else System.out.println("No se pudo insertar el pedido");
				bool=true;
			} else System.out.println("Introduce una de las opciones: ");
		} while(!bool);
	}


	private static void obtenerProductosEnRiesgo() {
		int stock_minimo;
		List<Producto> productos = new ArrayList<>();
		
		System.out.println("Introduce el stock minimo: ");
		stock_minimo=teclado.nextInt();
		
		pedidos = REPO.obtenerProductosEnRiesgo(stock_minimo);
		
		for (Producto producto : productos) {
			System.out.println("Producto: "+producto.getIdProducto()+", con stock: "+producto.getStock()+", llega al stock minimo");
		}
	}


	private static void asignarNuevoProveedor() {
		boolean bool=false;
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
						  "\n0. Salir");
		return teclado.nextInt();
	}
}
