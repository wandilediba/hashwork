package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.ScheduledCourse;
import hashwork.repository.ui.training.ScheduledCourseRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseRepositoryImpl implements ScheduledCourseRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ScheduledCourse> lists = redisson.getMap("scheduledCourse");

    @Override
    public ScheduledCourse findById(String s) {
        return lists.get(s);
    }

    @Override
    public ScheduledCourse save(ScheduledCourse entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ScheduledCourse update(ScheduledCourse entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ScheduledCourse entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ScheduledCourse> findAll() {
        Set<ScheduledCourse> set = new HashSet<>();
        for (Map.Entry<String, ScheduledCourse> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
