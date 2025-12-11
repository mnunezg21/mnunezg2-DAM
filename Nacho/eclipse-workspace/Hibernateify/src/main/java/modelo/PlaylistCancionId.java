package modelo;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlaylistCancionId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer playlistId;
    private Integer cancionId;

    public PlaylistCancionId() {}

    public PlaylistCancionId(Integer playlistId, Integer cancionId) {
        this.playlistId = playlistId;
        this.cancionId = cancionId;
    }

    public Integer getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Integer playlistId) {
        this.playlistId = playlistId;
    }

    public Integer getCancionId() {
        return cancionId;
    }

    public void setCancionId(Integer cancionId) {
        this.cancionId = cancionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaylistCancionId that = (PlaylistCancionId) o;
        return Objects.equals(playlistId, that.playlistId) &&
               Objects.equals(cancionId, that.cancionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playlistId, cancionId);
    }

	@Override
	public String toString() {
		return "PlaylistCancionId [playlistId=" + playlistId + ", cancionId=" + cancionId + "]";
	}
}