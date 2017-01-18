package gl.hb.filmzrestserver.dao;

import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.api.Tvshow;
import gl.hb.filmzrestserver.dao.mapper.TvshowsMapper;
import gl.hb.filmzrestserver.dao.util.LocalDateBinder;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.time.LocalDate;

/**
 * Created by Asterix on 18.01.2017.
 */
@RegisterMapper(TvshowsMapper.class)
public interface TvshowsDao {
    @SqlUpdate("insert into BESTFILMZ.TVSHOWS(NAME, NAME_ORIGINAL, IMDB_CODE, IMDB_RATING) VALUES (:name, :nameOriginal, :imdbCode, :imdbRating)")
    void insertTvshow(@Bind("name") String name,
                    @Bind("nameOriginal") String nameOriginal,
                    @Bind("imdbCode") String imdbCode,
                    @Bind("imdbRating") String imdbRating);

    @SqlQuery("select * from tvshows where id = :id")
    Tvshow findTvshowById(@Bind("id") int id);

    @SqlUpdate("update tvshow set finished = 1 where id = :id")
    void setFinishedById(@Bind("id") Integer id);

}
