package modelo;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "playlist")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_playlist")
    private int idPlaylist; 

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "creador", length = 50)
    private String creador;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PlaylistCancion> items = new HashSet<>(); 

    public Playlist() {}

    public Playlist(String nombre, String creador, LocalDate fechaCreacion) {
        this.nombre = nombre;
        this.creador = creador;
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarCancion(Cancion cancion, int orden) {
        PlaylistCancion item = new PlaylistCancion(this, cancion, orden);
        this.items.add(item);
    }
   
    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public Set<PlaylistCancion> getItems() {
        return items;
    }

    public void setItems(Set<PlaylistCancion> items) {
        this.items = items;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	@Override
	public String toString() {
		return "Playlist [idPlaylist=" + idPlaylist + ", nombre=" + nombre + ", creador=" + creador + ", fechaCreacion="
				+ fechaCreacion + "]";
	}
    
}