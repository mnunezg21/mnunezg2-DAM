package modelo;

import java.time.LocalDate;
import jakarta.persistence.*;
@Entity
@Table(name="pedido")
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
	private double total;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "estado")
	private EstadoPedido estado;
	
	public Pedido() {
	}

	public Pedido(int idPedido, Cliente cliente, double total, EstadoPedido estado) {
		this.idPedido = idPedido;
		this.cliente = cliente;
		this.total = total;
		this.estado = estado;
	}

	public Pedido(Cliente cliente, double total, EstadoPedido estado) {
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

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", cliente=" + cliente + ", fechaPedido=" + fechaPedido + ", total="
				+ total + ", estado=" + estado + "]";
	}
}
