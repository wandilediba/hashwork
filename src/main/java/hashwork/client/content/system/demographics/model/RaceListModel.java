package hashwork.client.content.system.demographics.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/18.
 */
public class RaceListModel implements Serializable {

    @NotNull
    private String raceName;

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }
}
