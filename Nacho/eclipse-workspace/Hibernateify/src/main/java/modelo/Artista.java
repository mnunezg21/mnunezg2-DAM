package modelo;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artista")
public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_artista")
    private int idArtista;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "nacionalidad", length = 50)
    private String nacionalidad;

    @Column(name = "oyentes_mensuales")
    private Long oyentesMensuales;

   
    @OneToMany(mappedBy = "artista", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Cancion> canciones = new ArrayList<>();

    public Artista() {}

    public Artista(String nombre, String nacionalidad, Long oyentesMensuales) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.oyentesMensuales = oyentesMensuales;
    }

    public void addCancion(Cancion cancion) {
        this.canciones.add(cancion);
        cancion.setArtista(this); 
    }

    public int getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(int idArtista) {
        this.idArtista = idArtista;
    }
    
    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Long getOyentesMensuales() {
        return oyentesMensuales;
    }

    public void setOyentesMensuales(Long oyentesMensuales) {
        this.oyentesMensuales = oyentesMensuales;
    }

	@Override
	public String toString() {
		return "Artista [idArtista=" + idArtista + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad
				+ ", oyentesMensuales=" + oyentesMensuales + ", canciones=" + canciones + "]";
	}
    
}