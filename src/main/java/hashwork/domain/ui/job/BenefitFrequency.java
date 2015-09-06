package hashwork.domain.ui.job;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/08/16.
 */
public class BenefitFrequency implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    //Anual , Weekly, Monthly etc
    private String frequency;

    public String getId() {
        return id;
    }

    public String getFrequency() {
        return frequency;
    }
}
