package modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "playlist_cancion")
public class PlaylistCancion {

    @EmbeddedId
    private PlaylistCancionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("playlistId") 
    @JoinColumn(name = "id_playlist")
    private Playlist playlist;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("cancionId")
    @JoinColumn(name = "id_cancion")
    private Cancion cancion;

    @Column(name = "orden")
    private Integer orden;

    public PlaylistCancion() {}

    public PlaylistCancion(Playlist playlist, Cancion cancion, Integer orden) {
        this.playlist = playlist;
        this.cancion = cancion;
        this.orden = orden;
        //Clave compuesta
        this.id = new PlaylistCancionId(playlist.getIdPlaylist(), cancion.getIdCancion());
    }

    public PlaylistCancionId getId() {
        return id;
    }

    public void setId(PlaylistCancionId id) {
        this.id = id;
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

	@Override
	public String toString() {
		return "PlaylistCancion [id=" + id + ", playlist=" + playlist + ", cancion=" + cancion + ", orden=" + orden
				+ "]";
	}
}