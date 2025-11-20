package repository;

import java.util.List;

import modelo.Almacen;
import modelo.Producto;

public interface ProductoDAO {
	
	 boolean insertar(Producto p);
	 
	 boolean actualizar(int idProducto, int stock);
	 
	 boolean eliminar(int idProducto);
	 
	 List<Producto> buscarStockInferior();
	 
	 boolean importarAlmacenes(List<Almacen> almacenes);
	 
	 List<Producto> exportarProductosConPrecioElevado();
	 
	 Producto obetenerPorId(int idProducto);
	 
	 List<Producto> obtenerTodosLosProductos();
}
