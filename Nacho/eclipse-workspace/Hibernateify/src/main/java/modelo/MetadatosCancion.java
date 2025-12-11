package modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "metadatos_cancion")
public class MetadatosCancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_meta")
    private Integer idMeta;

    @Column(name = "letra", columnDefinition = "TEXT")
    private String letra;

    @Column(name = "productor", length = 100)
    private String productor;

    @Column(name = "fecha_lanzamiento")
    private LocalDate fechaLanzamiento;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cancion", unique = true, nullable = false)
    private Cancion cancion;

    public MetadatosCancion() {}

    public MetadatosCancion(String letra, String productor, LocalDate fechaLanzamiento) {
        this.letra = letra;
        this.productor = productor;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Integer getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Integer idMeta) {
        this.idMeta = idMeta;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

	@Override
	public String toString() {
		return "MetadatosCancion [idMeta=" + idMeta + ", letra=" + letra + ", productor=" + productor
				+ ", fechaLanzamiento=" + fechaLanzamiento + ", cancion=" + cancion + "]";
	}
}