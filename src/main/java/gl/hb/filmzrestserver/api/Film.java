package gl.hb.filmzrestserver.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

/**
 * Created by Asterix on 13.01.2017.
 */
public class Film {
    @Length(max = 80)
    private String nameDeutsch;

    public Film(String nameDeutsch) {
        this.nameDeutsch = nameDeutsch;
    }

    @JsonProperty
    public String getNameDeutsch() {
        return nameDeutsch;
    }
}
