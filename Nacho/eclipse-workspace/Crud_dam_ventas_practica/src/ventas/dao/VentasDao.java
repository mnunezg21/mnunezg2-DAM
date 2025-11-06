package ventas.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
	
	//INSERT de pedido
	public boolean insertarPedido(int idCliente,Pedido pedido) {
		LocalDate fecha = LocalDate.now();
		String sql = "INSERT INTO pedido (id_cliente,fecha_pedido,total,estado) VALUES (?,?,?,?)";
		if(comprobarExistenciaCliente(idCliente)) {
			try(Connection conn = ConexionBD.getConnection();
					PreparedStatement prst = conn.prepareStatement(sql);){
					
					prst.setInt(1, pedido.getId_cliente());
					prst.setString(2, fecha.toString());
					prst.setDouble(3, pedido.getTotal());
					prst.setString(4, pedido.getEstado());
					
					int filasAfectadas = prst.executeUpdate();
					return filasAfectadas > 0;
				} 
				catch(SQLException e) { 
					System.err.println("Error al insertar el pedido en la BD: "+e.getMessage()); 
					return false;
				}
		}
		System.out.println("No se pudo insertar pedido para este cliente");
		return false;
	}
	
	
	//SELECT pedidos de un cliente
	public List<Pedido> obtenerPedidosDeCliente(int idCliente){
		List<Pedido> listaPedidos = new ArrayList<>();
		
		String sql = "SELECT id_pedido, fecha_pedido, total, estado FROM pedido WHERE id_cliente = "+idCliente+"";
		if(comprobarExistenciaCliente(idCliente)) {
			try(
					Connection conn = ConexionBD.getConnection();
					Statement st = conn.createStatement();
					ResultSet rs= st.executeQuery(sql)){
					
					while(rs.next()) {
						Pedido pedido = new Pedido(rs.getInt("id_pedido"),rs.getString("fecha_pedido"),rs.getDouble("total"),rs.getString("estado"));
						listaPedidos.add(pedido);
					} 
					
				} catch(SQLException e){
					System.err.println("Error al obtener los clientes: "+e.getMessage());
				}	
				return listaPedidos;
		}
		System.out.println("No existe el cliente");
		return null;
	}
	
	//UPDATE 
	public boolean actualizarEstadoPedido(int idPedido, String nuevoEstado) {
		String sql = "UPDATE pedido SET estado = ? WHERE id_pedido = ?";
		if(comprobarExistenciaPedido(idPedido)) {
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
		System.out.println("Este pedido no esta registrado");
		return false;
	} 
	
	//DELETE
	public boolean eliminarCliente(int idCliente) {
		String sql = "DELETE FROM cliente WHERE id_cliente = ?";
		if(comprobarExistenciaCliente(idCliente)) {
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
		System.out.println("No existe el cliente");
		return false;
	} 
	
	
	// CallableStatement
	public void aplicarDescuento(int idPedido, double porcentaje) {
		String sqlCall = "{CALL aplicar_descuento_pedido(?, ?)}";
		 String sqlSelect = "SELECT total FROM pedido WHERE id_pedido = ?";
		 if(comprobarExistenciaPedido(idPedido)) {
			 try (
				Connection conn = ConexionBD.getConnection();
				PreparedStatement prst1 = conn.prepareStatement(sqlSelect);
			    CallableStatement call = conn.prepareCall(sqlCall);
				PreparedStatement prst2 = conn.prepareStatement(sqlSelect);){
						 
					prst1.setInt(1, idPedido);
					ResultSet rs1 = prst1.executeQuery();
					if (rs1.next()) {
						double total1 = rs1.getDouble("total");
					    System.out.println("Total antes del descuento: " + total1 + " €");

					    call.setInt(1, idPedido);
					    call.setDouble(2, porcentaje);
					    call.execute();

					    prst2.setInt(1, idPedido);
					    ResultSet rs2 = prst2.executeQuery();

					    if (rs2.next()) {
					       double total2 = rs2.getDouble("total");
					       System.out.println("Total después del descuento: " + total2 + " €");
					    }
				}
			}catch(SQLException e){
				System.err.println("Error al aplicar descuento:  "+e.getMessage()); 
			}
		 } else {
		        System.out.println("No existe el pedido, no se puede aplicar el descuento.");
		    }
	}
	
	//DatabaseMetaData
	public void obtenerInfoEsquema() {
		try (Connection conn = ConexionBD.getConnection()){
			DatabaseMetaData metaData =conn.getMetaData();
			
			System.out.println("Infomracion del Driver JDBC");
			System.out.println("Nombre del driver: " + metaData.getDriverName());
	        System.out.println("Version del driver: " + metaData.getDriverVersion());

	        System.out.println("\n-------------------------------------------------------\n");
	        
	        System.out.println("Tablas en el esquema *dam_ventas_practica*:");
	        
	        ResultSet tablas = metaData.getTables("dam_ventas_practica", null, "%", new String[] {"TABLE"});
	        while (tablas.next()) {
	            String nombreTabla = tablas.getString("TABLE_NAME");
	            System.out.println("- " + nombreTabla);
	        }
	        tablas.close();
	        
	        System.out.println("\n-------------------------------------------------------\n");

	        System.out.println("Columnas de la tabla *cliente*:");
	        
	        ResultSet columnas = metaData.getColumns("dam_ventas_practica", null, "cliente", "%");
	        while (columnas.next()) {
	            String nombreColumna = columnas.getString("COLUMN_NAME");
	            String tipoDato = columnas.getString("TYPE_NAME");
	            int tamanio = columnas.getInt("COLUMN_SIZE");
	            System.out.println("- " + nombreColumna + " (" + tipoDato + ", tamanio: " + tamanio + ")");
	        }
	        columnas.close();

	        System.out.println("\n-------------------------------------------------------\n");
		} catch(SQLException e) {
			System.err.println("Error al obtener la informacion del esquema: "+e.getMessage());
		}
	}
	
	//Comprobar Cliente
	public boolean comprobarExistenciaCliente(int idCliente) {
		String sql = "SELECT id_cliente FROM cliente WHERE id_cliente="+idCliente+"";
		try(
				Connection conn = ConexionBD.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs= st.executeQuery(sql)){
				
				if(rs.next()) {
					return rs.getInt("id_cliente")==idCliente;
				}
				else {
					System.out.println("Este codigo no pertenece a nigun cliente"); 
					return false;
				}
		} catch(SQLException e) {
			System.err.println("Error al comprobar el cliente en la BD: "+e.getMessage()); 
			return false;
		}
	}
	
	//Comprobar Pedido
	public boolean comprobarExistenciaPedido(int idPedido) {
		String sql = "SELECT id_pedido FROM pedido WHERE id_pedido="+idPedido+"";
		try(
				Connection conn = ConexionBD.getConnection();
				Statement st = conn.createStatement();
				ResultSet rs= st.executeQuery(sql)){
				
				if(rs.next()) {
					return rs.getInt("id_pedido")==idPedido;
				}
				else {
					System.out.println("Este codigo no pertenece a nigun pedido"); 
					return false;
				}
		} catch(SQLException e) {
			System.err.println("Error al comprobar el pedido en la BD: "+e.getMessage()); 
			return false;
		}
	}
}
