package gl.hb.filmzrestserver.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

/**
 * Created by Asterix on 18.01.2017.
 */
public class Tvshow {

    private Logger logger = LoggerFactory.getLogger(Tvshow.class);

    private Integer id;
    private String name;
    private String nameOriginal;
    private String imdbCode;
    private Float imdbRating;
    private LocalDate creationTime;
    private boolean finished; //ob die Serie vollständig abgeschlossen ist (keine weiteren Staffeln)

    public Tvshow(Integer id,
                  String name,
                  String nameOriginal,
                  String imdbCode,
                  Float imdbRating,
                  LocalDate creationTime,
                  Boolean finished) {
        this.name = name;
        this.nameOriginal = nameOriginal;
        this.imdbCode = imdbCode;
        this.imdbRating = imdbRating;
        this.creationTime = creationTime;
    }



    @JsonProperty
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getNameOriginal() {
        return nameOriginal;
    }

    @JsonProperty
    public String getImdbCode() {
        return imdbCode;
    }

    @JsonProperty
    public Float getImdbRating() {
        return imdbRating;
    }

    @JsonProperty
    public LocalDate getCreationTime() {
        return creationTime;
    }

    @JsonProperty
    public boolean isFinished() {
        return finished;
    }
}


