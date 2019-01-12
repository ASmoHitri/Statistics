package beans;

import com.kumuluz.ee.discovery.annotations.DiscoverService;
import dtos.Song;
import dtos.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriInfo;
import java.util.*;

@ApplicationScoped
public class StatisticsBean {

    @Context
    protected UriInfo uriInfo;

    private Client httpClient = ClientBuilder.newClient();

    @Inject
    @DiscoverService("microservice-catalogs")
    private Optional<String> basePathCatalogs;

    @Inject
    @DiscoverService("microservice-subscriptions")
    private Optional<String> basePathSubscriptions;

    public int getUserCount(){
        if(basePathSubscriptions.isPresent()) {
            try {
                List<User> users = httpClient.target(basePathSubscriptions.get() + "/api/v1/users")
                        .request().get(new GenericType<List<User>>() {
                        });
                return users.size();
            } catch (WebApplicationException | ProcessingException exception) {
                System.out.println(exception.getMessage());
                return -1;
            }
        }
        return -1;
    }

    public int getSongCount() {
        if (basePathCatalogs.isPresent()) {
            try {
                List<Song> songs = httpClient.target(basePathSubscriptions.get() + "/api/v1/songs")
                        .request().get(new GenericType<List<Song>>() {
                        });
                return songs.size();
            } catch (WebApplicationException | ProcessingException exception) {
                System.out.println(exception.getMessage());
                return -1;
            }
        }
        return -1;
    }

    public int getSongbyGenre(int genreId){
        if (basePathCatalogs.isPresent()) {
            try {
                List<Song> songs = httpClient.target(basePathSubscriptions.get() + "/api/v1/songs?where=genre.id:EQ:" + genreId)
                        .request().get(new GenericType<List<Song>>() {
                        });
                return songs.size();
            } catch (WebApplicationException | ProcessingException exception) {
                System.out.println(exception.getMessage());
                return -1;
            }
        }
        return -1;

    }

    public int getSongbyArtist(int artistId){
        if (basePathCatalogs.isPresent()) {
            try {
                List<Song> songs = httpClient.target(basePathSubscriptions.get() + "/api/v1/songs?where=artist.id:EQ:" + artistId)
                        .request().get(new GenericType<List<Song>>() {
                        });
                return songs.size();
            } catch (WebApplicationException | ProcessingException exception) {
                System.out.println(exception.getMessage());
                return -1;
            }
        }
        return -1;

    }
}