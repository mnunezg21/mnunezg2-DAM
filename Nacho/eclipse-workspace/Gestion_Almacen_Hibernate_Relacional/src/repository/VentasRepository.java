package repository;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import modelo.Cliente;
import modelo.EstadoPedido;
import modelo.Pedido;
import util.HibernateUtil;

public class VentasRepository {

	//A. Create: Insertar un nuevo pedido asociado a un cliente 
	public boolean guardarPedido(Pedido pedido) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.persist(pedido);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al guardar el pedido: " + e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}
	
	//B. READ: Obtener pedido spor cliente (HQL)
	public List<Pedido> obtenerPedidosPorCliente(int idCLiente){
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Pedido> pedidos = null;
		try {
			session.beginTransaction();
			pedidos=session.createQuery(
					"FROM Pedido p WHERE p.cliente.id = :clienteId", Pedido.class)
					.setParameter("clienteId", idCLiente).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al leer el pedido: " + e.getMessage());
		}finally {
			session.close();
		}
		return pedidos;
	}
	
	//C. UPDATE: Actualizar el estado de un pedido
	public boolean actualizarEstadoPedido(int idPedido, EstadoPedido nuevoEstado) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			//Obtener el pedido (SELECT implícito)
			Pedido pedido = session.get(Pedido.class, idPedido);
			
			if(pedido != null) {
				pedido.setEstado(nuevoEstado);
				session.merge(pedido);
				session.getTransaction().commit();
				return true;
			}
			session.getTransaction().rollback();
			return false;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al actualizar el pedido: " + e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}
	
	//D. DELETE: Eliminar un cliente (y todos sus pedidos - cascada)
	public boolean eliminarCliente(int idCliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			//Obetener el objeto Cliente
			Cliente cliente = session.get(Cliente.class, idCliente);
			if (cliente != null) {
				session.remove(cliente);
				session.getTransaction().commit();
				return true;
			}
			session.getTransaction().rollback();
			return false;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al eliminar el cliente: " + e.getMessage());
			return false;
		} finally {
			session.close();
		}
	}
}
