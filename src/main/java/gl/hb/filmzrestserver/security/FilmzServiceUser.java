package gl.hb.filmzrestserver.security;

import javax.security.auth.Subject;
import java.security.Principal;

/**
 * Created by Homer on 23.04.2017.
 */
public class FilmzServiceUser implements Principal {

    private final String name;

    public FilmzServiceUser(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }
}
