package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.JobApplicant;
import hashwork.repository.payroll.ui.job.JobApplicantRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class JobApplicantRepositoryImpl implements JobApplicantRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, JobApplicant> lists = redisson.getMap("JobApplicant");

    @Override
    public JobApplicant findById(String s) {
        return lists.get(s);
    }

    @Override
    public JobApplicant save(JobApplicant entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public JobApplicant update(JobApplicant entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(JobApplicant entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<JobApplicant> findAll() {
        Set<JobApplicant> set = new HashSet<>();
        for (Map.Entry<String, JobApplicant> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
