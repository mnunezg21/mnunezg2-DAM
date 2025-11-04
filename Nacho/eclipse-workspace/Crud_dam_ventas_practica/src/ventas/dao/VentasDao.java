package ventas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ventas.modelo.Cliente;
import ventas.modelo.Pedido;
import ventas.util.ConexionBD;

public class VentasDao {
	
	//INSERT de pedido | Falta Validación
	public boolean insertarPedido(Pedido pedido) {
		LocalDate fecha = LocalDate.now();
		String sql = "INSERT INTO pedido (id_cliente,id_pedido,fecha_pedido,total,estado) VALUES (?,?,?,?)";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, pedido.getId_cliente());
			prst.setInt(1, pedido.getId_pedido());
			prst.setString(2, fecha.toString());
			prst.setFloat(3, pedido.getTotal());
			prst.setString(4, pedido.getEstado());
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al insertar el pedido en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	//SELECT pedidos de un cliente | 
	public List<Pedido> obtenerPedidosDeCliente(int idCliente){
		List<Pedido> listaPedidos = new ArrayList<>();
		
		String sql = "SELECT id_pedido, fecha_pedido, total, estado FROM cliente WHERE id_cliente = "+idCliente+"";
		
		try(
			Connection conn = ConexionBD.getConnection();
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(sql)){
			
			while(rs.next()) {
				Pedido pedido = new Pedido(rs.getInt("id_pedido"),rs.getString("fecha_pedido"),rs.getFloat("total"),rs.getString("estado"));
				listaPedidos.add(pedido);
			} 
			
			
		} catch(SQLException e){
			System.err.println("Error al obtener los clientes: "+e.getMessage());
		}	
		return listaPedidos;
	}
	
	//UPDATE 
	public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
		String sql = "UPDATE INT pedido estado = ? WHERE id_pedido = ?";
		
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setString(1, nuevoEstado);
			prst.setInt(2, idPedido);
			
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al actualizar el cliente en la BD: "+e.getMessage()); 
			return false;
		}
	} 
	
	//DELETE
	public boolean eliminarCliente(int idCliente) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		try(Connection conn = ConexionBD.getConnection();
			PreparedStatement prst = conn.prepareStatement(sql);){
			
			prst.setInt(1, idCliente);
		
			int filasAfectadas = prst.executeUpdate();
			return filasAfectadas > 0;
		} 
		catch(SQLException e) { 
			System.err.println("Error al borrar al cliente en la BD: "+e.getMessage()); 
			return false;
		}	
	} 
	
	
	// CallableStatement
	/*public boolean aplicarDescuento() {
		
	}*/
	
	//DatabaseMetaData
	/*public void obtenerInfoEsquema() {
		
	}*/
}
