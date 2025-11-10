package modelo;

import java.time.LocalDate;
import jakarta.persistence.*;

public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_pedido")
	private int idPedido;
	
	@ManyToOne 
	@JoinColumn(name = "id_cliente",nullable = false)
	private Cliente cliente;
	
	@Column(name = "fecha_pedido")
	private LocalDate fechaPedido;
	
	@Column(name="total")
	private float total;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private String estado;
	
	
	
	public Pedido() {
	}

	public Pedido(int idPedido, Cliente cliente, float total, String estado) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.total = total;
		this.estado = estado;
	}

	public Pedido(Cliente cliente, float total, String estado) {
		this.cliente = cliente;
		this.total = total;
		this.estado = estado;
		this.fechaPedido = LocalDate.now();
	}
	
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
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
		return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", fechaPedido=" + fechaPedido + ", total="
				+ total + ", estado=" + estado + "]";
	}
}
