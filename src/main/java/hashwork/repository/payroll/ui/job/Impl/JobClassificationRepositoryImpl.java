package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.JobClassification;
import hashwork.repository.payroll.ui.job.JobClassificationRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class JobClassificationRepositoryImpl implements JobClassificationRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, JobClassification> lists = redisson.getMap("JobClassification");

    @Override
    public JobClassification findById(String s) {
        return lists.get(s);
    }

    @Override
    public JobClassification save(JobClassification entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public JobClassification update(JobClassification entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(JobClassification entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<JobClassification> findAll() {
        Set<JobClassification> set = new HashSet<>();
        for (Map.Entry<String, JobClassification> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
