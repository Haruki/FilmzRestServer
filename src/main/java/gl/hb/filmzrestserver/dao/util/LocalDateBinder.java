package gl.hb.filmzrestserver.dao.util;

import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.Binder;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Created by Asterix on 13.01.2017.
 */
public class LocalDateBinder implements Binder<Bind, LocalDate> {
    @Override
    public void bind(SQLStatement<?> q, Bind bind, LocalDate localDate) {
        q.bind(bind.value(), Date.valueOf(localDate));
    }
}
