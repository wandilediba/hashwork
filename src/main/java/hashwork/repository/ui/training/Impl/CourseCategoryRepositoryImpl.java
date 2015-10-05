package hashwork.repository.ui.training.Impl;

import hashwork.app.conf.Connection;
import hashwork.domain.ui.training.CourseCategory;
import hashwork.repository.ui.training.CourseCategoryRepository;
import org.redisson.Redisson;
import org.redisson.core.RMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by garran on 2015/09/13.
 */
public class CourseCategoryRepositoryImpl implements CourseCategoryRepository {
    Redisson redisson = Connection.getConnection();
    RMap<String, CourseCategory> lists = redisson.getMap("courseCategory");

    @Override
    public CourseCategory findById(String s) {
        return lists.get(s);
    }

    @Override
    public CourseCategory save(CourseCategory entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public CourseCategory update(CourseCategory entity) {
        return lists.put(entity.getId(), entity);
    }

    @Override
    public void delete(CourseCategory entity) {
        lists.remove(entity.getId());
    }

    @Override
    public Set<CourseCategory> findAll() {
        Set<CourseCategory> set = new HashSet<>();
        for (Map.Entry<String, CourseCategory> entry : lists.entrySet()) {
            set.add(entry.getValue());
        }
        return set;
    }
}
