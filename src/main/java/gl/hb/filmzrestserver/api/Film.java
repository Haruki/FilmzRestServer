package gl.hb.filmzrestserver.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Created by Asterix on 13.01.2017.
 */
public class Film {

    Logger logger = LoggerFactory.getLogger(Film.class);

    @Length(max = 80)
    private String nameDeutsch;

    @Length(max = 80)
    private String nameOriginal;

    private LocalDate createTime;

    private LocalDate seenTime;

    private Boolean seen;

    private LocalDate releaseDate;

    private Float imdbRating;

    private String imdbCode;

    private Integer movieId;

    @JsonProperty
    public LocalDate getCreateTime() {
        return createTime;
    }

    @JsonProperty
    public LocalDate getSeenTime() {
        return seenTime;
    }

    @JsonProperty
    public Boolean getSeen() {
        return seen;
    }

    @JsonProperty
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty
    public Float getImdbRating() {
        return imdbRating;
    }

    @JsonProperty
    public String getImdbCode() {
        return imdbCode;
    }

    @JsonProperty
    public Integer getMovieId() {
        return movieId;
    }

    @JsonProperty
    public String getNameDeutsch() {
        return nameDeutsch;
    }

    @JsonProperty
    public String getNameOriginal() {
        return nameOriginal;
    }


    public Film(String nameDeutsch,
                String nameOriginal,
                LocalDate createTime,
                LocalDate seenTime,
                Boolean seen,
                LocalDate releaseDate,
                Float imdbRating,
                String imdbCode,
                Integer movieId) {
        logger.debug("Creating Film instance...");
        this.nameDeutsch = nameDeutsch;
        this.nameOriginal = nameOriginal;
        this.createTime = createTime;
        this.seenTime = seenTime;
        this.seen = seen;
        this.releaseDate = releaseDate;
        this.imdbRating = imdbRating;
        this.imdbCode = imdbCode;
        this.movieId = movieId;
    }
}
