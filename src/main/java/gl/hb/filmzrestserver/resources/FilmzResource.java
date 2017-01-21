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
import javax.ws.rs.core.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
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
        Film result = filmzDao.findFilmById(id.orElse(1));
        if (result != null) {
            return result;
        } else {
            throw new WebApplicationException(404);
        }

    }

    @GET
    @Timed
    @Path("/find")
    public Film getFilmByImdbCode(@QueryParam("imdbCode") Optional<String> imdbCode) {
        logger.debug("Triggered: getFilmByImdbCode");
        Film result = filmzDao.findFilmByImdbCode(imdbCode.get());
        if (result != null) {
            return result;
        } else {
            throw new WebApplicationException(404);
        }
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
    public Response insertFilm(@BeanParam FilmzBean filmzBean, @Context UriInfo uriInfo) {
        logger.debug("Triggered: insertFilm.");
        if (filmzBean.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        String releaseDateUnixTime = filmzBean.releaseDate.orElse(null);
        Long releaseDateLong = Long.parseLong(releaseDateUnixTime);
        LocalDate releaseDate;
        if (releaseDateUnixTime != null) {
            releaseDate =
                    Instant.ofEpochMilli(releaseDateLong).atZone(ZoneId.systemDefault()).toLocalDate();
        } else {
            throw new WebApplicationException("releaseDate is invalid", 400);
        }
        this.filmzDao.insertFilm(filmzBean.imdbCode.orElse(null),
                filmzBean.imdbRating.orElse(null),
                filmzBean.nameOriginal.orElse(null),
                filmzBean.nameDeutsch.orElse(null),
                releaseDate);
        Film film = filmzDao.findFilmByImdbCode(filmzBean.imdbCode.get());
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(film.getMovieId()));
        return Response.created(builder.build()).entity(film).build();
    }
}
