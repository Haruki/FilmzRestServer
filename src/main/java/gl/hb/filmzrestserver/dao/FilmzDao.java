package gl.hb.filmzrestserver.dao;

import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.dao.mapper.FilmzMapper;
import gl.hb.filmzrestserver.dao.util.LocalDateBinder;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.time.LocalDate;

/**
 * Created by Asterix on 13.01.2017.
 */
@RegisterMapper(FilmzMapper.class)
public interface FilmzDao {
    @SqlUpdate("insert into BESTFILMZ.FILMZ(IMDB_CODE, IMDB_RATING, NAME_ORIGINAL, NAME_DEUTSCH, RELEASE_DATE) VALUES (:imdbCode, :imdbRating, :nameOriginal, :nameDeutsch, :releaseDate)")
    void insertFilm(@Bind("imdbCode") String imdbcode,
                    @Bind("imdbRating") float imdbRating,
                    @Bind("nameOriginal") String nameOriginal,
                    @Bind("nameDeutsch") String nameDeutsch,
                    @Bind(value = "releaseDate", binder = LocalDateBinder.class) LocalDate releaseDate);

    @SqlQuery("select * from filmz where movieid = :id")
    Film findFilmById(@Bind("id") int id);

    @SqlUpdate("update filmz set seen = 'true' where movieid = :id")
    void setSeenById(@Bind("id") Integer movieid);

    @SqlQuery("select * from filmz where imdb_code = :imdbCode")
    Film findFilmByImdbCode(@Bind("imdbCode") String imdbCode);
}
