package hashwork.factories.payroll.ui.Job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.payroll.ui.job.JobAdvert;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by zamzam on 15/09/06.
 */
public class JobAdvertFactory {
    public static JobAdvert getJobAdvert(Map<String,String> values,
                                         Map<String,Date> dates,
                                         List<String> applicantsIds){
        JobAdvert jobAdvert = new JobAdvert
               .Builder()
                .Id(KeyGenerator.getEntityId())
                .jobId(values.get("jobId"))
                .start(dates.get("start"))
                .closingDate(dates.get("closingDate"))
                .description(values.get("description"))
                .active(values.get("active"))
                .applicantsIds(applicantsIds).build();
        return jobAdvert;
    }
}
