package api.v1.resources;
import beans.StatisticsBean;
import com.kumuluz.ee.logs.cdi.Log;
import dtos.Count;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Log
@ApplicationScoped
@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StatisticsResource {

    @Inject
    private StatisticsBean statisticsBean;

    @GET
    @Path("usercount")
    public Response getUserCount(){
        int count = statisticsBean.getUserCount();
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

    @GET
    @Path("songcount")
    public Response getSongCount(){
        int count = statisticsBean.getSongCount();
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

    @GET
    @Path("songcountgenre/{genreId}")
    public Response getSongCountbyGenre(@PathParam("genreId") int genreId){
        int count = statisticsBean.getSongCountbyGenre(genreId);
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

    @GET
    @Path("songcountartist/{artistId}")
    public Response getSongCountbyArtist(@PathParam("artistId") int artistId){
        int count = statisticsBean.getSongCountbyArtist(artistId);
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

    @GET
    @Path("playlistcount")
    public Response getPlaylistCount(){
        int count = statisticsBean.getPlaylistCount();
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

    @GET
    @Path("playlistcountuser/{userId}")
    public Response getPlaylistCountbyUser(@PathParam("userId") int userId){
        int count = statisticsBean.getPlaylistCountbyUser(userId);
        if (count==-1){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(new Count(count)).build();
    }

}
