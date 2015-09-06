package hashwork.factories.ui.job;

import hashwork.app.util.KeyGenerator;
import hashwork.domain.ui.job.JobApplicant;

/**
 * Created by zamzam on 15/09/06.
 */
public class JobApplicantFactory {
    public static JobApplicant getJobApplicant(String applicantId){
        JobApplicant jobApplicant = new JobApplicant
                .Builder()
                .id(KeyGenerator.getEntityId())
                .applicationId(applicantId).build();
        return jobApplicant;
    }
}
