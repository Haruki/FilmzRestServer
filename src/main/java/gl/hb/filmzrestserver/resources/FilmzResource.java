package gl.hb.filmzrestserver.resources;

import com.codahale.metrics.annotation.Timed;
import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.api.Saying;
import gl.hb.filmzrestserver.dao.FilmzDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Homer on 08.01.2017.
 */
@Path("/filmz")
@Produces(MediaType.APPLICATION_JSON)
public class FilmzResource {
    private final FilmzDao filmzDao;

    public FilmzResource(FilmzDao filmzDao) {
        this.filmzDao = filmzDao;
    }

    @GET
    @Timed
    public Film sayHello(@QueryParam("id") Optional<Integer> id) {
        String nameDeutsch = filmzDao.findFilmById(id.orElse(1));
        return new Film(nameDeutsch);
    }
}
