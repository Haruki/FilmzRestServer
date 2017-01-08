package gl.hb.filmzrestserver.resources;

import com.codahale.metrics.annotation.Timed;
import gl.hb.filmzrestserver.api.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Homer on 08.01.2017.
 */
@Path("/filmz")
@Produces(MediaType.APPLICATION_JSON)
public class FilmzResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public FilmzResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        final String value = String.format(template, name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(), value);
    }
}
