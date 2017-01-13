package gl.hb.filmzrestserver.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

/**
 * Created by Asterix on 13.01.2017.
 */
public interface FilmzDao {
    @SqlUpdate("insert into bestfilmz.filmz (id, name) values (:id, :name)")
    void insertFilm(@Bind("id") int id, @Bind("name") String name);

    @SqlQuery("select name_deutsch from filmz where movieid = :id")
    String findFilmById(@Bind("id") int id);
}
