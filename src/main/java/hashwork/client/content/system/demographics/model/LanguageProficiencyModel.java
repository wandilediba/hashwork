package hashwork.client.content.system.demographics.model;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/18.
 */
public class LanguageProficiencyModel implements Serializable {
    @NotNull
    private String proficiency;

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }
}
