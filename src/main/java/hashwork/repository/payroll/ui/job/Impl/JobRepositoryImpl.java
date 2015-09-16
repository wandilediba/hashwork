package hashwork.repository.payroll.ui.job.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.payroll.ui.job.Job;
import hashwork.repository.payroll.ui.job.JobRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by zamzam on 15/09/12.
 */
public class JobRepositoryImpl implements JobRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Job> lists = redisson.getMap("Job");

    @Override
    public Job findById(String s) {
        return lists.get(s);
    }

    @Override
    public Job save(Job entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Job update(Job entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Job entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Job> findAll() {
        Set<Job> set = new HashSet<>();
        for (Map.Entry<String, Job> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
