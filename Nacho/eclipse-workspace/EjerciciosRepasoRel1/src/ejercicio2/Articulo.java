package ejercicio2;

public class Articulo {
	private String descripcion;
	private double precio;
	private double descuento;
	private double iva;
	
	public Articulo() {
	}
	
	public Articulo(String descripcion, double precio, double descuento, double iva) {
		this.descripcion = descripcion;
		this.precio = precio;
		this.descuento = descuento;
		this.iva = iva;
	}

	public double descuentoAplicado() {
		return this.precio*this.descuento;
	}
	
	public double ivaAplicado() {
		return this.precio*this.iva;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Articulo [descripcion=" + descripcion + ", precio=" + precio + ", descuento=" + descuento + ", iva="
				+ iva + "]";
	}
	
}
