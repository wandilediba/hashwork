package hashwork.client.content.system.jobs.model;

import java.io.Serializable;

/**
 * Created by hashcode on 2015/09/16.
 */
public class BenefitFrequencyModel implements Serializable {

    private static final long serialVersionUID = 1L;

    //Anual , Weekly, Monthly etc
    private String frequency;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
