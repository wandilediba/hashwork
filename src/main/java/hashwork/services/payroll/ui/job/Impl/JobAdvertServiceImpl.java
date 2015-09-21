package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.JobAdvert;
import hashwork.repository.payroll.ui.job.Impl.JobAdvertRepositoryImpl;
import hashwork.services.payroll.ui.job.JobAdvertService;
import hashwork.services.payroll.ui.job.JobService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class JobAdvertServiceImpl implements JobAdvertService {

    @Override
    public JobAdvert findById(String id) {
        return new JobAdvertRepositoryImpl().findById(id);
    }

    @Override
    public JobAdvert save(JobAdvert entity) {
        return new JobAdvertRepositoryImpl().save(entity);
    }

    @Override
    public JobAdvert update(JobAdvert entity) {
        return new JobAdvertRepositoryImpl().update(entity);
    }

    @Override
    public void delete(JobAdvert entity) {
        new JobAdvertRepositoryImpl().delete(entity);

    }

    @Override
    public Set<JobAdvert> findAll() {
        return new JobAdvertRepositoryImpl().findAll();
    }
}
