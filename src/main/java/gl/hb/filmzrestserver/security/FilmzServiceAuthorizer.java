package gl.hb.filmzrestserver.security;

import io.dropwizard.auth.Authorizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

/**
 * Created by Homer on 23.04.2017.
 */
public class FilmzServiceAuthorizer implements Authorizer<FilmzServiceUser> {
    private Logger logger = LoggerFactory.getLogger(FilmzServiceAuthorizer.class);

    @Override
    public boolean authorize(FilmzServiceUser user, String role) {
        logger.debug(user.getName() + "  " + role);
        return user.getName().equals("good-guy") && role.equals("ADMIN");
    }
}
