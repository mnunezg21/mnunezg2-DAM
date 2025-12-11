package repository;

import  modelo.*;
import util.HibernateUtil;

import org.hibernate.Session;

public class CRUD {
	
	public Artista existeArtista(Integer idArtista, String nombre, String nacionalidad) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Artista artista = null;
        
        try {
            session.beginTransaction();
            
            if (idArtista != null) {
                artista = session.get(Artista.class, idArtista);
                
            } else if (nombre != null && nacionalidad != null) {
                String hql = "FROM Artista a WHERE a.nombre = :nombre AND a.nacionalidad = :nacionalidad";

                artista = session.createQuery(hql, Artista.class)
                                 .setParameter("nombre", nombre)
                                 .setParameter("nacionalidad", nacionalidad)
                                 .uniqueResult();
            }
            
            session.getTransaction().commit();
            
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al comprobar la existencia del artista: " + e.getMessage());
        } finally {
            session.close();
        }
        return artista;
    }
	
	public boolean guardarArtistaYAlbum(Artista artista) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean insertado = false;
        try {
            session.beginTransaction();
            session.persist(artista); // Usa persist para nuevos objetos, y merge si ya tiene ID
            session.getTransaction().commit();
            insertado = true;
        } catch(Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al guardar artista y album: " + e.getMessage());
        } finally {
            session.close();
        }
        return insertado;
    }
	
	public Cancion buscarCancionPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cancion cancion = null;
        try {
            session.beginTransaction();
            cancion = session.get(Cancion.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
             if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return cancion;
    }
	
	public boolean guardarPlaylist(Playlist playlist) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean insertado = false;
        try {
            session.beginTransaction();
            // Si la playlist es nueva, persist
            session.persist(playlist); 
            session.getTransaction().commit();
            insertado = true;
        } catch(Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al guardar playlist: " + e.getMessage());
        } finally {
            session.close();
        }
        return insertado;
    }

    /*public List<Artista> generarReporteArtistas() {
   
    }*/
    
    public boolean eliminarCancion(Integer idCancion) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean borrado = false;
        try {
            session.beginTransaction();
            Cancion cancion = session.get(Cancion.class, idCancion);

            if (cancion != null) {
                session.remove(cancion); 
                session.getTransaction().commit();
                borrado = true;
            } else {
                 session.getTransaction().rollback(); 
            }
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al eliminar cancion: " + e.getMessage());
        } finally {
            session.close();
        }
        return borrado;
    }


    public boolean reasignarCancion(Integer idCancion, Integer idNuevoArtista) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        boolean modificado = false;
        try {
            session.beginTransaction();
            
            Cancion cancion = session.get(Cancion.class, idCancion);
            Artista nuevoArtista = session.get(Artista.class, idNuevoArtista);

            if (cancion != null && nuevoArtista != null) {
                nuevoArtista.addCancion(cancion); 
                session.merge(cancion); 
                
                session.getTransaction().commit();
                modificado = true;
            } else {
                System.out.println("Error Cancion o Artista no encontrados.");
                session.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            System.err.println("Error al reasignar cancion: " + e.getMessage());
        } finally {
            session.close();
        }
        return modificado;
    }
    
    public Artista buscarArtistaPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Artista artista = null;
        try {
            session.beginTransaction();
            artista = session.get(Artista.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
             if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
        return artista;
    }
}
