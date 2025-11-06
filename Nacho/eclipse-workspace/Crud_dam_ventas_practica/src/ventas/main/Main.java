package ventas.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ventas.dao.VentasDao;
import ventas.modelo.Pedido;

public class Main {
	
	
	private static Scanner teclado = new Scanner(System.in);
	private static VentasDao ventasDao = new VentasDao();
	
	public static void main(String[] args) {		
		int opcion=0;
		
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				crearNuevoPedido();
				break;
			case 2:
				consultarPedidosDeCliente();
				break;
			case 3:
				actualizarEstadoDePedido();
				break;
			case 4:
				eliminarCliente();
				break;
			case 5:
				aplicarDescuento();
				break;
			case 6:
				recogerInformacionEsquema();
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


	private static void crearNuevoPedido() {
		int id_cliente;
		String fecha_pedido;
		double total;
		String estado;
		
		boolean bool=false;
		boolean cambioRealizado;
		
		System.out.println("Introduce el id del cliente: ");
		id_cliente = teclado.nextInt();
		System.out.println("Introduciendo la fecha de realizacion del pedido... ");
		fecha_pedido = java.time.LocalDate.now().toString();
		System.out.println("Introduce el total: ");
		total = teclado.nextDouble();
		do {
			System.out.println("Introduce el estado(PENDIENTE, ENVIADO, ENTREGADO o CANCELADO): ");
			estado = teclado.next();
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


	private static void consultarPedidosDeCliente() {
		int id_cliente;
		List<Pedido> pedidos = new ArrayList<>();
		
		System.out.println("Introduce el id del cliente: ");
		id_cliente=teclado.nextInt();
		
		pedidos = ventasDao.obtenerPedidosDeCliente(id_cliente);
		
		for (Pedido pedido : pedidos) {
			System.out.println("Pedido: "+pedido.getId_pedido()+", con fecha: "+pedido.getFecha_pedido()+", y con un total de: "+pedido.getTotal());
		}
	}


	private static void actualizarEstadoDePedido() {
		int id_pedido;
		String estado;
		
		boolean bool=false;
		boolean cambioRealizado;
		
		System.out.println("Introduce el id del pedido: ");
		id_pedido=teclado.nextInt();
		do {
			System.out.println("Introduce el estado(PENDIENTE, ENVIADO, ENTREGADO o CANCELADO): ");
			estado = teclado.next();
			if(estado.equalsIgnoreCase("PENDIENTE") || 
			   estado.equalsIgnoreCase("ENVIADO")   || 
			   estado.equalsIgnoreCase("ENTREGADO") || 
			   estado.equalsIgnoreCase("CANCELADO")) {
				
				cambioRealizado = ventasDao.actualizarEstadoPedido(id_pedido, estado);
				if(cambioRealizado) System.out.println("Pedido actualizado");
				else System.out.println("Pedido no actualizado");
				bool=true;
			} else System.out.println("Introduce una de las opciones: ");
		} while(!bool);
	}


	private static void eliminarCliente() {
		int id_cliente;
		boolean bool = false;
		
		System.out.println("Introduce el id del cliente: ");
		id_cliente=teclado.nextInt();
		
		bool=ventasDao.eliminarCliente(id_cliente);
		if(bool)System.out.println("Cliente eliminado"); 
		else System.out.println("Cliente no eliminado");
	}


	private static void aplicarDescuento() {
		 System.out.println("Introduce el ID del pedido: ");
		    int id_pedido = teclado.nextInt();

		    System.out.println("Introduce el porcentaje de descuento: ");
		    double descuento = teclado.nextDouble();
		    
		    ventasDao.aplicarDescuento(id_pedido, descuento);
	}


	private static void recogerInformacionEsquema() {
		ventasDao.obtenerInfoEsquema();	
	}


	private static int mostrarMenu() {
		System.out.println("1. Crear nuevo pedido"+
						  "\n2. Consultar pedidos de un cliente"+
						  "\n3. Actualizar el estado de un pedido"+
						  "\n4. Eliminar un cliente y sus pedidos"+
						  "\n5. Aplicar Descuento"+
						  "\n6. Información del esquema"+
						  "\n0. Salir");
		return teclado.nextInt();
	}
}
