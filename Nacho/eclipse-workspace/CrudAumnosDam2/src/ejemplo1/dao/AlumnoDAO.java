package ejemplo1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import ejemplo1.modelo.Alumno;
import ejemplo1.util.ConexionBD;

public class AlumnoDAO {
	
	//INSERT
	public boolean insertarAlumno(Alumno alumno) {
		String sql = "INSERT INTO alumno (nombre,apellido,email,curso) VALUES (?,?,?,?)";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setString(1, alumno.getNombre());
			prst.setString(2, alumno.getApellido());
			prst.setString(3, alumno.getEmail());
			prst.setString(4, alumno.getCurso());
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al insertar el alumno en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	//SELECT
	public List<Alumno> obtenerTodosAlumnos(){
		List<Alumno> lista = new ArrayList<>();
		
		String sql = "SELECT id, nombre, apellido, email, curso FROM alumno";
		
		try(
			Connection conn = ConexionBD.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(sql)){
			
			while(rs.next()) {
				Alumno alumno = new Alumno(rs.getInt("id"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("curso"));
				lista.add(alumno);
			} 
			
			
		} catch(SQLException e){
			System.err.println("Error al obtener los alumnos: "+e.getMessage());
		}	
		return lista;
	}
	
	//UPDATE
	public boolean actualizarAlumno(Alumno alumno) {
		String sql = "UPDATE INT alumno nombre = ?, apellido = ?, email = ?, curso = ? WHERE id = ?";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setString(1, alumno.getNombre());
			prst.setString(2, alumno.getApellido());
			prst.setString(3, alumno.getEmail());
			prst.setString(4, alumno.getCurso());
			
			prst.setInt(5, alumno.getId());
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al actualizar el alumno en la BD: "+e.getMessage()); 
			return false;
		}
	} 
	
	//DELETE
		public boolean borrarAlumno(int idAlumno) {
		String sql = "DELETE FROM alumno WHERE id = ?";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, idAlumno);
		
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al borrar al alumno en la BD: "+e.getMessage()); 
			return false;
		}
		
		
	} 
}
