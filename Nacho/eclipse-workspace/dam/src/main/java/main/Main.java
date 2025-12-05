package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Categoria;
import modelo.Producto;
import modelo.Ubicacion;
import repository.CRUD;


public class Main {

	private static final CRUD REPO = new CRUD();
	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {		
		int opcion=0;
		do {
			opcion = mostrarMenu();
			switch(opcion) {
			case 1:
				guardarProductoCompleto();
				break;
			case 2:
				obtenerProductosEnRiesgo();
				break;
			case 3:
				asignarNuevoProveedor();
				break;
			case 4:
				eliminarProductoYUbicacion();
				break;
			case 5:
				obtenerReporteProveedores();
				break;
			case 6:
				obtenerProductoYUbicacion();
				break;
			case 7:
				crearCategoria();
				break;
			case 8:
				verProductosCategoria();
				break;
			case 9:
				verCategoriasVacias();
				break;
			case 10:
				moverProductosDeCategoria();
				break;
			case 11:
				obtenerResumenCategoria();
				break;
			case 0:
				System.out.println("Saliendo...");
				break;
			default: 
				System.out.println("Error en la entrada de teclado");
				break;
			}
		} while(opcion != 0);
	}

	private static void guardarProductoCompleto() {
		String nombre;
		int stock;
		Double precio;
		Ubicacion ubicacion = null;
		
		System.out.println("Introduce el nombre del producto: ");
		nombre = teclado.next();
		System.out.println("Introduce el stock del producto: ");
		stock = teclado.nextInt();
		System.out.println("Introduce el precio: ");
		precio = teclado.nextDouble();
		System.out.println("Introduce el id de la ubicacion: ");
		ubicacion = REPO.buscarUbicacion(teclado.nextInt());
		Producto producto = new Producto(nombre,stock,precio,ubicacion);
		
		REPO.guardarProductoCompleto(producto);
	}


	private static void obtenerProductosEnRiesgo() {
		int stock_minimo;
		List<Producto> productos = new ArrayList<>();
		
		System.out.println("Introduce el stock minimo: ");
		stock_minimo=teclado.nextInt();
		
		productos = REPO.obtenerProductosEnRiesgo(stock_minimo);
		
		for (Producto producto : productos) {
			System.out.println("Producto: "+producto.getIdProducto()+", con stock: "+producto.getStock()+", llega al stock minimo");
		}
	}


	private static void asignarNuevoProveedor() {
		int id_producto;
		int id_proveedor;
		System.out.print("Dime el ID del producto a cambiar: ");
		id_producto = teclado.nextInt();
		System.out.print("Dime el ID del nuevo proveedor: ");
		id_proveedor = teclado.nextInt();
		
		REPO.asignarNuevoProveedor(id_producto, id_proveedor);	
	}


	private static void eliminarProductoYUbicacion() {
		int id_producto;
		boolean bool = false;
		
		System.out.println("Introduce el id del producto: ");
		id_producto=teclado.nextInt();
		
		bool=REPO.eliminarProductoYUbicacion(id_producto);
		if(bool)System.out.println("Producto eliminado"); 
		else System.out.println("Producto no eliminado");
	}
	
	private static void obtenerReporteProveedores() {
		List<Object[]> proveedores = new ArrayList<Object[]>();
		proveedores = REPO.obtenerReporteProveedores();
		for (Object[] fila : proveedores) {
		    System.out.println("Proveedor: " + fila[0] + " | Productos: " + fila[1]);
		}
	}
	
	private static void obtenerProductoYUbicacion() {
		List<Producto> productos = null;
		System.out.println("Dime el numero del pasillo por el que quieres buscar: ");
		String pasillo = teclado.next();
		productos = REPO.obtenerProductosPorPasillo(pasillo);
		for (Producto producto : productos) {
			System.out.println(producto);
		}
	}
	
	private static void crearCategoria() {
		REPO.crearCategoriaYAsignarProductos();
		
	}

	private static void verProductosCategoria() {
		System.out.print("Introduce el nombre de la categoría a consultar: ");
        String nombre = teclado.next();
        List<Producto> productos = REPO.obtenerProductosDeCategoria(nombre);
        if (productos != null && !productos.isEmpty()) {
            System.out.println("--- Productos en '" + nombre + "' ---");
            for (Producto p : productos) {
                System.out.println("ID: " + p.getIdProducto() + ", Nombre: " + p.getNombre() + ", Precio: " + p.getPrecio());
            }
        } else {
            System.out.println("No se encontraron productos o la categoría no existe.");
        }
		
	}
	
	private static void verCategoriasVacias() {
		List<Categoria> categorias = REPO.obtenerCategoriasVacias();
        if (categorias != null && !categorias.isEmpty()) {
            System.out.println("Categorías sin Productos: ");
            for (Categoria c : categorias) {
                System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre()); // *CORRECCIÓN:* Usar getId()
            }
        } else {
            System.out.println("No se encontraron categorías vacías.");
        }
	}
	
	private static void moverProductosDeCategoria() {
        String catOrigen = "Electrónica";
        String catDestino = "Domótica";
        REPO.moverProductosDeCategoria(catOrigen, catDestino);
    }
	
	private static void obtenerResumenCategoria() {
        List<Object[]> resumen = REPO.obtenerResumenCategoria();
        if (resumen != null && !resumen.isEmpty()) {
            System.out.println("--- Resumen de Categorías ---");
            System.out.printf("%-20s | %-10s | %-15s%n", "Nombre", "Cantidad", "Precio Promedio");
            System.out.println("-----------------------------------------------------");
            for (Object[] fila : resumen) {
                String nombre = (String) fila[0];
                Long cantidad = (Long) fila[1]; 
                Double promedio = (Double) fila[2]; 
                
                String cantStr = (cantidad == null) ? "0" : String.valueOf(cantidad);
                String promStr = (promedio == null) ? "N/A" : String.format("%.2f €", promedio);
                
                System.out.printf("%-20s | %-10s | %-15s%n", nombre, cantStr, promStr);
            }
        } else {
            System.out.println("No se pudo obtener el resumen de categorías.");
        }
    }
	
	private static int mostrarMenu() {
		System.out.println("1.  Crear nuevo producto completo"+
						  "\n2.  Consultar productos en riesgo"+
						  "\n3.  Asignar nuevo proveedor"+
						  "\n4.  Eliminar un producto y su ubicacion"+
						  "\n5.  Obtener Reporte Proveedores"+
						  "\n6.  Obtener Productos por pasillo"+
						  "\n7.  Crear categoría y asignar producto"+
						  "\n8.  Ver productos por categoria"+
						  "\n9.  Ver categorías vacías"+
						  "\n10. Mover productos de Electrónica a Domótica" +
                          "\n11. Obtener Resumen Categoría"+
						  "\n0.  Salir");
		return teclado.nextInt();
	}
	
	
}
