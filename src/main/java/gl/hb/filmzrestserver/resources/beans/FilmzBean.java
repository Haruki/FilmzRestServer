package gl.hb.filmzrestserver.resources.beans;

import javax.swing.text.html.Option;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import java.util.Optional;

/**
 * Created by Asterix on 13.01.2017.
 */
public class FilmzBean {
    @FormParam("nameDeutsch")
    public Optional<String> nameDeutsch;

    @FormParam("nameOriginal")
    public Optional<String> nameOriginal;

    @FormParam("imdbRating")
    public Optional<Float> imdbRating;

    @FormParam("imdbCode")
    public Optional<String> imdbCode;

    @FormParam("releaseDate")
    public Optional<String> releaseDate;

    public boolean isEmpty() {
        return !(nameDeutsch.isPresent()
                && nameOriginal.isPresent()
                && imdbRating.isPresent()
                && imdbCode.isPresent()
                && releaseDate.isPresent());
    }
}
