package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.Job;

import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class JobFactory {
    public static Job getJob(Map<String, String> values) {
        Job job = new Job
                .Builder()
                .id(KeyGenerator.getEntityId())
                .title(values.get("title"))
                .code(values.get("code"))
                .description(values.get("desc"))
                .salaryGradeId(values.get("salaryGradeId"))
                .jobClassificationId(values.get("jobClassId"))
                .build();
        return job;
    }
}
