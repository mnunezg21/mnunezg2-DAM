package ventas.main;

import java.util.Scanner;
import ventas.dao.VentasDao;

public class Main {
	
	
	private static Scanner teclado = new Scanner(System.in).useDelimiter("\n");
	
	public static void main(String[] args) {
		int id_pedido;
		int id_cliente;
		
		int opcion =- 1; 
		while(opcion != 0) {
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
			default: 
				System.out.println("Error en la entrada de teclado");
				break;
			}
		}

	}


	private static void crearNuevoPedido() {
		
		VentasDAO.insertarPedido();
	}


	private static void consultarPedidosDeCliente() {
		
		
	}


	private static void actualizarEstadoDePedido() {
		
		
	}


	private static void eliminarCliente() {
		
		
	}


	private static void aplicarDescuento() {
		
		
	}


	private static void recogerInformacionEsquema() {
		
		
	}


	private static int mostrarMenu() {
		System.out.println("1. Crear nuevo pedido"+
						  "\n2. Consultar pedidos de un cliente"+
						  "\n3. Actualizar el estado de un pedido"+
						  "\n4. Eliminar un cliente y sus pedidos"+
						  "\n5. Aplicar Descuento"+
						  "\n6. Información del esquema");
		return teclado.nextInt();
	}

}
