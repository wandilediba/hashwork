package hashwork.client.content.payroll.model;

import java.io.Serializable;

/**
 * Created by zamzam on 15/09/21.
 */
public class BenefitFrequencyModel implements Serializable {
    private String frequency;

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
}
