package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.Course;
import hashwork.repository.ui.training.CourseRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseRepositoryImpl implements CourseRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, Course> lists = redisson.getMap("addresstype");

    @Override
    public Course findById(String s) {
        return lists.get(s);
    }

    @Override
    public Course save(Course entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public Course update(Course entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(Course entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<Course> findAll() {
        Set<Course> set = new HashSet<>();
        for (Map.Entry<String, Course> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
