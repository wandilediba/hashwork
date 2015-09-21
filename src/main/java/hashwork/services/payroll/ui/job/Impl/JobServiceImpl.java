package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.Job;
import hashwork.repository.payroll.ui.job.Impl.JobRepositoryImpl;
import hashwork.services.payroll.ui.job.JobService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class JobServiceImpl implements JobService {

    @Override
    public Job findById(String id) {
        return new JobRepositoryImpl().findById(id);
    }

    @Override
    public Job save(Job entity) {
        return new JobRepositoryImpl().save(entity);
    }

    @Override
    public Job update(Job entity) {
        return new JobRepositoryImpl().update(entity);
    }

    @Override
    public void delete(Job entity) {
        new JobRepositoryImpl().delete(entity);

    }

    @Override
    public Set<Job> findAll() {
        return new JobRepositoryImpl().findAll();
    }
}
