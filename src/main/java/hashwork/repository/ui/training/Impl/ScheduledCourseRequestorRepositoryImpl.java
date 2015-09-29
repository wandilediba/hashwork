package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.ScheduledCourseRequestor;
import hashwork.repository.ui.training.ScheduledCourseRequestorRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseRequestorRepositoryImpl implements ScheduledCourseRequestorRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ScheduledCourseRequestor> lists = redisson.getMap("scheduledCourseRequestor");

    @Override
    public ScheduledCourseRequestor findById(String s) {
        return lists.get(s);
    }

    @Override
    public ScheduledCourseRequestor save(ScheduledCourseRequestor entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ScheduledCourseRequestor update(ScheduledCourseRequestor entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ScheduledCourseRequestor entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ScheduledCourseRequestor> findAll() {
        Set<ScheduledCourseRequestor> set = new HashSet<>();
        for (Map.Entry<String, ScheduledCourseRequestor> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
