package util;

import javax.naming.ConfigurationException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY=buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
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
