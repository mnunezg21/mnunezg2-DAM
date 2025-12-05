package modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="precio")
	private double precio;

	@OneToOne
    @JoinColumn(name = "id_ubicacion", unique = true)
    private Ubicacion ubicacion;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "proveedor_producto",
        joinColumns = @JoinColumn(name = "id_producto"),
        inverseJoinColumns = @JoinColumn(name = "id_proveedor")
    )
    private List<Proveedor> proveedores;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    
	public Producto() {
	}

	public Producto(String nombre, int stock, double precio, Ubicacion ubicacion, Categoria categoria) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.ubicacion = ubicacion;
		this.categoria = categoria;
	}

	public Producto(String nombre, int stock, double precio, Ubicacion ubicacion) {
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
		this.ubicacion = ubicacion;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", ubicacion=" + ubicacion + ", proveedores=" + proveedores + ", categoria=" + categoria + "]";
	}


}
