package hashwork.factories.ui.job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.job.Job;

import java.util.List;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class JobFactory {
    public static Job getJob(Map<String,String> values,
                             List<String> posIds){
     /*   Job job = new Job
                .Builder()
                .id(KeyGenerator.getEntityId())
                .title(values.get("title"))
                .code(values.get("code"))
                .description(values.get("desc"))
                .salaryGradeId(values.get("salaryGradeId"))
                .jobClassificationId(values.get("jobClassId"))
                .positionIds(posIds);*/
        return null;
    }
}
