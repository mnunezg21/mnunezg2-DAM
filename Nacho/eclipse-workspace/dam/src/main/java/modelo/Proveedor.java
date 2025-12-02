package modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proveedor")
	private int idProveedor;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="contacto")
	private String contacto;

	@ManyToMany(mappedBy = "proveedores", fetch = FetchType.LAZY)
    private List<Producto> productos;
	
	public Proveedor() {
	}

	public Proveedor(int idProveedor, String nombre, String contacto, List<Producto> productos) {
		this.idProveedor = idProveedor;
		this.nombre = nombre;
		this.contacto = contacto;
		this.productos = productos;
	}

	public Proveedor(String nombre, String contacto, List<Producto> productos) {
		this.nombre = nombre;
		this.contacto = contacto;
		this.productos = productos;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Proveedor [idProveedor=" + idProveedor + ", nombre=" + nombre + ", contacto=" + contacto
				+ ", productos=" + productos + "]";
	}
}
