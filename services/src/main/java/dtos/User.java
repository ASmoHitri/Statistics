package dtos;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"username", "mail", "password", "passwordSalt", "artistId"})
public class User {
    private int id;
    private Boolean isActive;

    public int getId() {
        return id;
    }

    public Boolean getActive() {
        return isActive;
    }
}
