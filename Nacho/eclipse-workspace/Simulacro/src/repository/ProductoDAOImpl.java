package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Almacen;
import modelo.Producto;
import util.ConexionBD;

public class ProductoDAOImpl implements ProductoDAO {
	
	@Override
	public boolean insertar(Producto producto){		
		String sql = "INSERT INTO producto (nombre,precio,stock) VALUES (?,?,?)";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setString(1, producto.getNombre());
			prst.setDouble(2, producto.getPrecio());
			prst.setInt(3, producto.getStock());
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al insertar el producto en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	@Override
	public boolean actualizar(int id_producto, int nuevoStock) {
		String sql = "UPDATE producto SET stock = ? WHERE id_producto = ?";
		
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, nuevoStock);
			prst.setInt(2, id_producto);
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al actualizar el stock del producto en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	@Override
	public boolean eliminar(int id_producto) {
		String sql = "DELETE FROM producto WHERE id_producto = ?";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, id_producto);
		
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al borrar al producto en la BD: "+e.getMessage()); 
			return false;
		}	
	}

	public List<Producto> buscarStockInferior(){
		List<Producto> listaProductos= new ArrayList<Producto>();
		String sql = "SELECT * FROM producto WHERE stock <= 10";
		try(
			Connection conn = ConexionBD.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(sql)){
			
			
			while(rs.next()) {
				Producto producto = new Producto(
						rs.getInt("id_producto"),
						rs.getString("nombre"),
						rs.getDouble("precio"),
						rs.getInt("stock"));
				listaProductos.add(producto);
			}
		} catch(SQLException e){
			System.err.println("Error al obtener los productos: "+e.getMessage());
			return null;
		}
		return listaProductos;	
	}
	
	public boolean importarAlmacenes(List<Almacen> almacenes) {
		int totalInsertado = 0;
		String sql = "INSERT INTO almacen (codigo,nombre,ciudad,capacidad) VALUES (?,?,?,?)";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			for(Almacen almacen : almacenes) {
				prst.setString(1, almacen.getCodigo());
				prst.setString(2, almacen.getNombre());
				prst.setString(3, almacen.getCiudad());
				prst.setInt(4, almacen.getCapacidad());
				int filasAfectadas = prst.executeUpdate();
				totalInsertado += filasAfectadas;
			}
			return totalInsertado > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al insertar los almacenes en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	public List<Producto> exportarProductosConPrecioElevado(){
		List<Producto> listaProductos= new ArrayList<Producto>();
		String sql = "SELECT * FROM producto WHERE precio >= 50";
		try(
			Connection conn = ConexionBD.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(sql)){
			
			while(rs.next()) {
				Producto producto = new Producto(
						rs.getInt("id_producto"),
						rs.getString("nombre"),
						rs.getDouble("precio"),
						rs.getInt("stock"));
				listaProductos.add(producto);
			}
		} catch(SQLException e){
			System.err.println("Error al obtener los productos: "+e.getMessage());
			return null;
		}
		return listaProductos;	
	}
	
	@Override
	public Producto obetenerPorId(int idProducto) {
		String sql = "SELECT * FROM producto WHERE id_producto = ?";
		try(
			Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, idProducto);
			
			ResultSet rs = prst.executeQuery();
			
			Producto producto = new Producto(
					rs.getInt("id_producto"),
					rs.getString("nombre"),
					rs.getDouble("precio"),
					rs.getInt("stock"));
			return producto;
		} catch(SQLException e){
			System.err.println("Error al obtener al producto: "+e.getMessage());
			return null;
		}
	}
	

	@Override
	public List<Producto> obtenerTodosLosProductos() {
		List<Producto> listaProductos = new ArrayList<>();
		
		String sql = "SELECT * FROM producto";		
		try(
			Connection conn = ConexionBD.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(sql)){
			
			while(rs.next()) {
				Producto producto = new Producto(
						rs.getInt("id_producto"),
						rs.getString("nombre"),
						rs.getDouble("precio"),
						rs.getInt("stock"));
				
				listaProductos.add(producto);
			} 
		} catch(SQLException e){
			System.err.println("Error al obtener los productos: "+e.getMessage());
		}	
		return listaProductos;
	}
}
