package modelo;

public class Almacen {

	private String codigo;
	private String nombre;
	private String ciudad;
	private int capacidad;
	
	public Almacen(String codigo, String nombre, String ciudad, int capacidad) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.capacidad = capacidad;
	}
	
	public Almacen(String nombre, String ciudad, int capacidad) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.capacidad = capacidad;
	}

	public Almacen() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Almacen [codigo=" + codigo + ", nombre=" + nombre + ", ciudad=" + ciudad + ", capacidad=" + capacidad
				+ "]";
	}
}
