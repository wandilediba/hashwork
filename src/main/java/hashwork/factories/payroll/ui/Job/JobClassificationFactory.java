package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.JobClassification;

import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class JobClassificationFactory {
    public static JobClassification getJobClassification(Map<String,String> values){
        JobClassification jobClassification = new JobClassification
                .Builder()
                .id(KeyGenerator.getEntityId())
                .currentTitle(values.get("currTitle"))
                .oldTitle(values.get("oldTitle"))
                .oldCode(values.get("oldCode"))
                .currentCode(values.get("currCode"))
                .codeConversion(values.get("codeConvo"))
                .comment(values.get("comment")).build();
        return jobClassification;

   }
}
