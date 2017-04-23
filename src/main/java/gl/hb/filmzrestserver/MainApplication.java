package gl.hb.filmzrestserver;

import gl.hb.filmzrestserver.dao.FilmzDao;
import gl.hb.filmzrestserver.metrics.TemplateHealthCheck;
import gl.hb.filmzrestserver.resources.FilmzResource;
import gl.hb.filmzrestserver.security.FilmzServiceAuthenticator;
import gl.hb.filmzrestserver.security.FilmzServiceAuthorizer;
import gl.hb.filmzrestserver.security.FilmzServiceUser;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.jdbi.bundles.DBIExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Homer on 08.01.2017.
 */
public class MainApplication extends Application<FilmzRestServerConfiguration> {

    private Logger logger = LoggerFactory.getLogger(MainApplication.class);

    public static void main(String[] args) throws Exception {

        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "FilmzRestServer";
    }

    @Override
    public void initialize(Bootstrap<FilmzRestServerConfiguration> bootstrap) {
        logger.debug("FilmzRestServer initializing...");
        bootstrap.addBundle(new DBIExceptionsBundle());
    }

    @Override
    public void run(FilmzRestServerConfiguration configuration,
                    Environment environment) {
        //setup database:
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "oracle");
        final FilmzDao filmzDao = jdbi.onDemand(FilmzDao.class);
        //sonstiges:
        logger.debug("Starting FilmzRestServer...");
        final FilmzResource resource = new FilmzResource(filmzDao);
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<FilmzServiceUser>()
                        .setAuthenticator(new FilmzServiceAuthenticator())
                        .setAuthorizer(new FilmzServiceAuthorizer())
                        .setRealm("simpleauth1")
                        .buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);
        //If you want to use @Auth to inject a custom Principal type into your resource
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(FilmzServiceUser.class));
    }
}


