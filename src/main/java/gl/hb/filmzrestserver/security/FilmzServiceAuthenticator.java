package gl.hb.filmzrestserver.security;

import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.basic.BasicCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.logging.LogManager;

/**
 * Created by Homer on 23.04.2017.
 */
public class FilmzServiceAuthenticator implements Authenticator<BasicCredentials, FilmzServiceUser> {
    private Logger logger = LoggerFactory.getLogger(FilmzServiceAuthenticator.class);
    @Override
    public Optional<FilmzServiceUser> authenticate(BasicCredentials credentials)  {
        if ("secret".equals(credentials.getPassword())) {
            logger.debug("Authentication success.");
            return Optional.of(new FilmzServiceUser(credentials.getUsername()));
        }
        logger.debug("Authentication fail.");
        return Optional.empty();
    }
}
