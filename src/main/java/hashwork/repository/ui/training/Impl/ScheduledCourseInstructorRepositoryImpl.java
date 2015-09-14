package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.ScheduledCourseInstructor;
import hashwork.repository.ui.training.ScheduledCourseInstructorRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class ScheduledCourseInstructorRepositoryImpl implements ScheduledCourseInstructorRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, ScheduledCourseInstructor> lists = redisson.getMap("addresstype");

    @Override
    public ScheduledCourseInstructor findById(String s) {
        return lists.get(s);
    }

    @Override
    public ScheduledCourseInstructor save(ScheduledCourseInstructor entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public ScheduledCourseInstructor update(ScheduledCourseInstructor entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(ScheduledCourseInstructor entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<ScheduledCourseInstructor> findAll() {
        Set<ScheduledCourseInstructor> set = new HashSet<>();
        for (Map.Entry<String, ScheduledCourseInstructor> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }

}
