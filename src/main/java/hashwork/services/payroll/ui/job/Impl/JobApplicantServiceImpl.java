package hashwork.services.payroll.ui.job.Impl;

import hashwork.domain.payroll.ui.job.JobApplicant;
import hashwork.repository.payroll.ui.job.Impl.JobApplicantRepositoryImpl;
import hashwork.services.payroll.ui.job.JobApplicantService;

import java.util.Set;

/**
 * Created by zamzam on 15/09/15.
 */
public class JobApplicantServiceImpl implements JobApplicantService {

    @Override
    public JobApplicant findById(String id) {
        return new JobApplicantRepositoryImpl().findById(id);
    }

    @Override
    public JobApplicant save(JobApplicant entity) {
        return new JobApplicantRepositoryImpl().save(entity);
    }

    @Override
    public JobApplicant update(JobApplicant entity) {
        return new JobApplicantRepositoryImpl().update(entity);
    }

    @Override
    public void delete(JobApplicant entity) {
        new JobApplicantRepositoryImpl().delete(entity);

    }

    @Override
    public Set<JobApplicant> findAll() {
        return new JobApplicantRepositoryImpl().findAll();
    }
}
