package repository;
import java.util.List;

import org.hibernate.Session;

import modelo.Producto;
import modelo.Proveedor;
import modelo.Ubicacion;
import util.HibernateUtil;

public class CRUD {
	
	public boolean guardarProductoCompleto(Producto p) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean insertado = false;

		try {
			session.beginTransaction();
			session.persist(p);
			session.getTransaction().commit();
			insertado = true;
		} catch(Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error guardado el producto: " + e.getMessage());
		} finally {
			session.close();
		}
		return insertado;
	}
	
	public List<Producto> obtenerProductosEnRiesgo(int stockMinimo) {
		List<Producto> productos = null;		
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();

			productos = session.createQuery("FROM Producto p WHERE p.stock < :stockMinimo AND p.precio > 5.00", Producto.class)
					.setParameter("stockMinimo", stockMinimo)
					.list();

			session.getTransaction().commit();

		} catch(Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error guardado los produc: " + e.getMessage());
		} finally {
			session.close();
		}
		return productos;
	}

	public boolean asignarNuevoProveedor(int idProducto, int idProveedorNuevo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean modificado = false;
		Producto producto = null;
		Proveedor proveedor= null;

		try {
			session.beginTransaction();

			producto = session.createQuery("FROM Producto p WHERE id_producto = :idProducto ", Producto.class)
					.setParameter("idProducto", idProducto).getSingleResult();

			proveedor = session.createQuery("FROM Proveedor p WHERE id_proveedor = :idProveedor ", Proveedor.class)
					.setParameter("idProveedor", idProveedorNuevo).getSingleResult();

			producto.getProveedores().add(proveedor);

			session.persist(producto);

			session.getTransaction().commit();
		} catch(Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error asignando un nuevo proveedor: " + e.getMessage());
		} finally {
			session.close();
		}
		return modificado;
	}
	
	public boolean eliminarProductoYUbicacion(int idProducto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		boolean borrado = false;
		Producto producto;

		try {
			session.beginTransaction();
			producto = session.get(Producto.class, idProducto);

			if (producto != null) {
				session.remove(producto);
				session.getTransaction().commit();
				borrado = true;
			}

			session.getTransaction().rollback();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		return borrado;
	}
	
	public List<Object[]> obtenerReporteProveedores() {
		Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Object[]> reporte = null;

	    try {
	        session.beginTransaction();

	        String hql =
	            "SELECT pr.nombre, COUNT(p.id_producto) " +
	            "FROM Proveedor pr " +
	            "JOIN pr.productos p " +
	            "GROUP BY pr.nombre " +
	            "ORDER BY COUNT(p.id_producto) DESC";

	        reporte = session.createQuery(hql, Object[].class).list();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        System.err.println("Error obteniendo reporte de proveedores: " + e.getMessage());
	    } finally {
	        session.close();
	    }

	    return reporte;
	}
	
	public List<Producto> obtenerProductosPorPasillo(String pasillo) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    List<Producto> productos = null;

	    try {
	        session.beginTransaction();

	        String hql = "FROM Producto p WHERE p.ubicacion.pasillo = :pasillo";

	        productos = session.createQuery(hql, Producto.class)
	                .setParameter("pasillo", pasillo)
	                .list();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        System.err.println("Error obteniendo productos por pasillo: " + e.getMessage());
	    } finally {
	        session.close();
	    }

	    return productos;
	}
	
	
	
	public Ubicacion buscarUbicacion(int idUbicacion) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Ubicacion ubicacion = null;

	    try {
	        session.beginTransaction();

	        String hql = "FROM Ubicacion u WHERE u.id_ubicacion = :idUbicacion";

	        ubicacion = session.createQuery(hql, Ubicacion.class)
	                .setParameter("idUbicacion", idUbicacion)
	                .uniqueResult();

	        session.getTransaction().commit();
	    } catch (Exception e) {
	        session.getTransaction().rollback();
	        System.err.println("Error obteniendo ubicación: " + e.getMessage());
	    } finally {
	        session.close();
	    }

	    return ubicacion;
	}
	
	
}
