package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.BenefitFrequency;

/**
 * Created by zamzam on 15/09/06.
 */
public class BenefitFrequencyFactory {
    public static BenefitFrequency getBenefitFrequency(String frequency){
        BenefitFrequency benefitFrequency = new BenefitFrequency
                .Builder()
                .id(KeyGenerator.getEntityId())
                .frequency(frequency).build();
        return benefitFrequency;
    }
}
