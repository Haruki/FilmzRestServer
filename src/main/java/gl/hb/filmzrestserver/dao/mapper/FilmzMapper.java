package gl.hb.filmzrestserver.dao.mapper;

import gl.hb.filmzrestserver.api.Film;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Asterix on 14.01.2017.
 */
public class FilmzMapper implements ResultSetMapper<Film> {

    Logger logger = LoggerFactory.getLogger(FilmzMapper.class);

    public Film map(int index, ResultSet r, StatementContext ctx) throws SQLException {
       logger.debug("Start manual DB->JAVA conversion of Filmz...");
       return new Film(r.getString("NAME_DEUTSCH"),
               r.getString("NAME_ORIGINAL"),
               r.getDate("CREATE_TIME").toLocalDate(),
               r.getDate("SEEN_TIME").toLocalDate(),
               r.getString("SEEN").equals("true")? true : false,
               r.getDate("RELEASE_DATE").toLocalDate(),
               r.getFloat("IMDB_RATING"),
               r.getString("IMDB_CODE"),
               r.getInt("MOVIEID"));
    }
}
