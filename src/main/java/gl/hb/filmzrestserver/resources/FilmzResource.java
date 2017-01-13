package gl.hb.filmzrestserver.resources;

import com.codahale.metrics.annotation.Timed;
import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.dao.FilmzDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

/**
 * Created by Homer on 08.01.2017.
 */
@Path("/filmz/{movieid}")
@Produces(MediaType.APPLICATION_JSON)
public class FilmzResource {
    private final FilmzDao filmzDao;

    public FilmzResource(FilmzDao filmzDao) {
        this.filmzDao = filmzDao;
    }

    @GET
    @Timed
    public Film sayHello(@PathParam("movieid") Optional<Integer> id) {
        String nameDeutsch = filmzDao.findFilmById(id.orElse(1));
        return new Film(nameDeutsch);
    }
}
