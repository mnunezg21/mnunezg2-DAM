package util;

import javax.naming.ConfigurationException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY=buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		/* Configuration configuration = new Configuration();
		 * configuration.configure();
		 *		(Se registran las clases que hay que mapear con cada tabla de la base de datos)
		 *	configuration.addAnnotatedClass(Clase1.class);
		 *  configuration.addAnnotatedClass(Clase2.class);
		 *  configuration.addAnnotatedClass(Clase3.class);
		 *  
		 *  
		 *  StabndarServiceRegistry serviceRegistry = new StandarsServiceRegistryBuilder().applySettings(
		 *  		configuration.getProperties()).build();
		 *  sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 * */
		
		
		
		
		try {
			//Cargamos la configuracion del fichero de configuracion hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable e) {
			System.err.println("La creacion de SessionFactory falló: "+e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
	
	public static void shutDown() {
		getSessionFactory().close();
	}
	
}
