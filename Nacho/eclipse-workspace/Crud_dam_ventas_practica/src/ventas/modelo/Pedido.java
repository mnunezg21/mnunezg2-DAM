package ventas.modelo;

public class Pedido {
	private int id_pedido;
	private int id_cliente;
	private String fecha_pedido;
	private double total;
	private String estado;
	
	public Pedido(int id_pedido, int id_cliente, String fecha_pedido, double total, String estado) {
		this.id_pedido = id_pedido;
		this.id_cliente = id_cliente;
		this.fecha_pedido = fecha_pedido;
		this.total = total;
		this.estado = estado;
	}

	public Pedido(int id_cliente, String fecha_pedido, double total, String estado) {
		this.id_cliente = id_cliente;
		this.fecha_pedido = fecha_pedido;
		this.total = total;
		this.estado = estado;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getFecha_pedido() {
		return fecha_pedido;
	}

	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pedido [id_pedido=" + id_pedido + ", id_cliente=" + id_cliente + ", fecha_pedido=" + fecha_pedido
				+ ", total=" + total + ", estado=" + estado + "]";
	}
}
