package dtos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties({"name", "songs"})
public class Playlist {
    private int id;
    private int userId;

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }
}