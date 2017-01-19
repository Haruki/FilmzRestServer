package gl.hb.filmzrestserver.resources;

import com.codahale.metrics.annotation.Timed;
import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.dao.FilmzDao;
import gl.hb.filmzrestserver.dao.mapper.FilmzMapper;
import gl.hb.filmzrestserver.resources.beans.FilmzBean;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Homer on 08.01.2017.
 */
@Path("/filmz")
@Produces(MediaType.APPLICATION_JSON)
public class FilmzResource {

    private Logger logger = LoggerFactory.getLogger(FilmzResource.class);

    private FilmzDao filmzDao;

    public FilmzResource(FilmzDao filmzDao) {
        logger.debug("Instanciated: FilmzResource.");
        this.filmzDao = filmzDao;
    }

    @GET
    @Timed
    @Path("/{movieid}")
    public Film getFilmById(@PathParam("movieid") Optional<Integer> id) {
        logger.debug("Triggered: getFilmById.");
        return filmzDao.findFilmById(id.orElse(1));

    }

    @GET
    @Timed
    @Path("/find")
    public Film getFilmByImdbCode(@QueryParam("imdbCode") Optional<String> imdbCode) {
        logger.debug("Triggered: getFilmByImdbCode");
        return filmzDao.findFilmByImdbCode(imdbCode.get());
    }

    @PUT
    @Timed
    @Path("/{movieid}/seen")
    public Film setSeen(@PathParam("movieid") Optional<Integer> id) {
        logger.debug("Triggered: setSeen.");
        if (id.isPresent()) {
            filmzDao.setSeenById(id.get());
            return filmzDao.findFilmById(id.get());
        } else {
            return null;
        }
    }

    @POST
    @Timed
    public void insertFilm(@BeanParam FilmzBean filmzBean) {
        logger.debug("Triggered: insertFilm.");
        this.filmzDao.insertFilm(filmzBean.imdbCode.orElse(null),
                filmzBean.imdbRating.orElse(null),
                filmzBean.nameOriginal.orElse(null),
                filmzBean.nameDeutsch.orElse(null),
                LocalDate.parse(filmzBean.releaseDate.orElse(null)));
    }
}
