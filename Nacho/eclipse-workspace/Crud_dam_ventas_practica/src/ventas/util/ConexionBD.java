package ventas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static String URL = "jdbc:mysql://localhost:3306/dam_ventas_practica";
	private static String USUARIO = "root";
	private static String CLAVE = "root";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL,USUARIO,CLAVE);
			System.out.println("Conexion OK");
		} catch (SQLException e) {
			System.err.println("Error cibexuib BD: "+e.getMessage());
		}
		return conn;
	}
}
