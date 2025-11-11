package main;

import java.time.LocalDate;

import modelo.Cliente;
import modelo.EstadoPedido;
import modelo.Pedido;
import repository.VentasRepository;

public class Main {

	public static final VentasRepository REPO = new VentasRepository();
	
	public static void main(String[] args) {
		Cliente nuevoCliente = new Cliente(3, "Paco", "Perez", "paco-perez@email.com");
		
		//CREATE
		System.out.println("----- 1. CREATE ORM -----");
		Pedido nuevoPedido = new Pedido();
		
		nuevoPedido.setCliente(nuevoCliente);
		nuevoPedido.setTotal(350.50);
		nuevoPedido.setEstado(EstadoPedido.PENDIENTE);
		nuevoPedido.setFechaPedido(LocalDate.now());
		
		if(REPO.guardarPedido(nuevoPedido)) {
			System.out.println("Pedido ORM guardado con ID: "+ nuevoPedido.getIdPedido());
		}
		
		//READ
		System.out.println("----- 1. READ ORM -----");
		REPO.obtenerPedidosPorCliente(1).forEach(p->
			System.out.println("ID pedido: "+p.getIdPedido()+", Total: "+ p.getTotal()+", Estado: "+p.getEstado())
				);
		
		//UPDATE
		System.out.println("----- 1. UPDATE ORM -----");
		int idPedidoAActualizar = nuevoPedido.getIdPedido();
		if (REPO.actualizarEstadoPedido(idPedidoAActualizar, EstadoPedido.ENVIADO)) {
			System.out.println(nuevoPedido.toString());
		}
		
		//DELETE
		System.out.println("----- 1. DELETE ORM -----");
		if(REPO.eliminarCliente(1)) {
			System.out.println("Cliente 1 y sus pedidos eliminados correctamente");
		} else {
			System.out.println("ERROR al eliminar Cliente 1 y sus pedidos");
		}
	}

}
