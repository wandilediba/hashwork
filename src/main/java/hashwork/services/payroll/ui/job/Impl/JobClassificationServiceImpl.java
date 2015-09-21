package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.JobClassification;
import hashwork.repository.payroll.ui.job.Impl.JobClassificationRepositoryImpl;
import hashwork.services.payroll.ui.job.JobClassificationService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class JobClassificationServiceImpl implements JobClassificationService {
    @Override
    public JobClassification findById(String id) {
        return new JobClassificationRepositoryImpl().findById(id);
    }

    @Override
    public JobClassification save(JobClassification entity) {
        return new JobClassificationRepositoryImpl().save(entity);
    }

    @Override
    public JobClassification update(JobClassification entity) {
        return new JobClassificationRepositoryImpl().update(entity);
    }

    @Override
    public void delete(JobClassification entity) {
        new JobClassificationRepositoryImpl().delete(entity);

    }

    @Override
    public Set<JobClassification> findAll() {
        return new JobClassificationRepositoryImpl().findAll();
    }
}
