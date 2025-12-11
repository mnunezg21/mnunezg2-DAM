package modelo;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cancion")
public class Cancion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cancion")
    private int idCancion;

    @Column(name = "titulo", nullable = false, length = 150)
    private String titulo;

    @Column(name = "duracion_segundos", nullable = false)
    private int duracionSegundos;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_artista", nullable = true)
    private Artista artista;

    @OneToOne(mappedBy = "cancion", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private MetadatosCancion metadatos;


    @OneToMany(mappedBy = "cancion", fetch = FetchType.LAZY)
    private Set<PlaylistCancion> items = new HashSet<>();
    
    public Cancion() {}

    public Cancion(String titulo, int duracionSegundos) {
        this.titulo = titulo;
        this.duracionSegundos = duracionSegundos;
    }
    
    public void setMetadatos(MetadatosCancion metadatos) {
        if (metadatos != null) {
            metadatos.setCancion(this);
        }
        this.metadatos = metadatos;
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public MetadatosCancion getMetadatos() {
        return metadatos;
    }

    public Set<PlaylistCancion> getItems() {
        return items;
    }

    public void setItems(Set<PlaylistCancion> items) {
        this.items = items;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracionSegundos() {
        return duracionSegundos;
    }

    public void setDuracionSegundos(int duracionSegundos) {
        this.duracionSegundos = duracionSegundos;
    }

	@Override
	public String toString() {
		return "Cancion [idCancion=" + idCancion + ", titulo=" + titulo + ", duracionSegundos=" + duracionSegundos
				+ ", artista=" + (artista != null ? artista.getNombre() : "N/A") + "]"; // Ajuste para evitar recursión/LazyInit
	}
}