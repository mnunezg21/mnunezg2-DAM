package modelo;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ubicacion")
public class Ubicacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_ubicacion")
	private int idUbicacion;
	
	@Column(name="pasillo")
	private String pasillo;
	
	@Column(name="estanteria")
	private int estanteria;
	
	@Column(name = "fecha_adquisicion")
	private LocalDate fechaAdquisicion;

	@OneToOne(mappedBy = "ubicacion")
    private Producto producto;

	public Ubicacion() {
        this.fechaAdquisicion = LocalDate.now();
	}

	public Ubicacion(String pasillo, int estanteria, LocalDate fechaAdquisicion) {
		this.pasillo = pasillo;
		this.estanteria = estanteria;
		this.fechaAdquisicion = fechaAdquisicion; 
	}

	public int getIdUbicacion() {
		return idUbicacion;
	}

	public void setIdUbicacion(int idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public String getPasillo() {
		return pasillo;
	}

	public void setPasillo(String pasillo) {
		this.pasillo = pasillo;
	}

	public int getEstanteria() {
		return estanteria;
	}

	public void setEstanteria(int estanteria) {
		this.estanteria = estanteria;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@Override
	public String toString() {
		return "Ubicacion [idUbicacion=" + idUbicacion + ", pasillo=" + pasillo + ", estanteria=" + estanteria
				+ ", fechaAdquisicion=" + fechaAdquisicion + "]";
	}
}
