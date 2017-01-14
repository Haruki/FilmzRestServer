package gl.hb.filmzrestserver.resources.beans;

import javax.swing.text.html.Option;
import javax.ws.rs.QueryParam;
import java.util.Optional;

/**
 * Created by Asterix on 13.01.2017.
 */
public class FilmzBean {
    @QueryParam("nameDeutsch")
    public Optional<String> nameDeutsch;

    @QueryParam("nameOriginal")
    public Optional<String> nameOriginal;

    @QueryParam("imdbRating")
    public Optional<Float> imdbRating;

    @QueryParam("imdbCode")
    public Optional<String> imdbCode;

    @QueryParam("releaseDate")
    public Optional<String> releaseDate;
}
