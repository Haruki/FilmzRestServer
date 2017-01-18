package gl.hb.filmzrestserver.dao.mapper;

import gl.hb.filmzrestserver.api.Film;
import gl.hb.filmzrestserver.api.Tvshow;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Asterix on 18.01.2017.
 */
public class TvshowsMapper  implements ResultSetMapper<Tvshow>{
    Logger logger = LoggerFactory.getLogger(FilmzMapper.class);

    public Tvshow map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        logger.debug("Start manual DB->JAVA conversion of Tvshows...");
        return new Tvshow(r.getInt("ID"),
                r.getString("NAME"),
                r.getString("NAME_ORIGINAL"),
                r.getString("IMDB_CODE"),
                r.getFloat("IMDB_RATING"),
                r.getDate("CREATION_DATE").toLocalDate(),
                r.getBoolean("FINISHED"));
    }
}

