package gl.hb.filmzrestserver;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by Homer on 08.01.2017.
 */
public class MainApplication extends Application<FilmzRestServerConfiguration> {

    public static void main(String[] args) throws Exception {
        new MainApplication().run(args);
    }

    @Override
    public String getName() {
        return "FilmzRestServer";
    }

    @Override
    public void initialize(Bootstrap<FilmzRestServerConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(FilmzRestServerConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
    }

}
