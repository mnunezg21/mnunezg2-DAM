package repository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query; 

import modelo.Categoria;
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
                "SELECT pr.nombre, COUNT(p.idProducto) " + // Cambiado a p.idProducto
                "FROM Proveedor pr " +
                "JOIN pr.productos p " +
                "GROUP BY pr.nombre " +
                "ORDER BY COUNT(p.idProducto) DESC"; // Cambiado a p.idProducto

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
	    Ubicacion ubicacionEncontrada = null;

	    try {
	        session.beginTransaction();

	        String hql = "FROM Ubicacion u WHERE u.idUbicacion = :idUbicacion";

	        ubicacionEncontrada = session.createQuery(hql, Ubicacion.class)
	                .setParameter("idUbicacion", idUbicacion)
	                .uniqueResult();

	        session.getTransaction().commit();

	        if (ubicacionEncontrada != null) {
	            System.out.println("Ubicación con ID " + idUbicacion + " encontrada. Procediendo a crear una nueva ubicación.");
	            insertarNuevaUbicacionGenerica(session); 
	        }

	    } catch (Exception e) {
	        if (session.getTransaction() != null && session.getTransaction().isActive()) {
	             session.getTransaction().rollback();
	        }
	        System.err.println("Error en buscarUbicacion: " + e.getMessage());
	    } finally {
	        session.close();
	    }

	    return ubicacionEncontrada;
	}

	private void insertarNuevaUbicacionGenerica(Session currentSession) {
	    Session newSession = HibernateUtil.getSessionFactory().openSession();
	    try {
	        newSession.beginTransaction();
	        
	        Ubicacion nuevaUbicacion = new Ubicacion("E", 100, java.time.LocalDate.now()); 
	        
	        newSession.persist(nuevaUbicacion);
	        newSession.getTransaction().commit();
	        System.out.println("Ubicación insertada correctamente. ID: " + nuevaUbicacion.getIdUbicacion());
	    } catch (Exception e) {
	        if (newSession.getTransaction() != null && newSession.getTransaction().isActive()) {
	            newSession.getTransaction().rollback();
	        }
	        System.err.println("Error al insertar la nueva ubicación: " + e.getMessage());
	    } finally {
	        newSession.close();
	    }
	}
	
	public List<Producto> obtenerProductosDeCategoria(String nombreCategoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<Producto> productos = null;

        try {
            session.beginTransaction();

            String hql = "FROM Producto p WHERE p.categoria.nombre = :nombreCat";

            productos = session.createQuery(hql, Producto.class)
                    .setParameter("nombreCat", nombreCategoria)
                    .list();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al obtener productos de la categoría " + nombreCategoria + ": " + e.getMessage());
        } finally {
            session.close();
        }
        return productos;
	}

	public boolean crearCategoriaYAsignarProductos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean insertado = false;

        try {
            session.beginTransaction();

            Categoria domotica = new Categoria("Domótica", "Dispositivos para el hogar inteligente");

            Producto p1 = new Producto("Bombilla Inteligente", 200, 15.50, null);
            Producto p2 = new Producto("Cerradura Eléctrica", 50, 89.99, null);

            domotica.addProducto(p1);
            domotica.addProducto(p2);

            session.persist(domotica);

            session.getTransaction().commit();
            insertado = true;
            System.out.println(" Categoría y sus productos creados y añadidos correctamente.");
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al crear categoría y productos: " + e.getMessage());
        } finally {
            session.close();
        }
        return insertado;
    }

	public List<Categoria> obtenerCategoriasVacias() {
		Session session = HibernateUtil.getSessionFactory().openSession();
        List<Categoria> categorias = null;

        try {
            session.beginTransaction();

            String hql = "FROM Categoria c WHERE c.productos IS EMPTY";

            categorias = session.createQuery(hql, Categoria.class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al obtener categorías vacías: " + e.getMessage());
        } finally {
            session.close();
        }
        return categorias;
	}

	public boolean moverProductosDeCategoria(String catOrigen, String catDestino) {
		Session session = HibernateUtil.getSessionFactory().openSession();
        boolean modificado = false;

        try {
            session.beginTransaction();

            Categoria origen = session.createQuery("FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
                    .setParameter("nombre", catOrigen)
                    .uniqueResult();

            Categoria destino = session.createQuery("FROM Categoria c WHERE c.nombre = :nombre", Categoria.class)
                    .setParameter("nombre", catDestino)
                    .uniqueResult();

            if (origen != null && destino != null) {
                List<Producto> productosAMover = origen.getProductos();

                if (productosAMover.isEmpty()) {
                    System.out.println("No hay productos para mover en la categoría " + catOrigen);
                    session.getTransaction().rollback();
                    return false;
                }

                for (Producto p : List.copyOf(productosAMover)) {
                    origen.getProductos().remove(p);
                    destino.addProducto(p); 
                    session.merge(p); 
                }

                session.merge(origen);
                session.merge(destino); 
                session.getTransaction().commit();
                modificado = true;
                System.out.println("Movidos " + productosAMover.size() + " productos de '" + catOrigen + "' a '" + catDestino + "'.");
            } else {
                System.out.println("Error: Una o ambas categorías no fueron encontradas.");
                session.getTransaction().rollback();
            }

        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al mover productos de categoría: " + e.getMessage());
        } finally {
            session.close();
        }
        return modificado;
		
	}

	public List<Object[]> obtenerResumenCategoria() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Object[]> resumen = null;

        try {
            session.beginTransaction();

            String hql = "SELECT c.nombre, COUNT(p.idProducto), AVG(p.precio) " + // Cambiado a p.idProducto
                         "FROM Categoria c " +
                         "LEFT JOIN c.productos p " +
                         "GROUP BY c.nombre " +
                         "ORDER BY c.nombre";
            resumen = session.createQuery(hql, Object[].class).list();

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al obtener el resumen de categorías: " + e.getMessage());
        } finally {
            session.close();
        }
        return resumen;
    }
}
