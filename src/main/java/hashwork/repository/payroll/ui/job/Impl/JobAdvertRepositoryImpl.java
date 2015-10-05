package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.JobAdvert;
import hashwork.repository.payroll.ui.job.JobAdvertRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class JobAdvertRepositoryImpl implements JobAdvertRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, JobAdvert> lists = redisson.getMap("JobAdvert");

    @Override
    public JobAdvert findById(String s) {
        return lists.get(s);
    }

    @Override
    public JobAdvert save(JobAdvert entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public JobAdvert update(JobAdvert entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(JobAdvert entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<JobAdvert> findAll() {
        Set<JobAdvert> set = new HashSet<>();
        for (Map.Entry<String, JobAdvert> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
